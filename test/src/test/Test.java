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
package test;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author mark
 * @since 07.08.2024
 */
@Component
public class Test {

	@Activate
	public void activate() {
		System.out.println("Hallo " + System.getProperty("name") + " " + System.getProperty("test"));
		System.out.println("Encoding: " + System.getProperty("file.encoding"));
	}

}
