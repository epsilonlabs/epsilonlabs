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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.scrapers.elements.IElementScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class ResourceScraper {

	private final EClass type;
	protected final WebDriver driver;
	private final String page;
	private final By pattern;
	private Collection<IElementScraper> elementScrapers;
	
	public ResourceScraper(EClass type, WebDriver driver, String page, By pattern, Collection<IElementScraper> elementScrapers) {
		this.type = type;
		this.driver = driver;
		this.page = page;
		this.pattern = pattern;
		this.elementScrapers = elementScrapers;
	}
	
	protected EObject createResource(String url, String name) {
		try {
			EObject resource = type.getEPackage().getEFactoryInstance().create(type);
//			resource.url = url; // FIXME
			return resource;

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	public Map<String, EObject> scrape(ReferenceScraper<?>... rs) throws Exception {
        this.driver.visit(page);

        List<WebElement> elements = this.driver.getSearchContext().findElements(pattern);
        Map<String, EObject> resources = new HashMap<String, EObject>();
        
        // FIXME : throw if m is not an A tag with a NAME
        for (WebElement m : elements) {
        	String url = scrapeUrl(m);
        	EObject resource = createResource(url, scrapeDefaultName(m));
			resources.put(url, resource);
			
			for (IElementScraper scraper : elementScrapers) {
				scraper.scrape(resource, m);
			}
			
			scrapeDirectReferences(m, resource, rs);
        }
        
        scrapeIndirectReferences(resources, rs);
        
        return resources;
	}

	protected abstract String scrapeUrl(WebElement m);
	protected abstract String scrapeDefaultName(WebElement m);
	protected abstract void scrapeDirectReferences(WebElement m, EObject resource, ReferenceScraper<?>... rs) throws IllegalAccessException;
	protected abstract void scrapeIndirectReferences(Map<String, EObject> resources, ReferenceScraper<?>... rs) throws IllegalAccessException;

}