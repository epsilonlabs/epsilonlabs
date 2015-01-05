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

import org.eclipse.emf.ecore.EObject;
import org.openqa.selenium.WebElement;

public interface IElementScraper {

	public abstract void scrape(EObject resource, WebElement element);

}