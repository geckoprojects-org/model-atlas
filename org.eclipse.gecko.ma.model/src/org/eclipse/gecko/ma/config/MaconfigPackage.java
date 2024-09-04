/*
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
package org.eclipse.gecko.ma.config;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;

import org.gecko.emf.osgi.annotation.provide.EPackage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gecko.ma.config.MaconfigFactory
 * @model kind="package"
 *        annotation="Version value='1.0'"
 * @generated
 */
@ProviderType
@EPackage(uri = MaconfigPackage.eNS_URI, genModel = "/model/ma-config.genmodel", genModelSourceLocations = {"model/ma-config.genmodel","org.eclipse.gecko.ma.model/model/ma-config.genmodel"}, ecore="/model/ma-config.ecore", ecoreSourceLocations="/model/ma-config.ecore")
public interface MaconfigPackage extends org.eclipse.emf.ecore.EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "config";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://eclipse.org/model-atlas/configuration/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mac";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MaconfigPackage eINSTANCE = org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl <em>Package Model Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl
	 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getPackageModelConfiguration()
	 * @generated
	 */
	int PACKAGE_MODEL_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Pid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__PID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Ns Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__NS_URI = 3;

	/**
	 * The feature id for the '<em><b>Source Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__SOURCE_URI = 4;

	/**
	 * The feature id for the '<em><b>EPackage Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF = 5;

	/**
	 * The feature id for the '<em><b>Rest Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE = 6;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__STAGE = 8;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__VERSION = 9;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION__LIFECYCLE = 10;

	/**
	 * The number of structural features of the '<em>Package Model Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Package Model Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODEL_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gecko.ma.config.SourceType <em>Source Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gecko.ma.config.SourceType
	 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getSourceType()
	 * @generated
	 */
	int SOURCE_TYPE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gecko.ma.config.ConfigurationStage <em>Configuration Stage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gecko.ma.config.ConfigurationStage
	 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getConfigurationStage()
	 * @generated
	 */
	int CONFIGURATION_STAGE = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gecko.ma.config.ConfigurationLifecycle <em>Configuration Lifecycle</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gecko.ma.config.ConfigurationLifecycle
	 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getConfigurationLifecycle()
	 * @generated
	 */
	int CONFIGURATION_LIFECYCLE = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration <em>Package Model Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Model Configuration</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration
	 * @generated
	 */
	EClass getPackageModelConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getId()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getPid <em>Pid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pid</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getPid()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_Pid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getName()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getNsUri <em>Ns Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Uri</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getNsUri()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_NsUri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceUri <em>Source Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Uri</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceUri()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_SourceUri();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getEPackageRef <em>EPackage Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EPackage Ref</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getEPackageRef()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EReference getPackageModelConfiguration_EPackageRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#isRestInterface <em>Rest Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rest Interface</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#isRestInterface()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_RestInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Type</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceType()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_SourceType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getStage()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_Stage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getVersion()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getLifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lifecycle</em>'.
	 * @see org.eclipse.gecko.ma.config.PackageModelConfiguration#getLifecycle()
	 * @see #getPackageModelConfiguration()
	 * @generated
	 */
	EAttribute getPackageModelConfiguration_Lifecycle();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gecko.ma.config.SourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Source Type</em>'.
	 * @see org.eclipse.gecko.ma.config.SourceType
	 * @generated
	 */
	EEnum getSourceType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gecko.ma.config.ConfigurationStage <em>Configuration Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Configuration Stage</em>'.
	 * @see org.eclipse.gecko.ma.config.ConfigurationStage
	 * @generated
	 */
	EEnum getConfigurationStage();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.gecko.ma.config.ConfigurationLifecycle <em>Configuration Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Configuration Lifecycle</em>'.
	 * @see org.eclipse.gecko.ma.config.ConfigurationLifecycle
	 * @generated
	 */
	EEnum getConfigurationLifecycle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MaconfigFactory getMaconfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl <em>Package Model Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl
		 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getPackageModelConfiguration()
		 * @generated
		 */
		EClass PACKAGE_MODEL_CONFIGURATION = eINSTANCE.getPackageModelConfiguration();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__ID = eINSTANCE.getPackageModelConfiguration_Id();

		/**
		 * The meta object literal for the '<em><b>Pid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__PID = eINSTANCE.getPackageModelConfiguration_Pid();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__NAME = eINSTANCE.getPackageModelConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Ns Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__NS_URI = eINSTANCE.getPackageModelConfiguration_NsUri();

		/**
		 * The meta object literal for the '<em><b>Source Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__SOURCE_URI = eINSTANCE.getPackageModelConfiguration_SourceUri();

		/**
		 * The meta object literal for the '<em><b>EPackage Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF = eINSTANCE.getPackageModelConfiguration_EPackageRef();

		/**
		 * The meta object literal for the '<em><b>Rest Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE = eINSTANCE.getPackageModelConfiguration_RestInterface();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE = eINSTANCE.getPackageModelConfiguration_SourceType();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__STAGE = eINSTANCE.getPackageModelConfiguration_Stage();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__VERSION = eINSTANCE.getPackageModelConfiguration_Version();

		/**
		 * The meta object literal for the '<em><b>Lifecycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODEL_CONFIGURATION__LIFECYCLE = eINSTANCE.getPackageModelConfiguration_Lifecycle();

		/**
		 * The meta object literal for the '{@link org.eclipse.gecko.ma.config.SourceType <em>Source Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gecko.ma.config.SourceType
		 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getSourceType()
		 * @generated
		 */
		EEnum SOURCE_TYPE = eINSTANCE.getSourceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.gecko.ma.config.ConfigurationStage <em>Configuration Stage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gecko.ma.config.ConfigurationStage
		 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getConfigurationStage()
		 * @generated
		 */
		EEnum CONFIGURATION_STAGE = eINSTANCE.getConfigurationStage();

		/**
		 * The meta object literal for the '{@link org.eclipse.gecko.ma.config.ConfigurationLifecycle <em>Configuration Lifecycle</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gecko.ma.config.ConfigurationLifecycle
		 * @see org.eclipse.gecko.ma.config.impl.MaconfigPackageImpl#getConfigurationLifecycle()
		 * @generated
		 */
		EEnum CONFIGURATION_LIFECYCLE = eINSTANCE.getConfigurationLifecycle();

	}

} //MaconfigPackage
