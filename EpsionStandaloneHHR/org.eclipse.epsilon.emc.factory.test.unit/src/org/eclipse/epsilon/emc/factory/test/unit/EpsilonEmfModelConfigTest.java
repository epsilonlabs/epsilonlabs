/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     hhoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.factory.test.unit;

import static org.junit.Assert.*;

import org.eclipse.epsilon.emc.emf.factory.EpsilonEmfModelConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EpsilonEmfModelConfigTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEpsilonEmfModelConfig() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertEquals("Dirver is not emf", "emf", tester.getParameter(EpsilonEmfModelConfig.DRIVER));
	}

	@Test
	public void testSetMetamodelUris() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		tester.setMetamodelUris(null);
		assertNull(tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		tester.setMetamodelUris("URIA");
		assertEquals("Found unexpected metamodel list", "URIA", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		tester.setMetamodelUris("URIB,URIC");
		assertEquals("Found unexpected metamodel list", "URIB,URIC", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
	}

	@Test
	public void testGetMetamodelUris() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testSetMetamodelPaths() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMetamodelPaths() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpand() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExpand() {
		fail("Not yet implemented");
	}

	@Test
	public void testEpsilonAbstractModelConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParameter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetParameter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDriverName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetModelName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetModelName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetModelURI() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetModelURI() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetReadOnLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReadOnLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStoreOnDisposal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStoreOnDisposal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCached() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCached() {
		fail("Not yet implemented");
	}

}
