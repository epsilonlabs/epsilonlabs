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
package org.eclipse.epsilon.emc.web.test.acceptance;

import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.junit.Test;

public class ExtractName extends WebModelAcceptanceTest {

	@Test
	public void hasCorrectNumberOfElements() throws EolModelElementTypeNotFoundException {
		model.assertEquals(4, "Module.all.size()");
	}
	
	@Test
	public void elementsHaveCorrectNames() throws EolModelElementTypeNotFoundException {
		model.setVariable("names", "Module.all.name");
		
		model.assertTrue("names.includes('ADVT')");
		model.assertTrue("names.includes('FESC')");
		model.assertTrue("names.includes('SWIN')");
		model.assertTrue("names.includes('TPOP')");
	}
	
}
