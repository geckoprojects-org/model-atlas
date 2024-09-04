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
package org.eclipse.gecko.ma;

/**
 * Constants class
 * @author Mark Hoffmann
 * @since 01.08.2024
 */
public interface MAConstants {

	static final String PREFIX_MA_CONFIG = "ma.config.";
	
	static final String PROPERTY_CONFIG_NAME = PREFIX_MA_CONFIG + "name";
	static final String PROPERTY_CONFIG_TYPE = PREFIX_MA_CONFIG + "type";
	
	static final String PROPERTY_MA_REGISTRY = "ma.registry";
	static final String DEFAULT_MA_REGISTRY_NAME = "DEFAULT";
	static final String DEFAULT_REGISTRY_PROPERTY = PROPERTY_MA_REGISTRY + "=" + DEFAULT_MA_REGISTRY_NAME;
	static final String DEFAULT_REGISTRY_FILTER = "(" + DEFAULT_REGISTRY_PROPERTY + ")";
	
	
}
