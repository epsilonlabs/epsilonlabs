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

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.emc.web.WebDriver;
import org.eclipse.epsilon.emc.web.model.Resource;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ReferenceScraper<T extends Resource> {

	public Map<String, T> targets;
	public By pattern;
	public Field field;
	
	public void scrapeIndirect(Resource resource, WebDriver driver) throws IllegalAccessException {
		driver.visit(resource.url);
		scrape(resource, driver.getSearchContext());
	}
	
	public void scrapeDirect(Resource resource, WebElement m) throws IllegalAccessException {
		scrape(resource, m);
	}

	private void scrape(Resource resource, SearchContext root) throws IllegalAccessException {
		// FIXME : throw if e is not an A tag with an HREF
		for (WebElement e : root.findElements(this.pattern)) {
			List slot = (List)this.field.get(resource);
			slot.add(this.targets.get(e.getAttribute("href")));
		}
	}
}