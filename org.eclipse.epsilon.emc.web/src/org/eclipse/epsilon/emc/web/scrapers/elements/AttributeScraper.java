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
package org.eclipse.epsilon.emc.web.scrapers.elements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.extractors.DefaultExtractor;
import org.eclipse.epsilon.emc.web.extractors.IExtractor;
import org.openqa.selenium.WebElement;

public class AttributeScraper extends ElementScraper<EAttribute> {
	
	private final IExtractor extractor;
	
	public AttributeScraper(EAttribute feature, WebDriver driver, IExtractor extractor) {
		super(feature, driver);
		this.extractor = extractor;
	}
	
	public AttributeScraper(EAttribute feature, WebDriver driver) {
		this(feature, driver, new DefaultExtractor());
	}

	@Override
	public void scrape(EObject resource, WebElement element) {
		resource.eSet(feature, extractor.extract(element.getText()));
	}
}
