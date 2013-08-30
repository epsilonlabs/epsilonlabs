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
package org.eclipse.epsilon.emc.emf.factory.test.unit;

import static org.junit.Assert.*;

import org.eclipse.epsilon.common.factory.EpsilonModelConfig;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.factory.EmfEpsilonModelConfig;
import org.eclipse.epsilon.emc.emf.factory.EpsilonEmfModelFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
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
	public void testCreateSourceModel() {
		// TODO Create different models with URI metamodels, file metamodels, etc
		// so we can test the different create model options
		
		// File metamodel
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory("SimpleGraph", "src/org/eclipse/epsilon/emc/emf/factory/test/unit/model/SimpleGraphF.xmi");
		assertNotNull("Factory can't be null", factory);
		factory.addMetamodelFile("src/org/eclipse/epsilon/emc/emf/factory/test/unit/model/SimpleGraph.ecore");
		factory.configForSourceModel();
		IModel emfModel = null;
		try {
			emfModel = factory.createModel();
		} catch (EolModelLoadingException e) {
			fail("Model failed to load:" + e.getMessage());
		}
		assertNotNull("emf model should not be null", emfModel);
		assertEquals("Model name not correctly asigned", "SimpleGraph", emfModel.getName());
		assertTrue("Source models should be 'read on load'", emfModel.isReadOnLoad());
		emfModel.dispose();
		
		// URI metamodel
		factory.clearMetamodelPaths();
		factory.setModelURI("src/org/eclipse/epsilon/emc/emf/factory/test/unit/model/SimpleGraph.xmi");
		factory.addMetamodelUri("http://www.eclipse.org/qvt/examples/0.1/SimpleGraph");
		factory.configForSourceModel();
		emfModel = null;
		try {
			emfModel = factory.createModel();
		} catch (EolModelLoadingException e) {
			fail("Model failed to load:" + e.getMessage());
		}
		assertNotNull("emf model should not be null", emfModel);
		assertEquals("Model name not correctly asigned", "SimpleGraph", emfModel.getName());
		assertTrue("Source models should be 'read on load'", emfModel.isReadOnLoad());
		emfModel.dispose();
	}

	@Test
	public void testGetConfiguration() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		assertNotNull("Configuration should not be null", factory.getConfiguration());
	}

	/*@Test
	public void testEpsilonEmfModelFactory() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		assertNotNull("Factory can't be null", factory);
	}*/

	@Test
	public void testEpsilonEmfModelFactoryParameters() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory("myModel", "model/empty.xmi");
		assertNotNull("Factory can't be null", factory);
		EpsilonModelConfig config = factory.getConfiguration();
		assertEquals("Wrong model name", "myModel", config.getModelName());
		assertEquals("Wrong model URI", "model/empty.xmi", config.getModelURI());
	}

	@Test
	public void testSetConfiguration() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		assertNotNull("Factory can't be null", factory);
		EpsilonModelConfig config = new EmfEpsilonModelConfig();
		assertNotNull("Configuration can't be null", config);
		factory.setConfiguration(config);
		assertEquals("Factory configuration not setted correctly", config, factory.getConfiguration());
	}
	
	@Test
	public void testConfigSourceModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForSourceModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertFalse("Source models should not be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("By default models should not be cached", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForCachedTargetModel();
		factory.configForSourceModel();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for Source should override previous configuratrions", config.getCached());
		assertTrue("Configuration for Source should override previous configuratrions", config.getExpand());
	}
	
	@Test
	public void testConfigCachedSourceModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedSourceModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertFalse("Source models should not be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Model should be cached", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForCachedTargetModel();
		factory.configForCachedSourceModel();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertTrue("Configuration for Source should override previous configuratrions", config.getExpand());
	}

	@Test
	public void testConfigForSourceModelNoExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForSourceModelNoExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertFalse("Source models should not be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("By default models should not be cached", config.getCached());
		assertFalse("Expand should be set to false", config.getExpand());
		factory.configForCachedTargetModel();
		factory.configForSourceModelNoExpand();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for Source should override previous configuratrions", config.getExpand());
	}
	
	
	@Test
	public void testConfigForCachedSourceModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedSourceModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Source models should be 'read on load'", config.getReadOnLoad());
		assertFalse("Source models should not be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Cached property not set", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForTargetModel();
		factory.configForCachedSourceModel();
		assertFalse("Configuration for Source should override previous configuratrions", config.getStoreOnDisposal());
		assertTrue("Configuration for Source should override previous configuratrions", config.getCached());
		
	}
	
	@Test
	public void testConfigForTargetModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForTargetModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("Target models should not be 'read on load'", config.getReadOnLoad());
		assertFalse("By default models should not be cached", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForCachedSourceModelNoExpand();
		factory.configForTargetModel();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertFalse("Configuration for Target should override previous configuratrions", config.getCached());
		assertTrue("Configuration for Target should override previous configuratrions", config.getExpand());
	}
	
	@Test
	public void testConfigForCachedTargetModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedTargetModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("Target models should not be 'read on load'", config.getReadOnLoad());
		assertTrue("Modeled should been cached", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForCachedSourceModelNoExpand();
		factory.configForCachedTargetModel();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertTrue("Configuration for Target should override previous configuratrions", config.getExpand());
	}
	
	
	@Test
	public void testConfigForTargetModelNoExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForTargetModelNoExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertFalse("Target models should not be 'read on load'", config.getReadOnLoad());
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("By default models should not be cached", config.getCached());
		assertFalse("Expand should be set to false", config.getExpand());
		factory.configForCachedSourceModel();
		factory.configForTargetModelNoExpand();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertFalse("Configuration for Target should override previous configuratrions", config.getCached());
	}
	
	
	@Test
	public void testConfigForCachedTargetModelNoExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedTargetModelNoExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertFalse("Target models should not be 'read on load'", config.getReadOnLoad());
		assertTrue("Target models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Cached property not set", config.getCached());
		assertFalse("Expand should be set to false", config.getExpand());
		factory.configForSourceModel();
		factory.configForCachedTargetModelNoExpand();
		assertFalse("Configuration for Target should override previous configuratrions", config.getReadOnLoad());
		assertTrue("Configuration for Target should override previous configuratrions", config.getCached());
	}
	
	
	@Test
	public void testConfigForUpdateModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForUpdateModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Update models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Update models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("By default models should not be cached", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForCachedTargetModelNoExpand();
		factory.configForUpdateModel();
		assertTrue("Configuration for update should override previous configuratrions", config.getReadOnLoad());
		assertTrue("Configuration for update should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for update should override previous configuratrions", config.getCached());
		assertTrue("Configuration for update should override previous configuratrions", config.getExpand());
	}
	
	@Test
	public void testConfigForCachedUpdateModel() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedUpdateModel();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Update models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Update models should be 'store on disposal'", config.getStoreOnDisposal());
		assertTrue("Cached property not set", config.getCached());
		assertTrue("By default models should be expanded", config.getExpand());
		factory.configForCachedTargetModelNoExpand();
		factory.configForCachedUpdateModel();
		assertTrue("Configuration for update should override previous configuratrions", config.getReadOnLoad());
		assertTrue("Configuration for update should override previous configuratrions", config.getStoreOnDisposal());
		assertTrue("Configuration for update should override previous configuratrions", config.getCached());
		assertTrue("Configuration for update should override previous configuratrions", config.getExpand());
	}
	
	
	@Test
	public void testConfigForUpdateModelNoExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForUpdateModelNoExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Update models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Update models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("Expand should be set to false", config.getExpand());
		assertFalse("By default models should not be cached", config.getCached());
		factory.configForCachedSourceModel();
		factory.configForUpdateModelNoExpand();
		assertTrue("Configuration for update should override previous configuratrions", config.getReadOnLoad());
		assertTrue("Configuration for update should override previous configuratrions", config.getStoreOnDisposal());
		assertFalse("Configuration for update should override previous configuratrions", config.getCached());
		assertFalse("Configuration for update should override previous configuratrions", config.getExpand());
	}
	

	@Test
	public void testConfigForCachedUpdateModelNoExpand() {
		EpsilonEmfModelFactory factory = new EpsilonEmfModelFactory();
		factory.configForCachedUpdateModelNoExpand();
		EmfEpsilonModelConfig config = (EmfEpsilonModelConfig) factory.getConfiguration();
		assertTrue("Update models should be 'read on load'", config.getReadOnLoad());
		assertTrue("Update models should be 'store on disposal'", config.getStoreOnDisposal());
		assertFalse("Expand should be set to false", config.getExpand());
		assertTrue("Cached property not set", config.getCached());
		factory.configForCachedSourceModel();
		factory.configForCachedUpdateModelNoExpand();
		assertTrue("Configuration for update should override previous configuratrions", config.getReadOnLoad());
		assertTrue("Configuration for update should override previous configuratrions", config.getStoreOnDisposal());
		assertTrue("Configuration for update should override previous configuratrions", config.getCached());
		assertFalse("Configuration for update should override previous configuratrions", config.getExpand());
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
