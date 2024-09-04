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
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Service to hold all configuration and handle their lifecycle. 
 * @author Mark Hoffmann
 * @since 18.07.2024
 */
@ProviderType
@Deprecated
public interface ModelConfigurationLifecycleHandler {
	
	List<PackageModelConfiguration> getConfigurationsBySource(SourceType... type);
	
	/**
	 * Updates the lifecycle state
	 * @param configuration
	 * @param lifecycle
	 */
	void updateLifeycle(PackageModelConfiguration configuration, ConfigurationLifecycle lifecycle);
	
	/**
	 * Updates the lifecycle state
	 * @param configuration
	 * @param lifecycle
	 */
	void updateLifeycle(PackageModelConfiguration configuration);
	
	void updateConfiguration(PackageModelConfiguration configuration);
	
	void updateEPackage(EPackage ePackage, Map<String,Object> properties, ConfigurationLifecycle lifecycle);
	
}
