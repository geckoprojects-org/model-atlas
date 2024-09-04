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

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.osgi.service.cm.Configuration;

/**
 * A abstract default configurator for EPackages that supports having multiple configurations for a given {@link EPackage}
 * @author Mark Hoffmann
 * @since 15.07.2024
 */
public abstract class DefaultPackageModelConfigurator implements PackageModelConfigurationHandler {
	
	private static final Logger logger = Logger.getLogger(DefaultPackageModelConfigurator.class.getName());
	private Map<String, List<Configuration>> configCMMap = new ConcurrentHashMap<>();
	
	public List<Configuration> getCMConfigurations(PackageModelConfiguration pmc) {
		requireNonNull(pmc);
		return configCMMap.get(pmc.getId());
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.PackageModelConfigurator#canConfigure(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public boolean canConfigure(PackageModelConfiguration configuration) {
		return false;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.PackageModelConfigurator#doConfigure(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public void doConfigure(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		List<Configuration> configList = configCMMap.computeIfAbsent(configuration.getId(), ep->new ArrayList<>());
		doConfigurePackage(configuration, configList);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.PackageModelConfigurator#doUnConfigure(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public void doUnConfigure(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		List<Configuration> configList = configCMMap.remove(configuration.getId());
		if (nonNull(configList)) {
			doUnconfigurePackage(configuration, configList);
		}
		configList.forEach(c->{
			try {
				c.delete();
			} catch (IOException e) {
				logger.log(Level.SEVERE, String.format("Error deleting configuration PID '%s'", c.getPid()));
			}
		});
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.PackageModelConfigurator#doReConfigure(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public void doReConfigure(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		List<Configuration> configList = getCMConfigurations(configuration);
		if (nonNull(configList)) {
			doReconfigurePackage(configuration, configList);
		}
	}
	
	/**
	 * Callback to configure an application/module for the given {@link PackageModelConfiguration}
	 * @param configuration the {@link PackageModelConfiguration} to configure
	 * @param configurations the configuration list
	 */
	abstract protected void doConfigurePackage(PackageModelConfiguration configuration, List<Configuration> configurations);
	
	/**
	 * Callback to un-configure an application/module for the given {@link PackageModelConfiguration}
	 * @param configuration the {@link PackageModelConfiguration} to un-configure
	 * @param configurations the configuration list
	 */
	protected void doUnconfigurePackage(PackageModelConfiguration configuration, List<Configuration> configurations) {
		// Nothing to do here
	}

	/**
	 * Callback to re-configure an application/module for the given {@link PackageModelConfiguration}.
	 * Client may overwrite this method for custom actions
	 * @param configuration the {@link PackageModelConfiguration} to re-configure
	 * @param configurations the configuration list
	 */
	protected void doReconfigurePackage(PackageModelConfiguration configuration, List<Configuration> configList) {
		// Nothing to do here
	}
}
