/**
 * Copyright (c) 2012 - 2022 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 *     Stefan Bishof - API and implementation
 *     Tim Ward - implementation
 */
package org.eclipse.gecko.ma.rest.resource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jakartars.whiteboard.propertytypes.JakartarsName;
import org.osgi.service.jakartars.whiteboard.propertytypes.JakartarsResource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * This is a Demo Resource for a Jakartars Whiteboard 
 * 
 * @since 1.0
 */
@JakartarsResource
@JakartarsName("hello-rs")
@Component(service = Object.class, enabled = true, scope = ServiceScope.PROTOTYPE)
@Path("/")
public class DemoResource {

	/**
	 * Please check http://localhost:8082/atlasrest/hello-http-whiteboard
	 * @return
	 */
	@GET
	@Path("/hello")
	public String hello() {
		return "Hello World (via HTTP Whiteboard)!";
	}

}
