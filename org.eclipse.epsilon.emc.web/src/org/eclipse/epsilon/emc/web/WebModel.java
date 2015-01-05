/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.web;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.web.scrapers.ResourceScraper;
import org.eclipse.epsilon.emc.web.scrapers.ScraperFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class WebModel extends AbstractEmfModel {

	private final String metamodelUri;

	public WebModel(String name, String metamodelUri) {
		setName(name);
		this.metamodelUri = metamodelUri;
	}
	
	@Override
	protected void loadModel() throws EolModelLoadingException {
		try {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
			ResourceScraper scraper = new ScraperFactory(ePackage).create();
			this.modelImpl = EmfUtil.createResource(URI.createFileURI("foo.model"));
			this.modelImpl.getResourceSet().setPackageRegistry(EPackage.Registry.INSTANCE);

			this.modelImpl.getContents().addAll(scraper.scrape().values());
		
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}
}
