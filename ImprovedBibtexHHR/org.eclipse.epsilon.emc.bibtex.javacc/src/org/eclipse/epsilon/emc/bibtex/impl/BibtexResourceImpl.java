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

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.epsilon.emc.bibtex.parser.javacc.BibtexParser;

public class BibtexResourceImpl extends ResourceImpl {
	
	
	public BibtexResourceImpl() {
		super();
	}

	public BibtexResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException
	{
		BibtexParser bibtex = new BibtexParser(inputStream);
		try {
			BibtexBibliography b = bibtex.bibliography();
			this.getContents().add(b);
		} catch (Exception e) {
			throw new IOException(e);
		} catch (Error e) {
			Exception ex = new Exception("Error. " + e.getMessage());
			throw new IOException(ex);
        } 
	}

}
