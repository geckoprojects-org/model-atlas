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
package org.eclipse.gecko.ma.rest.openapi;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.gecko.ma.api.init.DefaultPackageModelConfigurator;
import org.eclipse.gecko.ma.api.init.PackageConfiguratorException;
import org.eclipse.gecko.ma.api.init.PackageModelConfigurationHandler;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.rest.swagger.SwaggerIndexFilter;
import org.eclipse.gecko.ma.rest.swagger.SwaggerResources;
import org.eclipse.gecko.ma.rest.swagger.SwaggerServletContextHelper;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;
import org.osgi.service.jakartars.whiteboard.JakartarsWhiteboardConstants;

/**
 * {@link PackageModelConfigurationHandler} for REST Applications having OpenAPI / Swagger
 * This is no standard {@link PackageModelConfigurationHandler} meant to be used from the confgiration whiteboard.
 * This is used in the 'RESTApplicationConfigurator' to create a consistent REST setup! 
 * @author Mark Hoffmann
 * @since 15.07.2024
 */
@Component(service = PackageModelConfigurationHandler.class, immediate = true, property = "ma.rest=OpenAPI")
public class OpenApiConfigurator extends DefaultPackageModelConfigurator {

	private static final Logger logger = Logger.getLogger(OpenApiConfigurator.class.getName());
	@Reference
	private ConfigurationAdmin configAdmin;

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.DefaultPackageModelConfigurator#doConfigurePackage(org.eclipse.gecko.ma.api.init.PackageModelConfiguration, java.util.List)
	 */
	@Override
	protected void doConfigurePackage(PackageModelConfiguration configuration, List<Configuration> configurations) {
		try {
			Configuration openApiConfig = configAdmin.createFactoryConfiguration(OpenApiResource.COMPONENT_NAME, "?");

			Dictionary<String, Object> props = new Hashtable<String, Object>();
			props.put("name", configuration.getName() + " Application");
			props.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, configuration.getName() + "OpenApiResource");
			props.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_SELECT, "(id=" + configuration.getNsUri() + ")");
			openApiConfig.update(props);
			logger.fine(()->"Registering OpenAPI resource " + configuration.getName() + "OpenApiResource");

			/* Swagger Config */

			String swaggerAppBasePath = "/swagger/" + configuration.getName() + "/swagger-client";
			String swaggerContextNameHelper = configuration.getName() + "_Swagger_Servlet_Contex_Helper_Resources";

			Configuration swaggerResourceConfig = configAdmin.createFactoryConfiguration(SwaggerResources.COMPONENT_NAME, "?");

			props = new Hashtable<String, Object>();
			props.put("name", configuration.getName() + " Swagger Resources");
			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
					+ swaggerContextNameHelper + ")");
			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN, "/*");
			swaggerResourceConfig.update(props);

			Configuration swaggerContextConfig = configAdmin.createFactoryConfiguration(SwaggerServletContextHelper.COMPONENT_NAME, "?");


			props = new Hashtable<String, Object>();
			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME, swaggerContextNameHelper);
			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH, swaggerAppBasePath);
			swaggerContextConfig.update(props);

			Configuration swaggerIndexFilterConfig = configAdmin.createFactoryConfiguration(SwaggerIndexFilter.COMPONENT_NAME, "?");

			props = new Hashtable<String, Object>();
			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
					+ swaggerContextNameHelper + ")");
			props.put("path", "/mdo" + swaggerAppBasePath);
			swaggerIndexFilterConfig.update(props);

			synchronized (configurations) {
				configurations.add(openApiConfig);
				configurations.add(swaggerResourceConfig);
				configurations.add(swaggerContextConfig);
				configurations.add(swaggerIndexFilterConfig);
			}
			logger.fine(()->String.format("Registering OpenAPI Swagger '%s' resource", configuration.getName()));
		} catch (Exception e) {
			throw new PackageConfiguratorException(String.format("Error configuring OpenAPI and Swagger for EPackage '%s - %s", configuration.getName(), configuration.getNsUri()), e);
		}
	}

}
