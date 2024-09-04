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

import static org.eclipse.gecko.ma.MAConstants.DEFAULT_REGISTRY_FILTER;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gecko.ma.api.init.ModelConfigurationLifecycleHandler;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.gecko.emf.osgi.constants.EMFNamespaces;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * This initializer for all {@link EPackage} that are registered automatically. This means, the packages may be appear before, during or after a configuration is initialized.
 * 
 * Das ist eigentlich Quatsch, das könnte die Registry selbst tun.
 * 
 * @author Mark Hoffmann
 * @since 29.07.2024
 */
@Component
public class MAEPackageFirstInitializer {
	
	private static final String MA_FEATURE_FILTER = "(" + EMFNamespaces.EMF_MODEL_FEATURE + "=model.atlas)";
	@Reference(target = DEFAULT_REGISTRY_FILTER) 
	private ModelConfigurationLifecycleHandler lifeCycleHandler;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = MA_FEATURE_FILTER, updated = "modifyEPackage")
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
