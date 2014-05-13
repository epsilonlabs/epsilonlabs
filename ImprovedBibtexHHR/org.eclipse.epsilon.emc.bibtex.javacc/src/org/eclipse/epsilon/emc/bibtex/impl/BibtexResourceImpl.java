package org.eclipse.epsilon.emc.bibtex.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.epsilon.emc.bibtex.parser.javacc.Bibtex;

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
		Bibtex bibtex = new Bibtex(inputStream);
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
