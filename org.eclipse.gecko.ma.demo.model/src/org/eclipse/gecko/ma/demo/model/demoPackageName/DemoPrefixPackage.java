/*
 */
package org.eclipse.gecko.ma.demo.model.demoPackageName;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

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
 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.DemoPrefixFactory
 * @model kind="package"
 *        annotation="Version value='1.0'"
 * @generated
 */
@ProviderType
@EPackage(uri = DemoPrefixPackage.eNS_URI, genModel = "/model/demo-file.genmodel", genModelSourceLocations = {"model/demo-file.genmodel","org.eclipse.gecko.ma.demo.model/model/demo-file.genmodel"}, ecore="/model/demo-file.ecore", ecoreSourceLocations="/model/demo-file.ecore")
public interface DemoPrefixPackage extends org.eclipse.emf.ecore.EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "demoPackageName";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://demo.de/demo/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "demo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DemoPrefixPackage eINSTANCE = org.eclipse.gecko.ma.demo.model.demoPackageName.impl.DemoPrefixPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gecko.ma.demo.model.demoPackageName.impl.ExampleImpl <em>Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.impl.ExampleImpl
	 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.impl.DemoPrefixPackageImpl#getExample()
	 * @generated
	 */
	int EXAMPLE = 0;

	/**
	 * The feature id for the '<em><b>Demo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__DEMO = 0;

	/**
	 * The number of structural features of the '<em>Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gecko.ma.demo.model.demoPackageName.Example <em>Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Example</em>'.
	 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.Example
	 * @generated
	 */
	EClass getExample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gecko.ma.demo.model.demoPackageName.Example#getDemo <em>Demo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Demo</em>'.
	 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.Example#getDemo()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Demo();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DemoPrefixFactory getDemoPrefixFactory();

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
		 * The meta object literal for the '{@link org.eclipse.gecko.ma.demo.model.demoPackageName.impl.ExampleImpl <em>Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.impl.ExampleImpl
		 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.impl.DemoPrefixPackageImpl#getExample()
		 * @generated
		 */
		EClass EXAMPLE = eINSTANCE.getExample();

		/**
		 * The meta object literal for the '<em><b>Demo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__DEMO = eINSTANCE.getExample_Demo();

	}

} //DemoPrefixPackage
