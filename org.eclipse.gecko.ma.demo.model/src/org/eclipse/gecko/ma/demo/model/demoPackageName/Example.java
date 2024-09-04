/*
 */
package org.eclipse.gecko.ma.demo.model.demoPackageName;

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
 *   <li>{@link org.eclipse.gecko.ma.demo.model.demoPackageName.Example#getDemo <em>Demo</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.DemoPrefixPackage#getExample()
 * @model
 * @generated
 */
@ProviderType
public interface Example extends EObject {
	/**
	 * Returns the value of the '<em><b>Demo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demo</em>' attribute.
	 * @see #setDemo(String)
	 * @see org.eclipse.gecko.ma.demo.model.demoPackageName.DemoPrefixPackage#getExample_Demo()
	 * @model
	 * @generated
	 */
	String getDemo();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.demo.model.demoPackageName.Example#getDemo <em>Demo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demo</em>' attribute.
	 * @see #getDemo()
	 * @generated
	 */
	void setDemo(String value);

} // Example
