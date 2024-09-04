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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Configuration Lifecycle</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gecko.ma.config.MaconfigPackage#getConfigurationLifecycle()
 * @model
 * @generated
 */
@ProviderType
public enum ConfigurationLifecycle implements Enumerator {
	/**
	 * The '<em><b>LOADED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADED_VALUE
	 * @generated
	 * @ordered
	 */
	LOADED(0, "LOADED", "LOADED"),

	/**
	 * The '<em><b>REGISTERING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTERING_VALUE
	 * @generated
	 * @ordered
	 */
	REGISTERING(1, "REGISTERING", "REGISTERING"),

	/**
	 * The '<em><b>REGISTERED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTERED_VALUE
	 * @generated
	 * @ordered
	 */
	REGISTERED(2, "REGISTERED", "REGISTERED"),

	/**
	 * The '<em><b>UNREGISTERING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNREGISTERING_VALUE
	 * @generated
	 * @ordered
	 */
	UNREGISTERING(3, "UNREGISTERING", "UNREGISTERING"),

	/**
	 * The '<em><b>UNREGISTERED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNREGISTERED_VALUE
	 * @generated
	 * @ordered
	 */
	UNREGISTERED(4, "UNREGISTERED", "UNREGISTERED"),

	/**
	 * The '<em><b>UPDATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATING_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATING(5, "UPDATING", "UPDATING"),

	/**
	 * The '<em><b>UPDATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATED_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATED(6, "UPDATED", "UPDATED");

	/**
	 * The '<em><b>LOADED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOADED_VALUE = 0;

	/**
	 * The '<em><b>REGISTERING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTERING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGISTERING_VALUE = 1;

	/**
	 * The '<em><b>REGISTERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTERED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGISTERED_VALUE = 2;

	/**
	 * The '<em><b>UNREGISTERING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNREGISTERING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNREGISTERING_VALUE = 3;

	/**
	 * The '<em><b>UNREGISTERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNREGISTERED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNREGISTERED_VALUE = 4;

	/**
	 * The '<em><b>UPDATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPDATING_VALUE = 5;

	/**
	 * The '<em><b>UPDATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPDATED_VALUE = 6;

	/**
	 * An array of all the '<em><b>Configuration Lifecycle</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConfigurationLifecycle[] VALUES_ARRAY =
		new ConfigurationLifecycle[] {
			LOADED,
			REGISTERING,
			REGISTERED,
			UNREGISTERING,
			UNREGISTERED,
			UPDATING,
			UPDATED,
		};

	/**
	 * A public read-only list of all the '<em><b>Configuration Lifecycle</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConfigurationLifecycle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Configuration Lifecycle</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConfigurationLifecycle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConfigurationLifecycle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Configuration Lifecycle</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConfigurationLifecycle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConfigurationLifecycle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Configuration Lifecycle</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConfigurationLifecycle get(int value) {
		switch (value) {
			case LOADED_VALUE: return LOADED;
			case REGISTERING_VALUE: return REGISTERING;
			case REGISTERED_VALUE: return REGISTERED;
			case UNREGISTERING_VALUE: return UNREGISTERING;
			case UNREGISTERED_VALUE: return UNREGISTERED;
			case UPDATING_VALUE: return UPDATING;
			case UPDATED_VALUE: return UPDATED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ConfigurationLifecycle(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ConfigurationLifecycle
