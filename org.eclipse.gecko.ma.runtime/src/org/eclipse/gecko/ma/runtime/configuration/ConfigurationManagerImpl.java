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
package org.eclipse.gecko.ma.runtime.configuration;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.eclipse.gecko.ma.MAConstants.DEFAULT_REGISTRY_FILTER;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.gecko.ma.api.init.ModelConfigurationStore;
import org.eclipse.gecko.ma.api.init.PackageModelConfigurationHandler;
import org.eclipse.gecko.ma.api.init.ModelConfigurationRegistry;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.MaconfigFactory;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.gecko.util.emf.EcoreUtil;

/**
 * 
 * @author mark
 * @since 29.07.2024
 */
@Component
public class ConfigurationManagerImpl {

	private final Map<String, PackageModelConfiguration> configMap = new ConcurrentHashMap<>();
	private final List<PackageModelConfigurationHandler> configurators = new LinkedList<>();
	private BundleContext bctx;
	@Reference(target = DEFAULT_REGISTRY_FILTER)
	private ModelConfigurationRegistry configRegistry;
	@Reference
	private ModelConfigurationStore configStore;
	@Reference
	private MaconfigFactory configFactory;

	@Activate
	public void activate(BundleContext bctx) {
		this.bctx = bctx;
		List<PackageModelConfiguration> allConfigs = configStore.getAllConfigurations();
		if (nonNull(allConfigs)) {
			allConfigs.stream()
				.filter(c->ConfigurationStage.ACTIVE.equals(c.getStage()))
				.forEach(this::initialize);
		}
	}
	
	private void initialize(PackageModelConfiguration configuration) {
		
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = "(ma=true)", updated = "modifyEPackage")
	public void addEPackage(EPackage ePackage, Map<String, Object> properties) {
		registerConfiguration(ePackage, properties);
	}

	public void modifyEPackage(EPackage ePackage, Map<String, Object> properties) {
		updateConfiguration(null, ePackage, properties);
	}

	public void removeEPackage(EPackage ePackage, Map<String, Object> properties) {
		unregisterConfiguration(ePackage, properties);
	}

	/**
	 * @param ePackage
	 * @param properties
	 */
	private void registerConfiguration(EPackage ePackage, Map<String, Object> properties) {
		Objects.requireNonNull(ePackage);
		properties = Objects.isNull(properties) ? Collections.emptyMap() : properties;
		String ns = ePackage.getNsURI();
		Optional<PackageModelConfiguration> configOptional = configStore.getConfigurationByNS(ns);
		PackageModelConfiguration configuration;
		if (configOptional.isPresent()) {
			configuration = configOptional.get();
			updateConfiguration(configuration, ePackage, properties);
		} else {
			configuration = configFactory.createPackageModelConfiguration();
			configuration.setName(ePackage.getName());
			configuration.setNsUri(ePackage.getNsURI());
			configuration.setEPackageRef(ePackage);
			configRegistry.registerConfiguration(configuration);
		}
		configMap.put(configuration.getId(), configuration);

	}

	/**
	 * @param ePackage
	 * @param properties
	 */
	private void updateConfiguration(PackageModelConfiguration configuration, EPackage ePackage, Map<String, Object> properties) {
		Optional<PackageModelConfiguration> current = configStore.getConfiguration(configuration.getId());
		if (current.isPresent() && !configuration.equals(current.get())) {
			configRegistry.modifyConfiguration(configuration);
		}

	}

	/**
	 * @param ePackage
	 * @param properties
	 */
	private void unregisterConfiguration(EPackage ePackage, Map<String, Object> properties) {
		// TODO Auto-generated method stub

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
}
