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

import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Registry service for {@link PackageModelConfiguration}s. It handles the lifecycle of a
 * {@link PackageModelConfiguration}.
 * @author Mark Hoffmann
 * @since 18.07.2024
 */
@ProviderType
public interface ModelConfigurationRegistry {
	
	/**
	 * Registers a given configuration.
	 * @param configuration the {@link PackageModelConfiguration}, must not be <code>null</code>
	 */
	void registerConfiguration(PackageModelConfiguration configuration);
	
	/**
	 * Modifies a {@link PackageModelConfiguration} 
	 * @param configuration the {@link PackageModelConfiguration} to modify, must not be <code>null</code>
	 */
	void modifyConfiguration(PackageModelConfiguration configuration);
	
	/**
	 * Un-registers the given {@link PackageModelConfiguration}
	 * @param configuration the configuration to unregister, must not be <code>null</code>
	 */
	void unregisterConfiguration(PackageModelConfiguration configuration);
	
	/**
	 * Un-registers the given {@link PackageModelConfiguration}
	 * @param configId the configuration id of the configuration to be unregistered, must not be <code>null</code>
	 */
	void unregisterConfiguration(String configId);

}
