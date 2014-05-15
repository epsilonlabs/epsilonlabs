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
package org.eclipse.epsilon.emc.bibtex;

import java.io.FileInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.bibtex.impl.BibtexBibliography;
import org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage;
import org.eclipse.epsilon.emc.bibtex.parser.BibtexParser;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IReflectiveModel;

// TODO: Auto-generated Javadoc
/**
 * The Class BibtexModel.
 */
public class BibtexModel extends EmfModel implements IReflectiveModel {
	
	/** The Constant PROPERTY_MODEL_URI. */
	public static final String PROPERTY_MODEL_URI = EmfModel.PROPERTY_MODEL_URI;
	
	/** The bibtex. */
	protected BibtexParser bibtex;
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.EmfModel#load(org.eclipse.epsilon.common.util.StringProperties, java.lang.String)
	 */
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		
		this.modelUri = URI.createURI(StringUtil.toString(basePath) + properties.getProperty(PROPERTY_MODEL_URI));
		try {
			String path = this.modelUri.toString();
			this.bibtex = new BibtexParser(new FileInputStream(path));
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
		super.load(properties, basePath);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.EmfModel#loadModelFromUri()
	 */
	@Override
	public void loadModelFromUri() throws EolModelLoadingException {
		
		ResourceSet resourceSet = createResourceSet();
		determinePackagesFrom(resourceSet);
		// Note that AbstractEmfModel#getPackageRegistry() is not usable yet, as modelImpl is not set
		for (EPackage ep : packages) {
			String nsUri = ep.getNsURI();
			if (nsUri == null || nsUri.trim().length() == 0) {
				nsUri = ep.getName();
			}
			resourceSet.getPackageRegistry().put(nsUri, ep);
		}
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, BibtexBibtexPackage.eINSTANCE);
		
		Resource model = resourceSet.createResource(modelUri);
		//modelImpl = rs.createResource(URI.createFileURI(""));
		if (this.readOnLoad) {
			try {
				BibtexBibliography b = bibtex.bibliography();
				model.getContents().add(b);
			} catch (Exception e) {
				throw new EolModelLoadingException(e, this);
			} catch (Error e) {
				Exception ex = new Exception("Error. " + e.getMessage());
				throw new EolModelLoadingException(ex, this);
            } 
		}
		modelImpl = model;
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.emf.EmfModel#store()
	 */
	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}


}
