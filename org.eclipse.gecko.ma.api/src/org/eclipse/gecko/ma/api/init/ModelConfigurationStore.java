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
package org.eclipse.gecko.ma.api.init;

import java.util.List;
import java.util.Optional;

import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Service to handle {@link PackageModelConfiguration} management or save and update them. 
 * @author Mark Hoffmann
 * @since 18.07.2024
 */
@ProviderType
public interface ModelConfigurationStore {
	
	/**
	 * Returns the {@link Optional} for a {@link PackageModelConfiguration} with the given configuration id 
	 * @param configId the configuration id to get {@link PackageModelConfiguration} for
	 * @return an {@link Optional} that might be empty
	 */
	Optional<PackageModelConfiguration> getConfiguration(String configId);
	
	/**
	 * Returns the {@link Optional} for a {@link PackageModelConfiguration} with the given configuration id 
	 * @param configId the configuration id to get {@link PackageModelConfiguration} for
	 * @return an {@link Optional} that might be empty
	 */
	Optional<PackageModelConfiguration> getConfigurationByNS(String packageNS);
	
	/**
	 * Returns all current configurations
	 * @return all configuration or an empty {@link List}
	 */
	List<PackageModelConfiguration> getAllConfigurations();
	
	/**
	 * Returns the configurations with the given {@link SourceType}
	 * @return the configuration or an empty {@link List}
	 */
	List<PackageModelConfiguration> getConfigurationsByType(SourceType ...sourceTypes);
	
	/**
	 * Returns the configurations with the given {@link ConfigurationStage}
	 * @return the configuration or an empty {@link List}
	 */
	List<PackageModelConfiguration> getConfigurationsByStage(ConfigurationStage ...configurationStages);
	
	/**
	 * Saves a configuration and returns the saved instance. If no id is provided it will be assigned during persistence
	 * and is available in the returning instance
	 * @param configuration the configuration to be saved, must not be <code>null</code>
	 * @return the saved instance
	 */
	PackageModelConfiguration saveConfiguration(PackageModelConfiguration configuration);
	
	/**
	 * Deletes a {@link PackageModelConfiguration}
	 * @param configuration the configuration to be removed
	 */
	void deleteConfiguration(PackageModelConfiguration configuration);
	
	/**
	 * Deletes a {@link PackageModelConfiguration}
	 * @param configurationId the id of the configuration to be removed
	 */
	void deleteConfiguration(String configurationId);
	
}
