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
package org.eclipse.gecko.ma.api.init;

import org.eclipse.gecko.ma.config.PackageModelConfiguration;

/**
 * Exception thrown during {@link PackageModelConfiguration} execution
 * @author Mark Hoffmann
 * @since 15.07.2024
 */
public class PackageConfiguratorException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new instance.
	 */
	public PackageConfiguratorException(Throwable t) {
		super(t);
	}
	
	/**
	 * Creates a new instance.
	 */
	public PackageConfiguratorException(String message, Throwable t) {
		super(message, t);
	}

}
