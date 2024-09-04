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
@RequireEMFJson
@RequireEMFMessageBodyReaderWriter
@RequireMongoEMFRepository
@RequireConfigurationAdmin
package org.eclipse.gecko.ma.runtime;

import org.gecko.emf.json.annotation.RequireEMFJson;
import org.gecko.emf.repository.mongo.annotations.RequireMongoEMFRepository;
import org.gecko.emf.rest.annotations.RequireEMFMessageBodyReaderWriter;
import org.osgi.service.cm.annotations.RequireConfigurationAdmin;
