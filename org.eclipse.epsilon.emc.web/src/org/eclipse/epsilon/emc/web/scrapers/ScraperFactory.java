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
package org.eclipse.epsilon.emc.web.scrapers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.scrapers.elements.AttributeScraper;
import org.eclipse.epsilon.emc.web.scrapers.elements.IElementScraper;
import org.eclipse.epsilon.emc.web.scrapers.elements.NullElementScraper;

public class ScraperFactory {

	private final EPackage ePackage;
	private final WebDriver driver;
	
	public ScraperFactory(EPackage ePackage) {
		this.ePackage = ePackage;
		this.driver = new WebDriver(ePackage.getEAnnotation("web").getDetails().get("base"));
	}

	public ResourceScraper create() {
		List<ResourceScraper> scrapers = new LinkedList<ResourceScraper>();
		
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				scrapers.add(create((EClass)classifier));
			}
		}
		
		return scrapers.get(0);
	}

	private ResourceScraper create(EClass type) {
		EAnnotation pagesAnnotation = type.getEAnnotation("web.pages");
		String index = pagesAnnotation.getDetails().get("index");
		if (index == null) { index = "index.html"; }
		
		String elementsPattern = pagesAnnotation.getDetails().get("elements");
		
		
		return new PageScraper(type, driver, index, driver.xpath(elementsPattern), createElementScrapers(type));
	}

	private Collection<IElementScraper> createElementScrapers(EClass type) {
		final Collection<IElementScraper> elementScrapers = new LinkedList<IElementScraper>();
		for (EStructuralFeature feature : type.getEAllStructuralFeatures()) {
			elementScrapers.add(createElementScraper(feature));
		}
		return elementScrapers;
	}

	private IElementScraper createElementScraper(EStructuralFeature feature) {
		if (feature instanceof EAttribute && isAnnotatedWith(feature, "web.pattern")) {
			return new AttributeScraper((EAttribute)feature, driver);
		
		} else if (feature instanceof EAttribute && "name".equals(feature.getName())) {
			return new AttributeScraper((EAttribute)feature, driver);
		
		} else {
			return new NullElementScraper(feature, driver);
		}
	}

	
	private boolean isAnnotatedWith(EModelElement element, String source) {
		return element.getEAnnotation(source) != null;
	}
	
	private String getAnnotationDetail(EModelElement element, String source, String detail) {
		return element.getEAnnotation(source).getDetails().get(detail);
	}
}
