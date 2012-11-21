package org.eclipse.epsilon.xminus;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class XminusResourceFactory implements Resource.Factory {

	@Override
	public Resource createResource(URI uri) {
		return new XminusResource(uri);
	}

}
