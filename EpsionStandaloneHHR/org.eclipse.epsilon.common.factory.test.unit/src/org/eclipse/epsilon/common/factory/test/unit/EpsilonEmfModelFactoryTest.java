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
package org.eclipse.epsilon.common.factory.test.unit;

import static org.junit.Assert.*;

import org.eclipse.epsilon.common.factory.EpsilonModelConfig;
import org.eclipse.epsilon.emc.emf.factory.EpsilonEmfModelConfig;
import org.eclipse.epsilon.emc.emf.factory.EpsilonEmfModelFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EpsilonEmfModelFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConfiguration() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		assertNotNull("Configuration should not be null", factory.getConfiguration());
	}

	@Test
	public void testEpsilonEmfModelFactory() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		assertNotNull("Factory can't be null", factory);
	}

	@Test
	public void testEpsilonEmfModelFactoryString() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory("myModel");
		assertNotNull("Factory can't be null", factory);
		EpsilonModelConfig config = factory.getConfiguration();
		assertEquals("Wrong initialization values in factory", "myModel", config.getModelName());
	}

	@Test
	public void testSetConfiguration() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		EpsilonModelConfig config = new EpsilonEmfModelConfig();
		factory.setConfiguration(config);
		assertEquals("Factory not setted correctly", config, factory.getConfiguration());
	}

	@Test
	public void testConfigSourceModelExpand() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigCachedSourceModelExpand() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigTargetModelExpand() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigCachedTargetModelExpand() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddMetamodelUri() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddMetamodelFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigSourceModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigCachedSourceModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigTargetModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigCachedTargetModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigBidirModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfigCachedBidirModel() {
		fail("Not yet implemented");
	}

}
