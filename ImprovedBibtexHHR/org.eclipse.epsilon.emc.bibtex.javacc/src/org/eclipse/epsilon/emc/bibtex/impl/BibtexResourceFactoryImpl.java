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
