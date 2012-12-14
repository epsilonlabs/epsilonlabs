/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.factory.test.unit;

import static org.junit.Assert.*;

import org.eclipse.epsilon.common.factory.EpsilonModelConfig;
import org.eclipse.epsilon.emc.emf.factory.EmfEpsilonModelConfig;
import org.eclipse.epsilon.emc.emf.factory.EpsilonEmfModelFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmfEpsilonModelFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateModel() {
		// TODO Create different models with URI metamodels, file metamodels, etc
		// so we can test the different create model options
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
	public void testEpsilonEmfModelFactoryParameters() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory("myModel", "../model/empty.xmi");
		assertNotNull("Factory can't be null", factory);
		EpsilonModelConfig config = factory.getConfiguration();
		assertEquals("Wrong initialization values in factory", "myModel", config.getModelName());
	}

	@Test
	public void testSetConfiguration() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		EpsilonModelConfig config = new EmfEpsilonModelConfig();
		factory.setConfiguration(config);
		assertEquals("Factory not setted correctly", config, factory.getConfiguration());
	}
	
	@Test
	public void testConfigSourceModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForSourceModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertFalse("Wrong configuration", config.getStoreOnDisposal());
		assertFalse("Wrong configuration", config.getCached());
		assertFalse("Wrong configuration", config.getExpand());
		factory.configForCachedTargetModelExpand();
		factory.configForSourceModel();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for Source should override previous configuratrions", config.getCached());
		assertFalse("Configuration for Source should override previous configuratrions", config.getExpand());
	}
	
	@Test
	public void testConfigCachedSourceModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedSourceModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Modeled should been cached", config.getCached());
		assertFalse("Wrong configuration", config.getStoreOnDisposal());
		assertFalse("Wrong configuration", config.getExpand());
		factory.configForCachedTargetModelExpand();
		factory.configForCachedSourceModel();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for Source should override previous configuratrions", config.getExpand());
	}

	@Test
	public void testConfigForSourceModelExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForSourceModelExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Configuration expand property not set", config.getExpand());
		assertFalse("Wrong configuration", config.getStoreOnDisposal());
		assertFalse("Wrong configuration", config.getCached());
		factory.configForCachedTargetModelExpand();
		factory.configForSourceModelExpand();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for Source should override previous configuratrions", config.getCached());
	}
	
	
	@Test
	public void testConfigForCachedSourceModelExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedSourceModelExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Configuration cached property not set", config.getCached());
		assertTrue("Configuration expand property not set", config.getExpand());
		assertFalse("Wrong configuration", config.getStoreOnDisposal());
		factory.configForTargetModel();
		factory.configForCachedSourceModelExpand();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
	}
	
	@Test
	public void testConfigForTargetModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForTargetModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("Wrong configuration", config.getReadOnLoad());
		assertFalse("Wrong configuration", config.getCached());
		assertFalse("Wrong configuration", config.getExpand());
		factory.configForCachedSourceModelExpand();
		factory.configForTargetModel();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertFalse("Configuration for Target should override previous configuratrions", config.getCached());
		assertFalse("Configuration for Target should override previous configuratrions", config.getExpand());
	}

	@Test
	public void testConfigForCachedTargetModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedTargetModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Modeled should been cached", config.getCached());
		assertFalse("Wrong configuration", config.getReadOnLoad());
		assertFalse("Wrong configuration", config.getExpand());
		factory.configForCachedSourceModelExpand();
		factory.configForCachedTargetModel();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertFalse("Configuration for Target should override previous configuratrions", config.getExpand());
	}
	
	@Test
	public void testConfigForTargetModelExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForTargetModelExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Configuration expand property not set", config.getExpand());
		assertFalse("Wrong configuration", config.getReadOnLoad());
		assertFalse("Wrong configuration", config.getCached());
		factory.configForCachedSourceModelExpand();
		factory.configForTargetModelExpand();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertFalse("Configuration for Target should override previous configuratrions", config.getCached());
	}
	
	@Test
	public void testConfigForCachedTargetModelExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedTargetModelExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Configuration cached property not set", config.getCached());
		assertTrue("Configuration expand property not set", config.getExpand());
		assertFalse("Wrong configuration", config.getReadOnLoad());
		factory.configForSourceModel();
		factory.configForCachedTargetModelExpand();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
	}
	
	
	@Test
	public void testConfigForBidirectionalModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForBidirectionalModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Bi dir models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Bi dir models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("Wrong configuration", config.getCached());
		assertFalse("Wrong configuration", config.getExpand());
		factory.configForCachedTargetModelExpand();
		factory.configForBidirectionalModel();
		assertFalse("Configuration for bidir should override previous configuratrions", config.getCached());
		assertFalse("Configuration for bidir should override previous configuratrions", config.getExpand());
	}

	@Test
	public void testConfigForCachedBidirectionalModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedBidirectionalModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Bi dir models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Bi dir models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Modeled should been cached", config.getCached());
		assertFalse("Wrong configuration", config.getExpand());
		factory.configForCachedTargetModelExpand();
		factory.configForCachedBidirectionalModel();
		assertFalse("Configuration for bidir should override previous configuratrions", config.getExpand());
	}
	
	@Test
	public void testConfigForBidirectionalModelExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForBidirectionalModelExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Bi dir models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Bi dir models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Configuration expand property not set", config.getExpand());
		assertFalse("Wrong configuration", config.getCached());
		factory.configForCachedSourceModel();
		factory.configForBidirectionalModelExpand();
		assertFalse("Configuration for bidir should override previous configuratrions", config.getCached());
	}
	
	@Test
	public void testConfigForCachedBidirectionalModelExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedBidirectionalModelExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Bi dir models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Bi dir models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Configuration cached property not set", config.getCached());
		assertTrue("Configuration expand property not set", config.getExpand());
	}

	@Test
	public void testAddMetamodelUri() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.addMetamodelUri("mmURI1,");
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertEquals("Added metamodel URI does not match.", "mmURI1", config.getMetamodelUris());
		factory.addMetamodelUri("mmURI2");
		assertEquals("Added metamodel URI does not match.", "mmURI1,mmURI2", config.getMetamodelUris());
		factory.addMetamodelUri("mmURI3,mmURI4");
		assertEquals("Added metamodel URI does not match.", "mmURI1,mmURI2,mmURI3,mmURI4", config.getMetamodelUris());
	}

	@Test
	public void testAddMetamodelFile() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.addMetamodelFile("mmPath1");
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertEquals("Added metamodel Path does not match.", "mmPath1", config.getMetamodelPaths());
		factory.addMetamodelFile("mmPath2,");
		assertEquals("Added metamodel Path does not match.", "mmPath1,mmPath2", config.getMetamodelPaths());
		factory.addMetamodelFile("mmPath3,mmPath4");
		assertEquals("Added metamodel Path does not match.", "mmPath1,mmPath2,mmPath3,mmPath4", config.getMetamodelPaths());
	}
	
	@Test
	public void testClearMetamodelUris() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.addMetamodelUri("mmURI1");
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertEquals("Added metamodel URI does not match.", "mmURI1", config.getMetamodelUris());
		factory.clearMetamodelUris();
		config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertEquals("Metamodles are not cleared.", "", config.getMetamodelUris());
	}
	
	@Test
	public void testClearMetamodelPaths() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.addMetamodelFile("mmPath1");
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertEquals("Added metamodel Path does not match.", "mmPath1", config.getMetamodelPaths());
		factory.clearMetamodelPaths();
		config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertEquals("Metamodles are not cleared.", "", config.getMetamodelPaths());
	}
}
