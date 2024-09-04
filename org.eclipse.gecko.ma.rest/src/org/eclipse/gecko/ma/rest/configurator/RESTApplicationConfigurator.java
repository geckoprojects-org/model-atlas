/**
 * Copyright (c) 2012 - 2024 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.eclipse.gecko.ma.rest.configurator;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gecko.ma.annotations.PMConfigurator;
import org.eclipse.gecko.ma.api.init.DefaultPackageModelConfigurator;
import org.eclipse.gecko.ma.api.init.PackageModelConfigurationHandler;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.rest.MAApplication;
import org.eclipse.gecko.ma.rest.resource.ModelResource;
import org.gecko.emf.osgi.constants.EMFNamespaces;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jakartars.whiteboard.JakartarsWhiteboardConstants;

/**
 * Configuration component to configure a new JakartaRS application for the {@link EPackage}s
 * @author Juergen Albert
 * @since 22 Mar 2022
 */
@PMConfigurator(name = "MAREST", type = "REST")
@Component(service = PackageModelConfigurationHandler.class)
public class RESTApplicationConfigurator extends DefaultPackageModelConfigurator {

	private static final Logger logger = Logger.getLogger(RESTApplicationConfigurator.class.getName());
	private static final String APPLICATION_SUFFIX = "MAApplication";
	private static final String RESOURCE_SUFFIX = "MAResource";
	private static final String TARGET_SUFFIX = ".target";
	private static final String PROP_APPLICATION_ID = "restId";

	@Reference
	private ConfigurationAdmin configAdmin;
	@Reference(target = "(ma.rest=OpenAPI)")
	private PackageModelConfigurationHandler openApiConfig;
//	@Reference(target = "(ma.rest=Documentation)")
//	private PackageModelConfigurator documentationConfig;

	//	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = "(ma.rest=true)")
	//	protected void bindEPackage(EPackage ePackage, Map<String, Object> properties) throws IOException {
	//		try {
	//			logger.fine(()->"Binding ePackage " + ePackage.getNsURI());
	//
	//			List<Configuration> configList = packageConfigMap.computeIfAbsent(ePackage, p-> new ArrayList<>());
	//
	//			registerApplication(ePackage, configList);
	//			registerResource(ePackage, properties, configList);
	//
	//			// Register Documentation if available
	//			//			documentationConfig.configureRESTApplication(ePackage, properties);
	//			//			Configuration docConfiguration = documentationConfig.configureApplication(ePackage, properties);
	//			//			if (nonNull(docConfiguration)) {
	//			//				configList.add(docConfiguration);
	//			//			}
	//
	//			//			if(modelDocumentationProvider.hasEPackageChanged(ePackage)) {
	//			//			
	//			//				Configuration decumentationConfig = configAdmin.createFactoryConfiguration(DocumentationResource.COMPONENT_NAME, "?");
	//			//				configList.add(decumentationConfig);
	//			//				
	//			//				Dictionary<String, Object> documentationResourceProperties = new Hashtable<String, Object>();
	//			//				documentationResourceProperties.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, ePackage.getName() + "DocumentationJaxRsResource");
	//			//				documentationResourceProperties.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_SELECT, "(id=" + ePackage.getNsURI() + ")");
	//			//				documentationResourceProperties.put(DocumentationResource.EPACKAGE_REFERENCE_NAME + ".target", "(" + EMFNamespaces.EMF_MODEL_NSURI + "=" + ePackage.getNsURI() + ")");
	//			//				
	//			//				if (properties.containsKey("Piveau")) {
	//			//					Object piveauData = properties.get("Piveau");
	//			//					documentationResourceProperties.put("Piveau", piveauData);
	//			//				}
	//			//				
	//			//				System.out.println("Regenerating documentation...");
	//			//				Map<String, String> packageDocFileMap = modelDocumentationProvider.generateAllPackageDocumentation(ePackage);
	//			//				Map<String, String> classesDocFileMap = modelDocumentationProvider.generateAllClassesDocumentation(ePackage);
	//			//				packageDocFileMap.forEach((k,v) -> documentationResourceProperties.put(k, v));
	//			//				classesDocFileMap.forEach((k,v) -> documentationResourceProperties.put(k, v));
	//			//				
	//			//				if (properties.containsKey("emf.model.name")) {
	//			//					Object modelName = properties.get("emf.model.name");
	//			//					documentationResourceProperties.put("emf.model.name", modelName);
	//			//				}
	//			//				decumentationConfig.update(documentationResourceProperties);
	//			//				logger.fine(()->"Registering Documentation resource " + ePackage.getName() + "JaxRsResource");
	//			//			}
	//
	//			// Configure OpenApi
	//			openApiConfig.configureRESTApplication(ePackage, properties);
	//			//			Configuration openApiConfiguration = openApiConfig.configureApplication(ePackage, properties);
	//			//			if (nonNull(openApiConfiguration)) {
	//			//				configList.add(openApiConfiguration);
	//			//			}
	//
	//			//			Configuration openApiConfig = configAdmin.createFactoryConfiguration(OpenApiResource.COMPONENT_NAME, "?");
	//			//			configList.add(openApiConfig);
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put("name", ePackage.getName() + " Application");
	//			//			props.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, ePackage.getName() + "OpenApiResource");
	//			//			props.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_SELECT, "(id=" + ePackage.getNsURI() + ")");
	//			//			openApiConfig.update(props);
	//			//			logger.fine(()->"Registering OpenAPI resource " + ePackage.getName() + "OpenApiResource");
	//			//	
	//			//			/* Swagger Config */
	//			//			
	//			//			String swaggerAppBasePath = "/swagger/" + ePackage.getName() + "/swagger-client";
	//			//			String swaggerContextNameHelper = ePackage.getName() + "_Swagger_Servlet_Contex_Helper_Resources";
	//			//	
	//			//			Configuration swaggerResourceConfig = configAdmin.createFactoryConfiguration(SwaggerResources.COMPONENT_NAME, "?");
	//			//			configList.add(swaggerResourceConfig);
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put("name", ePackage.getName() + " Swagger Resources");
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
	//			//					+ swaggerContextNameHelper + ")");
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN, "/*");
	//			//			swaggerResourceConfig.update(props);
	//			//	
	//			//			Configuration swaggerContextConfig = configAdmin.createFactoryConfiguration(SwaggerServletContextHelper.COMPONENT_NAME, "?");
	//			//			configList.add(swaggerContextConfig);
	//			//			
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME, swaggerContextNameHelper);
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH, swaggerAppBasePath);
	//			//			swaggerContextConfig.update(props);
	//			//	
	//			//			Configuration swaggerIndexFilterConfig = configAdmin.createFactoryConfiguration(SwaggerIndexFilter.COMPONENT_NAME, "?");
	//			//			configList.add(swaggerIndexFilterConfig);
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
	//			//					+ swaggerContextNameHelper + ")");
	//			//			props.put("path", "/mdo" + swaggerAppBasePath);
	//			//			swaggerIndexFilterConfig.update(props);
	//			//			logger.fine(()->"Registering OpenAPI Swagger " + ePackage.getName() + " Swagger Resources");
	//		} catch (Exception e) {
	//			logger.log(Level.SEVERE, "Error while creating REST configurations for model " + ePackage.getName() + " - " + ePackage.getNsURI(), e);
	//		}
	//	}
	//
	//	protected void unbindEPackage(EPackage ePackage, Map<String, Object> properties) {
	//		logger.fine(()->"Unbinding ePackage " + ePackage.getNsURI());
	//		//		documentationConfig.unconfigureRESTApplication(ePackage, properties);
	//		openApiConfig.unconfigureRESTApplication(ePackage, properties);
	//		List<Configuration> list = packageConfigMap.remove(ePackage);
	//		if(nonNull(list)) {
	//			list.forEach(c -> {
	//				try {
	//					c.delete();
	//				} catch (IOException e) {
	//					logger.log(Level.SEVERE, "Error deleteing configuration: " + c.getPid(), e);
	//				}
	//			});
	//		}
	//	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.PackageModelConfigurator#canConfigure(org.eclipse.gecko.ma.config.PackageModelConfiguration)
	 */
	@Override
	public boolean canConfigure(PackageModelConfiguration configuration) {
		return isNull(configuration) ? false : configuration.isRestInterface();
	}


	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.DefaultPackageModelConfigurator#doConfigurePackage(org.eclipse.gecko.ma.config.PackageModelConfiguration, java.util.List)
	 */
	@Override
	protected void doConfigurePackage(PackageModelConfiguration configuration, List<Configuration> configurations) {
		requireNonNull(configuration);
		try {
			logger.fine(()->String.format("Configuration REST for EPackage '%s'", configuration.getNsUri()));

			registerApplication(configuration, configurations);
			registerResource(configuration, configurations);

			// Configure OpenApi
			if (openApiConfig.canConfigure(configuration)) {
				openApiConfig.doConfigure(configuration);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, String.format("Error while creating REST configurations for EPackage '%s' ", configuration.getNsUri()), e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.DefaultPackageModelConfigurator#doUnconfigurePackage(org.eclipse.gecko.ma.config.PackageModelConfiguration, java.util.List)
	 */
	@Override
	protected void doUnconfigurePackage(PackageModelConfiguration configuration, List<Configuration> configurations) {
		requireNonNull(configuration);

		logger.fine(()->String.format("Unbinding EPackage '%s'", configuration.getNsUri()));
		//		documentationConfig.unconfigureRESTApplication(ePackage, properties);
		if (openApiConfig.canConfigure(configuration)) {
			openApiConfig.doUnConfigure(configuration);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gecko.ma.api.init.DefaultPackageModelConfigurator#doReconfigurePackage(org.eclipse.gecko.ma.config.PackageModelConfiguration, java.util.List)
	 */
	@Override
	protected void doReconfigurePackage(PackageModelConfiguration configuration, List<Configuration> configList) {
		super.doReconfigurePackage(configuration, configList);
	}

	//	@Reference(target = "(" + EPackageRESTConfigurator.RESOURCE_TYPE	+ "=Documentation)")
	//	private EPackageRESTConfigurator documentationConfig;
	
	//	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = "(ma.rest=true)")
	//	protected void bindEPackage(EPackage ePackage, Map<String, Object> properties) throws IOException {
	//		try {
	//			logger.fine(()->"Binding ePackage " + ePackage.getNsURI());
	//
	//			List<Configuration> configList = packageConfigMap.computeIfAbsent(ePackage, p-> new ArrayList<>());
	//
	//			registerApplication(ePackage, configList);
	//			registerResource(ePackage, properties, configList);
	//
	//			// Register Documentation if available
	//			//			documentationConfig.configureRESTApplication(ePackage, properties);
	//			//			Configuration docConfiguration = documentationConfig.configureApplication(ePackage, properties);
	//			//			if (nonNull(docConfiguration)) {
	//			//				configList.add(docConfiguration);
	//			//			}
	//
	//			//			if(modelDocumentationProvider.hasEPackageChanged(ePackage)) {
	//			//			
	//			//				Configuration decumentationConfig = configAdmin.createFactoryConfiguration(DocumentationResource.COMPONENT_NAME, "?");
	//			//				configList.add(decumentationConfig);
	//			//				
	//			//				Dictionary<String, Object> documentationResourceProperties = new Hashtable<String, Object>();
	//			//				documentationResourceProperties.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, ePackage.getName() + "DocumentationJaxRsResource");
	//			//				documentationResourceProperties.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_SELECT, "(id=" + ePackage.getNsURI() + ")");
	//			//				documentationResourceProperties.put(DocumentationResource.EPACKAGE_REFERENCE_NAME + ".target", "(" + EMFNamespaces.EMF_MODEL_NSURI + "=" + ePackage.getNsURI() + ")");
	//			//				
	//			//				if (properties.containsKey("Piveau")) {
	//			//					Object piveauData = properties.get("Piveau");
	//			//					documentationResourceProperties.put("Piveau", piveauData);
	//			//				}
	//			//				
	//			//				System.out.println("Regenerating documentation...");
	//			//				Map<String, String> packageDocFileMap = modelDocumentationProvider.generateAllPackageDocumentation(ePackage);
	//			//				Map<String, String> classesDocFileMap = modelDocumentationProvider.generateAllClassesDocumentation(ePackage);
	//			//				packageDocFileMap.forEach((k,v) -> documentationResourceProperties.put(k, v));
	//			//				classesDocFileMap.forEach((k,v) -> documentationResourceProperties.put(k, v));
	//			//				
	//			//				if (properties.containsKey("emf.model.name")) {
	//			//					Object modelName = properties.get("emf.model.name");
	//			//					documentationResourceProperties.put("emf.model.name", modelName);
	//			//				}
	//			//				decumentationConfig.update(documentationResourceProperties);
	//			//				logger.fine(()->"Registering Documentation resource " + ePackage.getName() + "JaxRsResource");
	//			//			}
	//
	//			// Configure OpenApi
	//			openApiConfig.configureRESTApplication(ePackage, properties);
	//			//			Configuration openApiConfiguration = openApiConfig.configureApplication(ePackage, properties);
	//			//			if (nonNull(openApiConfiguration)) {
	//			//				configList.add(openApiConfiguration);
	//			//			}
	//
	//			//			Configuration openApiConfig = configAdmin.createFactoryConfiguration(OpenApiResource.COMPONENT_NAME, "?");
	//			//			configList.add(openApiConfig);
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put("name", ePackage.getName() + " Application");
	//			//			props.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, ePackage.getName() + "OpenApiResource");
	//			//			props.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_SELECT, "(id=" + ePackage.getNsURI() + ")");
	//			//			openApiConfig.update(props);
	//			//			logger.fine(()->"Registering OpenAPI resource " + ePackage.getName() + "OpenApiResource");
	//			//	
	//			//			/* Swagger Config */
	//			//			
	//			//			String swaggerAppBasePath = "/swagger/" + ePackage.getName() + "/swagger-client";
	//			//			String swaggerContextNameHelper = ePackage.getName() + "_Swagger_Servlet_Contex_Helper_Resources";
	//			//	
	//			//			Configuration swaggerResourceConfig = configAdmin.createFactoryConfiguration(SwaggerResources.COMPONENT_NAME, "?");
	//			//			configList.add(swaggerResourceConfig);
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put("name", ePackage.getName() + " Swagger Resources");
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
	//			//					+ swaggerContextNameHelper + ")");
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN, "/*");
	//			//			swaggerResourceConfig.update(props);
	//			//	
	//			//			Configuration swaggerContextConfig = configAdmin.createFactoryConfiguration(SwaggerServletContextHelper.COMPONENT_NAME, "?");
	//			//			configList.add(swaggerContextConfig);
	//			//			
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME, swaggerContextNameHelper);
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH, swaggerAppBasePath);
	//			//			swaggerContextConfig.update(props);
	//			//	
	//			//			Configuration swaggerIndexFilterConfig = configAdmin.createFactoryConfiguration(SwaggerIndexFilter.COMPONENT_NAME, "?");
	//			//			configList.add(swaggerIndexFilterConfig);
	//			//			
	//			//			props = new Hashtable<String, Object>();
	//			//			props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
	//			//					+ swaggerContextNameHelper + ")");
	//			//			props.put("path", "/mdo" + swaggerAppBasePath);
	//			//			swaggerIndexFilterConfig.update(props);
	//			//			logger.fine(()->"Registering OpenAPI Swagger " + ePackage.getName() + " Swagger Resources");
	//		} catch (Exception e) {
	//			logger.log(Level.SEVERE, "Error while creating REST configurations for model " + ePackage.getName() + " - " + ePackage.getNsURI(), e);
	//		}
	//	}
	//
	//	protected void unbindEPackage(EPackage ePackage, Map<String, Object> properties) {
	//		logger.fine(()->"Unbinding ePackage " + ePackage.getNsURI());
	//		//		documentationConfig.unconfigureRESTApplication(ePackage, properties);
	//		openApiConfig.unconfigureRESTApplication(ePackage, properties);
	//		List<Configuration> list = packageConfigMap.remove(ePackage);
	//		if(nonNull(list)) {
	//			list.forEach(c -> {
	//				try {
	//					c.delete();
	//				} catch (IOException e) {
	//					logger.log(Level.SEVERE, "Error deleteing configuration: " + c.getPid(), e);
	//				}
	//			});
	//		}
	//	}
	
	/**
	 * Creates the application registration configuration
	 * @param configuration the {@link PackageModelConfiguration}
	 * @param configList the list with configurations
	 * @throws IOException
	 */
	private void registerApplication(PackageModelConfiguration configuration, List<Configuration> configList) throws IOException {
		Configuration applicationConfig = configAdmin.createFactoryConfiguration(MAApplication.COMPONENT_NAME, "?");
		configList.add(applicationConfig);
	
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_BASE, configuration.getName());
		props.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, configuration.getName() + APPLICATION_SUFFIX);
		props.put(PROP_APPLICATION_ID, configuration.getNsUri());
		applicationConfig.update(props);
		logger.fine(()->String.format("Registering REST application: '%s'", configuration.getName() + APPLICATION_SUFFIX));
	}

	/**
	 * Creates the REST resource registration configuration
	 * @param configuration the {@link EPackage}
	 * @param properties the configuration properties
	 * @param configList the list with configurations
	 * @throws IOException
	 */
	private void registerResource(PackageModelConfiguration configuration, List<Configuration> configList)
			throws IOException {
		Configuration resourceConfig = configAdmin.createFactoryConfiguration(ModelResource.COMPONENT_NAME, "?");
		configList.add(resourceConfig);
	
		Dictionary<String, Object> modelResourceProperties = new Hashtable<String, Object>();
		modelResourceProperties.put(JakartarsWhiteboardConstants.JAKARTA_RS_NAME, configuration.getName() + RESOURCE_SUFFIX);
		modelResourceProperties.put(JakartarsWhiteboardConstants.JAKARTA_RS_APPLICATION_SELECT, String.format("(%s=%s)", PROP_APPLICATION_ID, configuration.getNsUri()));
		modelResourceProperties.put(ModelResource.EPACKAGE_REFERENCE_NAME + TARGET_SUFFIX, String.format("(%s=%s)", EMFNamespaces.EMF_MODEL_NSURI, configuration.getNsUri()));
		modelResourceProperties.put(ModelResource.REPO_REFERENCE_NAME + TARGET_SUFFIX, "(repo_id=ma.schema)");
		Object modelName = configuration.getName();
		modelResourceProperties.put(EMFNamespaces.EMF_MODEL_NAME, modelName);
		resourceConfig.update(modelResourceProperties);
		logger.fine(()->String.format("Registering REST resource: '%s'", configuration.getName() + RESOURCE_SUFFIX));
	}

}
