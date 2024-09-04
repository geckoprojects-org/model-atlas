/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.eclipse.gecko.ma.annotations;

import static org.eclipse.gecko.ma.MAConstants.PREFIX_MA_CONFIG;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osgi.service.component.annotations.ComponentPropertyType;

/**
 * Component Property Type for the {@code org.eclipse.gecko.ma.api.init.PackageModelConfigurator} service
 * property.
 * <p>
 * This annotation can be used on a {@link PMConfigurator} to declare it a callback for the corresponding 
 * whiteboard.
 * 
 * @see "Component Property Types"
 */
@ComponentPropertyType
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface PMConfigurator {
	/**
	 * Prefix for the property name. This value is prepended to each property
	 * name.
	 */
	String PREFIX_ = PREFIX_MA_CONFIG;
	
	String name();
	
	String type();

	// This is a marker annotation.
}