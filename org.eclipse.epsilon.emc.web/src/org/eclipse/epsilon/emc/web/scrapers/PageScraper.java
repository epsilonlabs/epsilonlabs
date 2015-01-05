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
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.scrapers.elements.IElementScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageScraper extends ResourceScraper {
	
	public PageScraper(EClass type, WebDriver driver, String page, By pattern, Collection<IElementScraper> elementScrapers) {
		super(type, driver, page, pattern, elementScrapers);
	}

	protected String scrapeUrl(WebElement m) {
		String url = m.getAttribute("href");
		
		// FIXME : make generic by allowing @web.pages to specify URL rewriting?
    	if (url.contains("people")) {
    		String[] qsValues = url.split("=");
    		String username = qsValues[qsValues.length-1];
    		url = "http://www.cs.york.ac.uk/people/" + username;
    	}
    	
    	return url;
	}
	
	protected String scrapeDefaultName(WebElement m) {
		return m.getText();
	}
	
	protected void scrapeDirectReferences(WebElement m, EObject resource, ReferenceScraper<?>... rs) throws IllegalAccessException {
		// TODO
	}
	
	protected void scrapeIndirectReferences(Map<String, EObject> resources, ReferenceScraper<?>... rs) throws IllegalAccessException {
//		for (Resource resource : resources.values()) { // FIXME
//			for (ReferenceScraper<?> r : rs) {
//				r.scrapeIndirect(resource, this.driver);
//			}
//		}
	}
}