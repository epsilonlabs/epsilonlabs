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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.web.WebDriver;
import org.openqa.selenium.WebElement;

public class AttributeScraper extends ElementScraper<EAttribute> {
	
	public AttributeScraper(EAttribute feature, WebDriver driver) {
		super(feature, driver);
	}
	
	@Override
	public void scrape(EObject resource, WebElement element) {
		resource.eSet(feature, translate(element.getText()));
	}

	private String translate(String value) {
		if (isAnnotatedWith("web.pattern")) { // FIXME pull inspecting annotations into factory class?
			String regex = getAnnotationDetail("web.pattern", "regex");
			Matcher matcher = Pattern.compile(regex).matcher(value);
			
			if (matcher.find()) {
				return matcher.group(1);
			}
		}
		
		return value;
	}
	
	private boolean isAnnotatedWith(String source) {
		return feature.getEAnnotation(source) != null;
	}
	
	private String getAnnotationDetail(String source, String detail) {
		return feature.getEAnnotation(source).getDetails().get(detail);
	}
}
