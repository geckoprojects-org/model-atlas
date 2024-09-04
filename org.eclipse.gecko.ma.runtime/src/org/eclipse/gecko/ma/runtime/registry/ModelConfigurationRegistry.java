/**
 * Copyright (c) 2012 - 2024 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.eclipse.gecko.ma.runtime.registry;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;
import static org.eclipse.gecko.ma.MAConstants.DEFAULT_REGISTRY_PROPERTY;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.gecko.ma.annotations.PMConfigurator;
import org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler;
import org.eclipse.gecko.ma.api.init.ModelConfigurationRegistry;
import org.eclipse.gecko.ma.api.init.PackageModelConfigurationHandler;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.MaconfigPackage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.gecko.emf.repository.EMFRepository;
import org.gecko.util.emf.EcoreUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * There are two use-cases expected for registering a {@link PackageModelConfiguration}
 * * A configuration already has a {@link EPackage} assigned, when the EPackage comes from generated code or is registered via model extender
 * * A Configuration has no {@link EPackage} assigned, when a configuration was loaded out of the database and the EPackage registration happens with configuration data, like the dynamic package loader
 * 
 * Therefore these two cases are handled here:
 * Every configuration without any existing EPackage goes first to the config cache. It is important that 
 * corresponding EPackage registration based on such a configuration provide the 'ma.config.id' 
 * service property, with the configuration id. 
 * If the EPackages with these properties are injected, the configurations are removed from the cache and
 * finally registered with the EPackage data.
 * 
 * All configurations that already have an EPackage in it, are directly registered.
 *  
 * @author Mark Hoffmann
 * @since 05.08.2024
 */
//@Component(service = {Registry.class, ModelConfigurationLifecycleHandler.class}, immediate = true, property = DEFAULT_REGISTRY_PROPERTY)
public class ModelConfigurationRegistry extends HashMap<String, Object> implements Registry, ModelConfigurationLifecycleHandler {

	public static final String REF_REPO = "config.repo";
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Logger logger = System.getLogger(ModelConfigurationRegistry.class.getName());
	private final Map<String, PackageModelConfiguration> configCache = new ConcurrentHashMap<>();
	private final Map<String, String> configToNsMap = new ConcurrentHashMap<>();

	@Reference(name=REF_REPO)
	private EMFRepository backingRepo;
	@Reference
	private MaconfigPackage configPackage;

	private class ConfigurationHolder {
		EPackage ePackage;
		PackageModelConfiguration configuration;
	}
	
	@Deactivate
	public void deactivate() {
		
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EPackage.Registry#getEPackage(java.lang.String)
	 */
	@Override
	public EPackage getEPackage(String nsURI) {
		Object holder = get(nsURI);
		ConfigurationHolder configHolder = (ConfigurationHolder) holder;
		return configHolder.ePackage;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EPackage.Registry#getEFactory(java.lang.String)
	 */
	@Override
	public EFactory getEFactory(String nsURI) {
		EPackage ePackage = getEPackage(nsURI);
		return ePackage.getEFactoryInstance();
	}

	@Reference(name="packageRef", cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, target = "(ma.config.id=*)")
	public void addEPackage(EPackage ePackage, Map<String, Object> properties) {
		String configId = (String) properties.get("ma.config.id");
		if (isNull(configId)) {
			logger.log(Logger.Level.ERROR, "Received EPackage '%s' with invalid 'ma.config.id' property value", ePackage.getName());
			return;
		}
		PackageModelConfiguration configuration = null;
		synchronized (configCache) {
			configuration = configCache.remove(configId);
		}
		if (nonNull(configuration)) {
			registerEPackageAndConfig(ePackage, configuration);
		} else {
			logger.log(Level.ERROR, "Received EPackage '%s' with invalid 'ma.config.id' property value", ePackage.getName());
		}
	}
	
	public void removeEPackage(EPackage ePackage, Map<String, Object> properties) {
		
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	public void addConfigurator(PackageModelConfigurationHandler configurator) {
		synchronized (configurator) {
			configurators.add(configurator);
		}
	}

	public void removeConfigurator(PackageModelConfigurationHandler configurator) {
		synchronized (configurator) {
			configurators.remove(configurator);
		}
	}	

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler#updateLifeycle(org.eclipse.gecko.ma.config.PackageModelConfiguration, org.eclipse.gecko.ma.config.ConfigurationLifecycle)
	 */
	@Override
	public void updateLifeycle(PackageModelConfiguration configuration, ConfigurationLifecycle lifecycle) {
		requireNonNull(configuration);
		ConfigurationLifecycle latest = configuration.getLifecycle();
		if (isNull(lifecycle)) {
			lifecycle = ConfigurationLifecycle.LOADED;
		}
		if (!lifecycle.equals(latest)) {
			configuration.setLifecycle(lifecycle);
		}
		synchronized (lifeCycleCache) {
			lifeCycleCache.put(configuration.getId(), lifecycle);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler#updateLifeycle(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public void updateLifeycle(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		requireNonNull(configuration);
		updateLifeycle(configuration, configuration.getLifecycle());
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler#updateConfiguration(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public void updateConfiguration(PackageModelConfiguration newConfiguration) {
		requireNonNull(newConfiguration);
		PackageModelConfiguration current;
		synchronized (configCache) {
			current = configCache.get(newConfiguration.getId());
		}
		if (nonNull(current)) {
			// configurations are not the same and have different content
			if (!current.equals(newConfiguration) &&
				!org.eclipse.emf.ecore.util.EcoreUtil.equals(current, newConfiguration)) {
				EcoreUtil.copyInto(newConfiguration, current);
				current.setVersion(current.getVersion() + 1);
				doSave(current);
				modifyConfiguration(current);
			}
		} else {
			doSave(newConfiguration);
			registerConfiguration(newConfiguration);
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler#updateEPackage(org.eclipse.emf.ecore.EPackage, java.util.Map)
	 */
	@Override
	public void updateEPackage(EPackage ePackage, Map<String, Object> properties, ConfigurationLifecycle lifecycle) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returns a EPackage by configId
	 * @param configId the configuration id
	 * @return the {@link EPackage} assigned to the configuration
	 */
	private EPackage getEPackageByConfig(String configId) {
		requireNonNull(configId);
		String ns = null;
		synchronized (configToNsMap) {
			ns = configToNsMap.get(configId);
		}
		if (isNull(ns)) {
			return null;
		} else {
			return getEPackage(ns);
		}
	}

	/**
	 * Registers a given {@link EPackage} and {@link PackageModelConfiguration} in this registry
	 * @param ePackage the {@link EPackage}
	 * @param config the {@link PMConfigurator}
	 */
	private void registerEPackageAndConfig(EPackage ePackage, PackageModelConfiguration config) {
		requireNonNull(ePackage);
		requireNonNull(config);
		String configId = config.getId();
		String ns = ePackage.getNsURI();
		if (!ePackage.getNsURI().equals(config.getNsUri()) && 
				!ePackage.equals(config.getEPackageRef())) {
			config.setNsUri(null);
			config.setEPackageRef(ePackage);
			logger.log(Level.INFO, "Update configuration with the new EPackage '%s'", ePackage.getName());
		}
		ConfigurationHolder holder = new ConfigurationHolder();
		holder.configuration = config;
		holder.ePackage = ePackage;
		synchronized (this) {
			put(ns, holder);
			synchronized (configToNsMap) {
				configToNsMap.put(configId, ns);
			}
		}
		
	}

	private PackageModelConfiguration doSave(PackageModelConfiguration configuration) {
		if (isNull(configuration)) {
			return null;
		}
		backingRepo.save(configuration);
		return configuration;
	}

	private void registerConfiguration(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		EPackage ePackage = configuration.getEPackageRef();
		if (nonNull(ePackage)) {
			registerEPackageAndConfig(ePackage, configuration);
			Collections.unmodifiableList(configurators).
				stream().
				filter(c->c.canConfigure(configuration)).
				forEach(c->c.doUnConfigure(configuration));
		} else {
			synchronized (configCache) {
				configCache.put(configuration.getId(), configuration);
			}
		}
	}

	private void modifyConfiguration(PackageModelConfiguration configuration) {
//		if (isNull(configuration)) {
//		configuration = getConfiguration(ePackage, properties).get();
//	}
//	requireNonNull(configuration, "Configuration must be not null, in modification mode");
//	if (!ePackage.equals(configuration.getEPackageRef())) {
//		configuration.setName(ePackage.getName());
//		configuration.setNsUri(ePackage.getNsURI());
//		configuration.setEPackageRef(ePackage);
//		configManager.saveConfiguration(configuration);
//		configurationRegistry.modifyConfiguration(configuration);
//	}
	}

	private void unregisterConfiguration(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		unregisterConfiguration(configuration.getId());
	}

	private void unregisterConfiguration(String configId) {
		requireNonNull(configId);
		String ns = null;
		ConfigurationHolder holder = null;
		synchronized (configToNsMap) {
			ns = configToNsMap.remove(configId);
			if (nonNull(ns)) {
				synchronized (this) {
					holder = (ConfigurationHolder) remove(ns);
				}
			}
		}
		if (nonNull(holder)) {
			PackageModelConfiguration config = holder.configuration;
			Collections.unmodifiableList(configurators).
				stream().
				filter(c->c.canConfigure(config)).
				forEach(c->c.doUnConfigure(config));
		}
		
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler#getConfigurationsBySource(org.eclipse.gecko.ma.config.SourceType[])
	 */
	@Override
	public List<PackageModelConfiguration> getConfigurationsBySource(SourceType... type) {
		// TODO Auto-generated method stub
		return null;
	}

}
