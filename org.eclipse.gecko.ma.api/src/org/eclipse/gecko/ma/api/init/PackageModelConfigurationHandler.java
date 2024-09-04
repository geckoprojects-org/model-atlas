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
import org.osgi.annotation.versioning.ConsumerType;

/**
 * Configuration callback for {@link PackageModelConfigurationHandler} instance. The call back handles the lifecycle of such configurations 
 * @author Mark Hoffmann
 * @since 30.07.2024
 */
@ConsumerType
public interface PackageModelConfigurationHandler {
	
	/**
	 * Returns <code>true</code>, if this configurator can handle the provided configuration
	 * @param configuration the configuration, must not be <code>null</code>
	 * @return <code>true</code>, if the configuration can be handled by this configurator
	 */
	boolean canConfigure(PackageModelConfiguration configuration);

	/**
	 * Called, when a new package should be configured 
	 * @param configuration the configuration, must not be <code>null</code>
	 */
	void doConfigure(PackageModelConfiguration configuration);
	
	/**
	 * Called, when an existing package should be re-configured 
	 * @param configuration the configuration, must not be <code>null</code>
	 */
	void doReConfigure(PackageModelConfiguration configuration);
	
	/**
	 * Called, when a configuration is removed. 
	 * @param configuration the configuration, must not be <code>null</code>
	 */
	void doUnConfigure(PackageModelConfiguration configuration);
}
