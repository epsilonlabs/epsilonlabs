/*******************************************************************************
 * Copyright (c) 2013 Horacio Hoyos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.bibtex.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class BibtexResourceFactoryImpl extends ResourceFactoryImpl {

	public BibtexResourceFactoryImpl() {
		super();
	}
	
	@Override
	public Resource createResource(URI uri)
	{
		return new BibtexResourceImpl(uri);
	}
}
