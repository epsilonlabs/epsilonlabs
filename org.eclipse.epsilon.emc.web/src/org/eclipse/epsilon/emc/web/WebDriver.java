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

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriver {

	private final String base;
	private final org.openqa.selenium.WebDriver driver = new HtmlUnitDriver();

	public WebDriver(String base) {
		this.base = base;
	}
	
	public By xpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}
	
	public SearchContext getSearchContext() {
		return driver;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void quit() {
		driver.quit();
	}

	public void visit(String address) {
		if (!address.startsWith(base)) { address = base + address; }
		driver.get(address);
	    authenticate();
	}

	private void authenticate() {
		try {
			WebElement username = driver.findElement(By.name("username"));
			username.sendKeys("lmr109");
			driver.findElement(By.name("password")).sendKeys("r2o6s8i4e");
			username.submit();
			
		} catch (NoSuchElementException e) {
			// Username field wasn't found
			// So no authentication necessary
		}
	}
}
