/*
 */
package org.eclipse.gecko.ma.example.model.examplePackageName;

import org.eclipse.emf.ecore.EObject;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Example</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gecko.ma.example.model.examplePackageName.Example#getTest <em>Test</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gecko.ma.example.model.examplePackageName.ExamplePrefixPackage#getExample()
 * @model
 * @generated
 */
@ProviderType
public interface Example extends EObject {
	/**
	 * Returns the value of the '<em><b>Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' attribute.
	 * @see #setTest(String)
	 * @see org.eclipse.gecko.ma.example.model.examplePackageName.ExamplePrefixPackage#getExample_Test()
	 * @model
	 * @generated
	 */
	String getTest();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.example.model.examplePackageName.Example#getTest <em>Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test</em>' attribute.
	 * @see #getTest()
	 * @generated
	 */
	void setTest(String value);

} // Example
