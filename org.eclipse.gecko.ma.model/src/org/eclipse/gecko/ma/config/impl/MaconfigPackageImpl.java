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
 *      Data In Motion - initial API and implementation
 */
package org.eclipse.gecko.ma.config.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.MaconfigFactory;
import org.eclipse.gecko.ma.config.MaconfigPackage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MaconfigPackageImpl extends EPackageImpl implements MaconfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageModelConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum configurationStageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum configurationLifecycleEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MaconfigPackageImpl() {
		super(eNS_URI, MaconfigFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MaconfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MaconfigPackage init() {
		if (isInited) return (MaconfigPackage)EPackage.Registry.INSTANCE.getEPackage(MaconfigPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMaconfigPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MaconfigPackageImpl theMaconfigPackage = registeredMaconfigPackage instanceof MaconfigPackageImpl ? (MaconfigPackageImpl)registeredMaconfigPackage : new MaconfigPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMaconfigPackage.createPackageContents();

		// Initialize created meta-data
		theMaconfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMaconfigPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MaconfigPackage.eNS_URI, theMaconfigPackage);
		return theMaconfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPackageModelConfiguration() {
		return packageModelConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_Id() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_Pid() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_Name() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_NsUri() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_SourceUri() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPackageModelConfiguration_EPackageRef() {
		return (EReference)packageModelConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_RestInterface() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_SourceType() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_Stage() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_Version() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageModelConfiguration_Lifecycle() {
		return (EAttribute)packageModelConfigurationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSourceType() {
		return sourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConfigurationStage() {
		return configurationStageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConfigurationLifecycle() {
		return configurationLifecycleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MaconfigFactory getMaconfigFactory() {
		return (MaconfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		packageModelConfigurationEClass = createEClass(PACKAGE_MODEL_CONFIGURATION);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__ID);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__PID);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__NAME);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__NS_URI);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__SOURCE_URI);
		createEReference(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__STAGE);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__VERSION);
		createEAttribute(packageModelConfigurationEClass, PACKAGE_MODEL_CONFIGURATION__LIFECYCLE);

		// Create enums
		sourceTypeEEnum = createEEnum(SOURCE_TYPE);
		configurationStageEEnum = createEEnum(CONFIGURATION_STAGE);
		configurationLifecycleEEnum = createEEnum(CONFIGURATION_LIFECYCLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(packageModelConfigurationEClass, PackageModelConfiguration.class, "PackageModelConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageModelConfiguration_Id(), ecorePackage.getEString(), "id", null, 1, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_Pid(), ecorePackage.getEString(), "pid", null, 1, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_NsUri(), ecorePackage.getEString(), "nsUri", null, 1, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_SourceUri(), ecorePackage.getEString(), "sourceUri", null, 0, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageModelConfiguration_EPackageRef(), theEcorePackage.getEPackage(), null, "ePackageRef", null, 0, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_RestInterface(), ecorePackage.getEBoolean(), "restInterface", "true", 0, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_SourceType(), this.getSourceType(), "sourceType", null, 0, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_Stage(), this.getConfigurationStage(), "stage", null, 0, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_Version(), ecorePackage.getELong(), "version", "0", 1, 1, PackageModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModelConfiguration_Lifecycle(), this.getConfigurationLifecycle(), "lifecycle", null, 0, 1, PackageModelConfiguration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sourceTypeEEnum, SourceType.class, "SourceType");
		addEEnumLiteral(sourceTypeEEnum, SourceType.DIRECT);
		addEEnumLiteral(sourceTypeEEnum, SourceType.DYNAMIC);
		addEEnumLiteral(sourceTypeEEnum, SourceType.MONGO);
		addEEnumLiteral(sourceTypeEEnum, SourceType.EXTENDER);
		addEEnumLiteral(sourceTypeEEnum, SourceType.OTHER);

		initEEnum(configurationStageEEnum, ConfigurationStage.class, "ConfigurationStage");
		addEEnumLiteral(configurationStageEEnum, ConfigurationStage.UNCONFIGURED);
		addEEnumLiteral(configurationStageEEnum, ConfigurationStage.DRAFT);
		addEEnumLiteral(configurationStageEEnum, ConfigurationStage.ACTIVE);
		addEEnumLiteral(configurationStageEEnum, ConfigurationStage.INACTIVE);
		addEEnumLiteral(configurationStageEEnum, ConfigurationStage.DEPRECATED);

		initEEnum(configurationLifecycleEEnum, ConfigurationLifecycle.class, "ConfigurationLifecycle");
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.LOADED);
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.REGISTERING);
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.REGISTERED);
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.UNREGISTERING);
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.UNREGISTERED);
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.UPDATING);
		addEEnumLiteral(configurationLifecycleEEnum, ConfigurationLifecycle.UPDATED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// Version
		createVersionAnnotations();
	}

	/**
	 * Initializes the annotations for <b>Version</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createVersionAnnotations() {
		String source = "Version";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "value", "1.0"
		   });
	}

} //MaconfigPackageImpl
