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

import org.eclipse.epsilon.emc.emf.factory.EmfEpsilonModelConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmfEpsilonModelConfigTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEpsilonEmfModelConfig() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		String driver = EmfEpsilonModelConfig.DRIVER;
		assertEquals("Dirver is not emf", "emf", tester.getParameter(driver));
	}
	
	@Test
	public void testGetParameter() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
		assertEquals("Paramter setted and retreived values are different.", String.valueOf(true), tester.getParameter(EmfEpsilonModelConfig.EXPAND));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.EXPAND);
		
	}

	@Test
	public void testSetParameter() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
		assertEquals("Paramter setted and retreived values are different.", String.valueOf(true), tester.getParameter(EmfEpsilonModelConfig.EXPAND));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.EXPAND);
	}

	@Test
	public void testSetMetamodelUris() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setMetamodelUris(null);
		assertNull("Value should be null", tester.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		tester.setMetamodelUris("URIA");
		assertEquals("Found unexpected metamodel list", "URIA", tester.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		tester.setMetamodelUris("URIB,URIC");
		assertEquals("Found unexpected metamodel list", "URIB,URIC", tester.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.URI_METAMODELS);
	}

	@Test
	public void testGetMetamodelUris() {
		
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.URI_METAMODELS, null);
		assertNull("Value should be null", tester.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		tester.setParameter(EmfEpsilonModelConfig.URI_METAMODELS, "URIA");
		String mmURIs = tester.getMetamodelUris();
		assertEquals("Found unexpected metamodel list", "URIA", mmURIs);
		tester.setParameter(EmfEpsilonModelConfig.URI_METAMODELS, "URIB,URIC");
		mmURIs = tester.getMetamodelUris();
		assertEquals("Found unexpected metamodel list", "URIB,URIC", mmURIs);
	}

	@Test
	public void testSetMetamodelPaths() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setMetamodelPaths(null);
		assertNull("Value should be null", tester.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS));
		tester.setMetamodelPaths("file://URIA");
		assertEquals("Found unexpected metamodel list", "file://URIA", tester.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS));
		tester.setMetamodelPaths("file://URIB,file://URIC");
		assertEquals("Found unexpected metamodel list", "file://URIB,file://URIC", tester.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.FILE_METAMODELS);
	}

	@Test
	public void testGetMetamodelPaths() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.FILE_METAMODELS, null);
		assertNull("Value should be null", tester.getMetamodelPaths());
		tester.setParameter(EmfEpsilonModelConfig.FILE_METAMODELS, "file://URIA");
		assertEquals("Found unexpected metamodel list", "file://URIA", tester.getMetamodelPaths());
		tester.setParameter(EmfEpsilonModelConfig.FILE_METAMODELS, "file://URIB,file://URIC");
		assertEquals("Found unexpected metamodel list", "file://URIB,file://URIC", tester.getMetamodelPaths());
	}

	@Test
	public void testSetExpand() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setExpand(false);
		assertEquals("Found unexpected expand value", String.valueOf(false), tester.getParameter(EmfEpsilonModelConfig.EXPAND));
		tester.setExpand(true);
		assertEquals("Found unexpected expand value", String.valueOf(true), tester.getParameter(EmfEpsilonModelConfig.EXPAND));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.EXPAND);
	}

	@Test
	public void testGetExpand() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
		assertEquals("Found unexpected expand value", false, tester.getExpand());
		tester.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
		assertEquals("Found unexpected expand value", true, tester.getExpand());
	}

	@Test
	public void testGetDriverName() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		assertEquals("Dirver is not emf", "emf", tester.getDriverName());
	}

	@Test
	public void testSetModelName() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setModelName(null);
		assertNull("Value should be null", tester.getModelName());
		tester.setModelName("MyModel");
		assertEquals("Found unexpected expand value", "MyModel", tester.getParameter(EmfEpsilonModelConfig.NAME));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.NAME);
	}

	@Test
	public void testGetModelName() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.NAME, "MyModel");
		assertEquals("Found unexpected expand value", "MyModel", tester.getModelName());
	}

	@Test
	public void testSetModelURI() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setModelURI(null);
		assertNull("Value should be null", tester.getModelURI());
		tester.setModelURI("platform://plugin/myplugin/model/MyModel.xmi");
		assertEquals("Found unexpected expand value", "platform://plugin/myplugin/model/MyModel.xmi", tester.getParameter(EmfEpsilonModelConfig.MODEL_URI));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.MODEL_URI);
	}

	@Test
	public void testGetModelURI() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.MODEL_URI, "platform://plugin/myplugin/model/MyModel.xmi");
		assertEquals("Found unexpected expand value", "platform://plugin/myplugin/model/MyModel.xmi", tester.getModelURI());
	}

	@Test
	public void testSetReadOnLoad() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setReadOnLoad(true);
		assertEquals("Found unexpected expand value", true, Boolean.valueOf(tester.getParameter(EmfEpsilonModelConfig.READ_ON_LOAD)));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.READ_ON_LOAD);
		tester.setReadOnLoad(false);
		assertEquals("Found unexpected expand value", false, Boolean.valueOf(tester.getParameter(EmfEpsilonModelConfig.READ_ON_LOAD)));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.READ_ON_LOAD);
	}

	@Test
	public void testGetReadOnLoad() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.READ_ON_LOAD, "true");
		assertEquals("Found unexpected expand value", true, tester.getReadOnLoad());
		tester.setParameter(EmfEpsilonModelConfig.READ_ON_LOAD, "false");
		assertEquals("Found unexpected expand value", false, tester.getReadOnLoad());
	}

	@Test
	public void testSetStoreOnDisposal() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setStoreOnDisposal(true);
		assertEquals("Found unexpected expand value", true, Boolean.valueOf(tester.getParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL)));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.STORE_ON_DISPOSAL);
		tester.setStoreOnDisposal(false);
		assertEquals("Found unexpected expand value", false, Boolean.valueOf(tester.getParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL)));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.STORE_ON_DISPOSAL);
	}

	@Test
	public void testGetStoreOnDisposal() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL, "true");
		assertEquals("Found unexpected expand value", true, tester.getStoreOnDisposal());
		tester.setParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL, "false");
		assertEquals("Found unexpected expand value", false, tester.getStoreOnDisposal());
	}

	@Test
	public void testSetCached() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setCached(true);
		assertEquals("Found unexpected expand value", true, Boolean.valueOf(tester.getParameter(EmfEpsilonModelConfig.CACHED)));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.CACHED);
		tester.setCached(false);
		assertEquals("Found unexpected expand value", false, Boolean.valueOf(tester.getParameter(EmfEpsilonModelConfig.CACHED)));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.CACHED);
	}

	@Test
	public void testGetCached() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.CACHED, "true");
		assertEquals("Found unexpected expand value", true, tester.getCached());
		tester.setParameter(EmfEpsilonModelConfig.CACHED, "false");
		assertEquals("Found unexpected expand value", false, tester.getCached());
	}
	
	@Test
	public void testSetAliases() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setAliases(null);
		assertNull("Value should be null", tester.getParameter(EmfEpsilonModelConfig.ALIASES));
		tester.setAliases("AliasA");
		assertEquals("Found unexpected aliases list", "AliasA", tester.getParameter(EmfEpsilonModelConfig.ALIASES));
		tester.setAliases("AliasB,AliasC");
		assertEquals("Found unexpected aliases list", "AliasB,AliasC", tester.getParameter(EmfEpsilonModelConfig.ALIASES));
		assertAllParametersAreNullExcept(tester, EmfEpsilonModelConfig.ALIASES);
		
	}
	
	@Test
	public void testGetAliases() {
		EmfEpsilonModelConfig tester = new EmfEpsilonModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EmfEpsilonModelConfig.ALIASES, null);
		assertNull("Value should be null", tester.getMetamodelPaths());
		tester.setParameter(EmfEpsilonModelConfig.ALIASES, "AliasA");
		assertEquals("Found unexpected metamodel list", "AliasA", tester.getAliases());
		tester.setParameter(EmfEpsilonModelConfig.ALIASES, "AliasB,AliasC");
		assertEquals("Found unexpected metamodel list", "AliasB,AliasC", tester.getAliases());
	}
	
	
	
	//========= HELPER ASSERTIONS
	private void assertAllParametersAreNull(EmfEpsilonModelConfig tester) {
		
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.EXPAND));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.BASE_PATH));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.ALIASES));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.CACHED));
		//assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.DRIVER));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.FILE));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.MODEL_URI));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.NAME));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.READ_ON_LOAD));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.SOURCE_FILE));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.XML_URI));
	}
	
	private void assertAllParametersAreNullExcept(EmfEpsilonModelConfig tester, String exception) {
		
		if(!exception.equals(EmfEpsilonModelConfig.EXPAND)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.EXPAND));
		}		
		if(!exception.equals(EmfEpsilonModelConfig.FILE_METAMODELS)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS));
		}
		if(!exception.equals(EmfEpsilonModelConfig.URI_METAMODELS)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		}
		if(!exception.equals(EmfEpsilonModelConfig.BASE_PATH)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.BASE_PATH));
		}
		if(!exception.equals(EmfEpsilonModelConfig.ALIASES)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.ALIASES));
		}
		if(!exception.equals(EmfEpsilonModelConfig.CACHED)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.CACHED));
		}
		//assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.DRIVER));
		if(!exception.equals(EmfEpsilonModelConfig.FILE)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.FILE));
		}
		if(!exception.equals(EmfEpsilonModelConfig.MODEL_URI)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.MODEL_URI));
		}
		if(!exception.equals(EmfEpsilonModelConfig.NAME)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.NAME));
		}
		if(!exception.equals(EmfEpsilonModelConfig.READ_ON_LOAD)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.READ_ON_LOAD));
		}
		if(!exception.equals(EmfEpsilonModelConfig.SOURCE_FILE)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.SOURCE_FILE));
		}
		if(!exception.equals(EmfEpsilonModelConfig.STORE_ON_DISPOSAL)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL));
		}
		if(!exception.equals(EmfEpsilonModelConfig.XML_URI)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EmfEpsilonModelConfig.XML_URI));
		}
	}

}
