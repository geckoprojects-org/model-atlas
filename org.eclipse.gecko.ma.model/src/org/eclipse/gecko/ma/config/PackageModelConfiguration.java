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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Model Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getPid <em>Pid</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getNsUri <em>Ns Uri</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceUri <em>Source Uri</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getEPackageRef <em>EPackage Ref</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#isRestInterface <em>Rest Interface</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getStage <em>Stage</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getLifecycle <em>Lifecycle</em>}</li>
 * </ul>
 *
 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration()
 * @model
 * @generated
 */
@ProviderType
public interface PackageModelConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Pid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pid</em>' attribute.
	 * @see #setPid(String)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_Pid()
	 * @model required="true"
	 * @generated
	 */
	String getPid();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getPid <em>Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pid</em>' attribute.
	 * @see #getPid()
	 * @generated
	 */
	void setPid(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ns Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Uri</em>' attribute.
	 * @see #setNsUri(String)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_NsUri()
	 * @model required="true"
	 * @generated
	 */
	String getNsUri();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getNsUri <em>Ns Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Uri</em>' attribute.
	 * @see #getNsUri()
	 * @generated
	 */
	void setNsUri(String value);

	/**
	 * Returns the value of the '<em><b>Source Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Uri</em>' attribute.
	 * @see #setSourceUri(String)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_SourceUri()
	 * @model
	 * @generated
	 */
	String getSourceUri();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceUri <em>Source Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Uri</em>' attribute.
	 * @see #getSourceUri()
	 * @generated
	 */
	void setSourceUri(String value);

	/**
	 * Returns the value of the '<em><b>EPackage Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EPackage Ref</em>' reference.
	 * @see #setEPackageRef(EPackage)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_EPackageRef()
	 * @model keys="nsURI"
	 * @generated
	 */
	EPackage getEPackageRef();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getEPackageRef <em>EPackage Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EPackage Ref</em>' reference.
	 * @see #getEPackageRef()
	 * @generated
	 */
	void setEPackageRef(EPackage value);

	/**
	 * Returns the value of the '<em><b>Rest Interface</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest Interface</em>' attribute.
	 * @see #setRestInterface(boolean)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_RestInterface()
	 * @model default="true"
	 * @generated
	 */
	boolean isRestInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#isRestInterface <em>Rest Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest Interface</em>' attribute.
	 * @see #isRestInterface()
	 * @generated
	 */
	void setRestInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gecko.ma.config.SourceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see org.eclipse.gecko.ma.config.SourceType
	 * @see #setSourceType(SourceType)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_SourceType()
	 * @model
	 * @generated
	 */
	SourceType getSourceType();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see org.eclipse.gecko.ma.config.SourceType
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(SourceType value);

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gecko.ma.config.ConfigurationStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.eclipse.gecko.ma.config.ConfigurationStage
	 * @see #setStage(ConfigurationStage)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_Stage()
	 * @model
	 * @generated
	 */
	ConfigurationStage getStage();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.eclipse.gecko.ma.config.ConfigurationStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ConfigurationStage value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(long)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_Version()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(long value);

	/**
	 * Returns the value of the '<em><b>Lifecycle</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gecko.ma.config.ConfigurationLifecycle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifecycle</em>' attribute.
	 * @see org.eclipse.gecko.ma.config.ConfigurationLifecycle
	 * @see #setLifecycle(ConfigurationLifecycle)
	 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getPackageModelConfiguration_Lifecycle()
	 * @model transient="true"
	 * @generated
	 */
	ConfigurationLifecycle getLifecycle();

	/**
	 * Sets the value of the '{@link org.eclipse.gecko.ma.config.PackageModelConfiguration#getLifecycle <em>Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifecycle</em>' attribute.
	 * @see org.eclipse.gecko.ma.config.ConfigurationLifecycle
	 * @see #getLifecycle()
	 * @generated
	 */
	void setLifecycle(ConfigurationLifecycle value);

} // PackageModelConfiguration
