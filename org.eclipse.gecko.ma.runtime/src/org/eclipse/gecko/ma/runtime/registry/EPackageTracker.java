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

import static java.util.Objects.requireNonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.MaconfigFactory;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.gecko.emf.osgi.constants.EMFNamespaces;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * 
 * @author mark
 * @since 06.08.2024
 */
public class EPackageTracker implements ServiceTrackerCustomizer<EPackage, PackageModelConfiguration>{

	String FILTER_MODEL_NAME = "(" + EMFNamespaces.EMF_MODEL_NAME + "=%s)";
	private final BundleContext context;
	private final ModelConfigurationRegistry registry;
	private final ServiceTracker<EPackage, PackageModelConfiguration> tracker;
	private final Map<String, PackageModelConfiguration> configCache = new ConcurrentHashMap<>();
	private final Map<String, String> configToNsMap = new ConcurrentHashMap<>();
	
	
	public EPackageTracker(BundleContext context, ModelConfigurationRegistry registry) {
		this.context = context;
		this.registry = registry;
		tracker = new ServiceTracker<>(context, EPackage.class, this);
	}
	
	public void open() {
		tracker.open();
	}
	
	public void close() {
		tracker.close();
	}
	
	public void registerConfiguration(PackageModelConfiguration configuration) {
		requireNonNull(configuration);
		configCache.put(configuration.getId(), configuration);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#addingService(org.osgi.framework.ServiceReference)
	 */
	@Override
	public PackageModelConfiguration addingService(ServiceReference<EPackage> reference) {
		EPackage ePackage = context.getService(reference);
		// get or create config here?
		PackageModelConfiguration config = MaconfigFactory.eINSTANCE.createPackageModelConfiguration();
		config.setEPackageRef(ePackage);
		// do something more with config
		return config;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#modifiedService(org.osgi.framework.ServiceReference, java.lang.Object)
	 */
	@Override
	public void modifiedService(ServiceReference<EPackage> reference, PackageModelConfiguration service) {
		EPackage ePackage = context.getService(reference);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#removedService(org.osgi.framework.ServiceReference, java.lang.Object)
	 */
	@Override
	public void removedService(ServiceReference<EPackage> reference, PackageModelConfiguration service) {
	}

}
