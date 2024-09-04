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
import static java.util.Objects.requireNonNull;
import static org.eclipse.gecko.ma.MAConstants.DEFAULT_REGISTRY_FILTER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.gecko.ma.annotations.RequireModelAtlas;
import org.eclipse.gecko.ma.api.init.ModelConfigurationStore;
import org.eclipse.gecko.ma.api.init.ModelConfigurationRegistry;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.MaconfigPackage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.gecko.emf.repository.EMFRepository;
import org.gecko.emf.repository.mongo.annotations.RequireMongoEMFRepository;
import org.gecko.emf.repository.query.IQuery;
import org.gecko.emf.repository.query.QueryRepository;
import org.gecko.util.emf.EcoreUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

/**
 * Implementation of the configuration manager store 
 * @author Mark Hoffmann
 * @since 18.07.2024
 */
@RequireModelAtlas
@RequireMongoEMFRepository
@Component(name="ModelConfigurationManager", service = {ModelConfigurationStore.class}, configurationPolicy = ConfigurationPolicy.REQUIRE)
public class ConfigurationStoreImpl implements ModelConfigurationStore {

	public static final String REF_REPO = "config.repo";
	Map<String, PackageModelConfiguration> configCache = new ConcurrentHashMap<>();
	Map<String, ConfigurationLifecycle> lifeCycleCache = new ConcurrentHashMap<>();

	@Reference(name=REF_REPO)
	private EMFRepository backingRepo;
	@Reference(target = DEFAULT_REGISTRY_FILTER)
	private ModelConfigurationRegistry configurationRegistry;
	@Reference
	private MaconfigPackage configPackage;

	@Activate
	public void activate() {
		initializeCache();
	}

	/**
	 * Initializes the configuration cache map
	 */
	private void initializeCache() {
		List<PackageModelConfiguration> allConfigs = backingRepo.getAllEObjects(configPackage.getPackageModelConfiguration());
		if (nonNull(allConfigs)) {
			allConfigs.stream().forEach(c->{
				configCache.put(c.getId(), c);
				updateLifeycle(c, c.getLifecycle());
			});
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationProvider#getConfiguration(java.lang.String)
	 */
	@Override
	public Optional<PackageModelConfiguration> getConfiguration(String configId) {
		requireNonNull(configId);
		return Optional.ofNullable(configCache.get(configId));
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationProvider#getConfigurationByNS(java.lang.String)
	 */
	@Override
	public Optional<PackageModelConfiguration> getConfigurationByNS(String packageNS) {
		requireNonNull(packageNS);

		QueryRepository qRepo = (QueryRepository) backingRepo;
		IQuery nsQuery = qRepo.createQueryBuilder().column(configPackage.getPackageModelConfiguration_NsUri()).simpleValue(packageNS).build();
		List<PackageModelConfiguration> configResults = qRepo.getEObjectsByQuery(configPackage.getPackageModelConfiguration(), nsQuery);
		if (isNull(configResults)) {
			return Optional.empty();
		} else {
			return configResults.stream().findFirst();
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationProvider#getAllConfigurations()
	 */
	@Override
	public List<PackageModelConfiguration> getAllConfigurations() {
		if (configCache.isEmpty()) {
			List<PackageModelConfiguration> allConfigs = backingRepo.getAllEObjects(configPackage.getPackageModelConfiguration());
			if (nonNull(allConfigs)) {
				synchronized (configCache) {
					configCache.putAll(allConfigs.
							stream().
							collect(Collectors.toMap(PackageModelConfiguration::getId, Function.identity())));
				}
			}
		}
		return new ArrayList<>(configCache.values());
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationManager#getConfigurationsByType(org.eclipse.gecko.ma.config.SourceType[])
	 */
	@Override
	public List<PackageModelConfiguration> getConfigurationsByType(SourceType... sourceTypes) {
		List<SourceType> sourceList = isNull(sourceTypes) ? Collections.emptyList() : List.of(sourceTypes);
		return new ArrayList<>(getAllConfigurations()).
				stream().
				filter(c->sourceList.contains(c.getSourceType())).
				toList();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationProvider#getConfigurationsByStage(org.eclipse.gecko.ma.api.init.ConfigurationStage[])
	 */
	@Override
	public List<PackageModelConfiguration> getConfigurationsByStage(ConfigurationStage... configurationStages) {
		List<ConfigurationStage> stages = isNull(configurationStages) ? Collections.emptyList() : List.of(configurationStages);
		return new ArrayList<>(getAllConfigurations()).
				stream().
				filter(c->stages.contains(c.getStage())).
				toList();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationManager#saveConfiguration(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public PackageModelConfiguration saveConfiguration(PackageModelConfiguration configuration) {
		if (isNull(configuration)) {
			return null;
		}
		return updateConfiguration(configuration);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationManager#deleteConfiguration(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public void deleteConfiguration(PackageModelConfiguration configuration) {
		if (isNull(configuration)) {
			return;
		}
		deleteConfiguration(configuration.getId());
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.ModelConfigurationManager#deleteConfiguration(java.lang.String)
	 */
	@Override
	public void deleteConfiguration(String configurationId) {
		if (isNull(configurationId)) {
			return;
		}
		PackageModelConfiguration current;
		synchronized (configCache) {
			current = configCache.remove(configurationId);
		}
		if (nonNull(current)) {
			synchronized (lifeCycleCache) {
				lifeCycleCache.remove(current.getId());
			}
			backingRepo.delete(current);
		}
	}

	private void updateLifeycle(PackageModelConfiguration configuration, ConfigurationLifecycle lifecycle) {
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

	private void updateLifeycle(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		requireNonNull(configuration);
		updateLifeycle(configuration, configuration.getLifecycle());
	}

	private PackageModelConfiguration updateConfiguration(PackageModelConfiguration newConfiguration) {
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
				configurationRegistry.modifyConfiguration(current);
				return current;
			}
		} else {
			doSave(newConfiguration);
			configurationRegistry.registerConfiguration(newConfiguration);
		}
		return newConfiguration;
	}

	private PackageModelConfiguration doSave(PackageModelConfiguration configuration) {
		if (isNull(configuration)) {
			return null;
		}
		backingRepo.save(configuration);
		return configuration;
	}

}
