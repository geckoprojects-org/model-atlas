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
package org.eclipse.gecko.ma.config.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.gecko.ma.config.ConfigurationLifecycle;
import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.MaconfigPackage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Model Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getPid <em>Pid</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getNsUri <em>Ns Uri</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getSourceUri <em>Source Uri</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getEPackageRef <em>EPackage Ref</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#isRestInterface <em>Rest Interface</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.gecko.ma.config.impl.PackageModelConfigurationImpl#getLifecycle <em>Lifecycle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageModelConfigurationImpl extends MinimalEObjectImpl.Container implements PackageModelConfiguration {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPid() <em>Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPid()
	 * @generated
	 * @ordered
	 */
	protected static final String PID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPid() <em>Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPid()
	 * @generated
	 * @ordered
	 */
	protected String pid = PID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsUri() <em>Ns Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsUri()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsUri() <em>Ns Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsUri()
	 * @generated
	 * @ordered
	 */
	protected String nsUri = NS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceUri() <em>Source Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceUri() <em>Source Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceUri()
	 * @generated
	 * @ordered
	 */
	protected String sourceUri = SOURCE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEPackageRef() <em>EPackage Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageRef()
	 * @generated
	 * @ordered
	 */
	protected EPackage ePackageRef;

	/**
	 * The default value of the '{@link #isRestInterface() <em>Rest Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRestInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REST_INTERFACE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRestInterface() <em>Rest Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRestInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean restInterface = REST_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected static final SourceType SOURCE_TYPE_EDEFAULT = SourceType.DIRECT;

	/**
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected SourceType sourceType = SOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigurationStage STAGE_EDEFAULT = ConfigurationStage.UNCONFIGURED;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ConfigurationStage stage = STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long VERSION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected long version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLifecycle() <em>Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigurationLifecycle LIFECYCLE_EDEFAULT = ConfigurationLifecycle.LOADED;

	/**
	 * The cached value of the '{@link #getLifecycle() <em>Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected ConfigurationLifecycle lifecycle = LIFECYCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageModelConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MaconfigPackage.Literals.PACKAGE_MODEL_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPid() {
		return pid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPid(String newPid) {
		String oldPid = pid;
		pid = newPid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__PID, oldPid, pid));
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNsUri() {
		return nsUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNsUri(String newNsUri) {
		String oldNsUri = nsUri;
		nsUri = newNsUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NS_URI, oldNsUri, nsUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSourceUri() {
		return sourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceUri(String newSourceUri) {
		String oldSourceUri = sourceUri;
		sourceUri = newSourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_URI, oldSourceUri, sourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPackage getEPackageRef() {
		if (ePackageRef != null && ePackageRef.eIsProxy()) {
			InternalEObject oldEPackageRef = (InternalEObject)ePackageRef;
			ePackageRef = (EPackage)eResolveProxy(oldEPackageRef);
			if (ePackageRef != oldEPackageRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF, oldEPackageRef, ePackageRef));
			}
		}
		return ePackageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetEPackageRef() {
		return ePackageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEPackageRef(EPackage newEPackageRef) {
		EPackage oldEPackageRef = ePackageRef;
		ePackageRef = newEPackageRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF, oldEPackageRef, ePackageRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRestInterface() {
		return restInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRestInterface(boolean newRestInterface) {
		boolean oldRestInterface = restInterface;
		restInterface = newRestInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE, oldRestInterface, restInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceType getSourceType() {
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceType(SourceType newSourceType) {
		SourceType oldSourceType = sourceType;
		sourceType = newSourceType == null ? SOURCE_TYPE_EDEFAULT : newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE, oldSourceType, sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurationStage getStage() {
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(ConfigurationStage newStage) {
		ConfigurationStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(long newVersion) {
		long oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurationLifecycle getLifecycle() {
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLifecycle(ConfigurationLifecycle newLifecycle) {
		ConfigurationLifecycle oldLifecycle = lifecycle;
		lifecycle = newLifecycle == null ? LIFECYCLE_EDEFAULT : newLifecycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__LIFECYCLE, oldLifecycle, lifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__ID:
				return getId();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__PID:
				return getPid();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NAME:
				return getName();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NS_URI:
				return getNsUri();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_URI:
				return getSourceUri();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF:
				if (resolve) return getEPackageRef();
				return basicGetEPackageRef();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE:
				return isRestInterface();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE:
				return getSourceType();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__STAGE:
				return getStage();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__VERSION:
				return getVersion();
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__LIFECYCLE:
				return getLifecycle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__ID:
				setId((String)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__PID:
				setPid((String)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NS_URI:
				setNsUri((String)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_URI:
				setSourceUri((String)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF:
				setEPackageRef((EPackage)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE:
				setRestInterface((Boolean)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE:
				setSourceType((SourceType)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__STAGE:
				setStage((ConfigurationStage)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__VERSION:
				setVersion((Long)newValue);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__LIFECYCLE:
				setLifecycle((ConfigurationLifecycle)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__ID:
				setId(ID_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__PID:
				setPid(PID_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NS_URI:
				setNsUri(NS_URI_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_URI:
				setSourceUri(SOURCE_URI_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF:
				setEPackageRef((EPackage)null);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE:
				setRestInterface(REST_INTERFACE_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE:
				setSourceType(SOURCE_TYPE_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__LIFECYCLE:
				setLifecycle(LIFECYCLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__PID:
				return PID_EDEFAULT == null ? pid != null : !PID_EDEFAULT.equals(pid);
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__NS_URI:
				return NS_URI_EDEFAULT == null ? nsUri != null : !NS_URI_EDEFAULT.equals(nsUri);
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_URI:
				return SOURCE_URI_EDEFAULT == null ? sourceUri != null : !SOURCE_URI_EDEFAULT.equals(sourceUri);
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__EPACKAGE_REF:
				return ePackageRef != null;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__REST_INTERFACE:
				return restInterface != REST_INTERFACE_EDEFAULT;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__SOURCE_TYPE:
				return sourceType != SOURCE_TYPE_EDEFAULT;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__STAGE:
				return stage != STAGE_EDEFAULT;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__VERSION:
				return version != VERSION_EDEFAULT;
			case MaconfigPackage.PACKAGE_MODEL_CONFIGURATION__LIFECYCLE:
				return lifecycle != LIFECYCLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", pid: ");
		result.append(pid);
		result.append(", name: ");
		result.append(name);
		result.append(", nsUri: ");
		result.append(nsUri);
		result.append(", sourceUri: ");
		result.append(sourceUri);
		result.append(", restInterface: ");
		result.append(restInterface);
		result.append(", sourceType: ");
		result.append(sourceType);
		result.append(", stage: ");
		result.append(stage);
		result.append(", version: ");
		result.append(version);
		result.append(", lifecycle: ");
		result.append(lifecycle);
		result.append(')');
		return result.toString();
	}

} //PackageModelConfigurationImpl
