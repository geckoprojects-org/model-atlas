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
package org.eclipse.gecko.ma.rest.swagger;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardResource;

@HttpWhiteboardResource(pattern = SwaggerResources.CONFIG_PATTERN_NAME, prefix = SwaggerResources.CONFIG_PREFIX_DEFAULT)
@Component(name = SwaggerResources.COMPONENT_NAME, service = SwaggerResources.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
public class SwaggerResources {
	
	public static final String COMPONENT_NAME = "SwaggerResources";
	public static final String CONFIG_PATTERN_NAME = "SWAGGER_PATTER";
	public static final String CONFIG_PREFIX_DEFAULT = "/swagger-api";
}

