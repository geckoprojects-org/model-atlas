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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler;
import org.eclipse.gecko.ma.api.init.ModelConfigurationStore;
import org.eclipse.gecko.ma.api.init.ModelConfigurationRegistry;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.MaconfigFactory;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.gecko.emf.osgi.constants.EMFNamespaces;
import org.gecko.util.emf.EcoreUtil;

/**
 * This initializer 
 * @author mark
 * @since 29.07.2024
 */
@Component
public class MAConfigFirstInitializer {

	private static final String MA_CONFIG_FILTER = "(ma.config.id=*)";
	@Reference(target = DEFAULT_REGISTRY_FILTER) 
	private ModelConfigurationLifecycleHandler lifeCycleHandler;
	@Reference
	private ModelConfigurationStore configManager;
	@Reference
	private MaconfigFactory configFactory;
	@Reference
	private ConfigurationAdmin configAdmin;
	private final List<PackageModelConfiguration> allConfigurations = new ArrayList<>();
	
	@Activate
	public MAConfigFirstInitializer(BundleContext bctx) {
		allConfigurations.addAll(lifeCycleHandler.getConfigurationsBySource(SourceType.DYNAMIC, SourceType.MONGO));
	}
	
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = MA_CONFIG_FILTER, updated = "modifyEPackage")
	public void addEPackage(EPackage ePackage, Map<String, Object> properties) {
		lifeCycleHandler.updateEPackage(ePackage, properties, ConfigurationLifecycle.REGISTERING);
	}
	
	public void modifyEPackage(EPackage ePackage, Map<String, Object> properties) {
		lifeCycleHandler.updateEPackage(ePackage, properties, ConfigurationLifecycle.UPDATING);
	}

	public void removeEPackage(EPackage ePackage, Map<String, Object> properties) {
		lifeCycleHandler.updateEPackage(ePackage, properties, ConfigurationLifecycle.UNREGISTERING);
	}
	
}
