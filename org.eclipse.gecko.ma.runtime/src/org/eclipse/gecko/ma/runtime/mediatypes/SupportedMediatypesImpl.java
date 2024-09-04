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
package org.eclipse.gecko.ma.runtime.mediatypes;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gecko.emf.osgi.ResourceSetFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.osgi.service.component.annotations.ServiceScope;

import org.eclipse.gecko.ma.api.mediatypes.SupportedMediatype;

/**
 * Default implementation that gathers the supported mediatypes based on the resource sets
 * @author Mark Hoffmann
 * @since 15.07.2024
 */
@Component(immediate = true, scope = ServiceScope.SINGLETON)
public class SupportedMediatypesImpl implements SupportedMediatype{

	private List<String> mediaTypes;
	
	@Reference(updated = "bindResourceSetFactory", policyOption = ReferencePolicyOption.GREEDY)
	void bindResourceSetFactory(ResourceSetFactory rsFactory) {
		ResourceSet set =  rsFactory.createResourceSet();
		
		mediaTypes = set
			.getResourceFactoryRegistry()
			.getContentTypeToFactoryMap()
			.keySet()
			.stream()
			.filter(s -> s.startsWith("application/") || s.startsWith("text/"))
			.toList();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.jena.mdo.mimetypes.api.SupportedMediatype#getSupportedMediaTypes()
	 */
	@Override
	public List<String> getSupportedMediaTypes() {
		return mediaTypes;
	}


}
