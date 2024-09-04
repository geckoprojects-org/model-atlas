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

import java.util.List;
import java.util.Optional;

import org.eclipse.gecko.ma.config.ConfigurationStage;
import org.eclipse.gecko.ma.config.PackageModelConfiguration;
import org.eclipse.gecko.ma.config.SourceType;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Service to handle {@link PackageModelConfiguration} management or save and update them. 
 * @author Mark Hoffmann
 * @since 18.07.2024
 */
@ProviderType
public interface ModelConfigurationManager extends ModelConfigurationStore {
	
}
