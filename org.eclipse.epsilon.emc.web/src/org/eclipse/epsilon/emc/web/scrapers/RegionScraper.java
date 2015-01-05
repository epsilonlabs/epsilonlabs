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

import java.util.Map;

import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.model.Resource;
import org.openqa.selenium.WebElement;

public class RegionScraper<R extends Resource> extends ResourceScraper<R> {
	
	public RegionScraper(Class<R> clazz, WebDriver driver) {
		super(clazz, driver);
	}

	protected String scrapeUrl(WebElement m) {
		return this.driver.getCurrentUrl() + "#" + scrapeDefaultName(m);
	}
	
	protected String scrapeDefaultName(WebElement m) {
		return m.getAttribute("name");
	}

	protected void scrapeDirectReferences(WebElement m, R resource, ReferenceScraper<?>... rs) throws IllegalAccessException {
		// FIXME: Extract reference / attribute scraping
		for (ReferenceScraper<?> r : rs) {
			r.scrapeDirect(resource, m);
		}
	}

	protected void scrapeIndirectReferences(Map<String, R> resources, ReferenceScraper<?>... rs) throws IllegalAccessException {
		// TODO
	}

}