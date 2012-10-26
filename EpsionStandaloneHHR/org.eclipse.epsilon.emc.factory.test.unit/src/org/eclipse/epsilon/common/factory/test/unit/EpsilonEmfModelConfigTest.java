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
		String driver = EpsilonEmfModelConfig.DRIVER;
		assertEquals("Dirver is not emf", "emf", tester.getParameter(driver));
	}
	
	@Test
	public void testGetParameter() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
		assertEquals("Paramter setted and retreived values are different.", String.valueOf(true), tester.getParameter(EpsilonEmfModelConfig.EXPAND));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.EXPAND);
		
	}

	@Test
	public void testSetParameter() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
		assertEquals("Paramter setted and retreived values are different.", String.valueOf(true), tester.getParameter(EpsilonEmfModelConfig.EXPAND));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.EXPAND);
	}

	@Test
	public void testSetMetamodelUris() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setMetamodelUris(null);
		assertNull("Value should be null", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		tester.setMetamodelUris("URIA");
		assertEquals("Found unexpected metamodel list", "URIA", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		tester.setMetamodelUris("URIB,URIC");
		assertEquals("Found unexpected metamodel list", "URIB,URIC", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.URI_METAMODELS);
	}

	@Test
	public void testGetMetamodelUris() {
		
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.URI_METAMODELS, null);
		assertNull("Value should be null", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		tester.setParameter(EpsilonEmfModelConfig.URI_METAMODELS, "URIA");
		String mmURIs = tester.getMetamodelUris();
		assertEquals("Found unexpected metamodel list", "URIA", mmURIs);
		tester.setParameter(EpsilonEmfModelConfig.URI_METAMODELS, "URIB,URIC");
		mmURIs = tester.getMetamodelUris();
		assertEquals("Found unexpected metamodel list", "URIB,URIC", mmURIs);
	}

	@Test
	public void testSetMetamodelPaths() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setMetamodelPaths(null);
		assertNull("Value should be null", tester.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		tester.setMetamodelPaths("file://URIA");
		assertEquals("Found unexpected metamodel list", "file://URIA", tester.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		tester.setMetamodelPaths("file://URIB,file://URIC");
		assertEquals("Found unexpected metamodel list", "file://URIB,file://URIC", tester.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.FILE_METAMODELS);
	}

	@Test
	public void testGetMetamodelPaths() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.FILE_METAMODELS, null);
		assertNull("Value should be null", tester.getMetamodelPaths());
		tester.setParameter(EpsilonEmfModelConfig.FILE_METAMODELS, "file://URIA");
		assertEquals("Found unexpected metamodel list", "file://URIA", tester.getMetamodelPaths());
		tester.setParameter(EpsilonEmfModelConfig.FILE_METAMODELS, "file://URIB,file://URIC");
		assertEquals("Found unexpected metamodel list", "file://URIB,file://URIC", tester.getMetamodelPaths());
	}

	@Test
	public void testSetExpand() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setExpand(false);
		assertEquals("Found unexpected expand value", String.valueOf(false), tester.getParameter(EpsilonEmfModelConfig.EXPAND));
		tester.setExpand(true);
		assertEquals("Found unexpected expand value", String.valueOf(true), tester.getParameter(EpsilonEmfModelConfig.EXPAND));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.EXPAND);
	}

	@Test
	public void testGetExpand() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(false));
		assertEquals("Found unexpected expand value", false, tester.getExpand());
		tester.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
		assertEquals("Found unexpected expand value", true, tester.getExpand());
	}

	@Test
	public void testGetDriverName() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		assertEquals("Dirver is not emf", "emf", tester.getDriverName());
	}

	@Test
	public void testSetModelName() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setModelName(null);
		assertNull("Value should be null", tester.getModelName());
		tester.setModelName("MyModel");
		assertEquals("Found unexpected expand value", "MyModel", tester.getParameter(EpsilonEmfModelConfig.NAME));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.NAME);
	}

	@Test
	public void testGetModelName() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.NAME, "MyModel");
		assertEquals("Found unexpected expand value", "MyModel", tester.getModelName());
	}

	@Test
	public void testSetModelURI() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setModelURI(null);
		assertNull("Value should be null", tester.getModelURI());
		tester.setModelURI("platform://plugin/myplugin/model/MyModel.xmi");
		assertEquals("Found unexpected expand value", "platform://plugin/myplugin/model/MyModel.xmi", tester.getParameter(EpsilonEmfModelConfig.MODEL_URI));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.MODEL_URI);
	}

	@Test
	public void testGetModelURI() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.MODEL_URI, "platform://plugin/myplugin/model/MyModel.xmi");
		assertEquals("Found unexpected expand value", "platform://plugin/myplugin/model/MyModel.xmi", tester.getModelURI());
	}

	@Test
	public void testSetReadOnLoad() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setReadOnLoad(true);
		assertEquals("Found unexpected expand value", true, Boolean.valueOf(tester.getParameter(EpsilonEmfModelConfig.READ_ON_LOAD)));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.READ_ON_LOAD);
		tester.setReadOnLoad(false);
		assertEquals("Found unexpected expand value", false, Boolean.valueOf(tester.getParameter(EpsilonEmfModelConfig.READ_ON_LOAD)));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.READ_ON_LOAD);
	}

	@Test
	public void testGetReadOnLoad() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.READ_ON_LOAD, "true");
		assertEquals("Found unexpected expand value", true, tester.getReadOnLoad());
		tester.setParameter(EpsilonEmfModelConfig.READ_ON_LOAD, "false");
		assertEquals("Found unexpected expand value", false, tester.getReadOnLoad());
	}

	@Test
	public void testSetStoreOnDisposal() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setStoreOnDisposal(true);
		assertEquals("Found unexpected expand value", true, Boolean.valueOf(tester.getParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL)));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.STORE_ON_DISPOSAL);
		tester.setStoreOnDisposal(false);
		assertEquals("Found unexpected expand value", false, Boolean.valueOf(tester.getParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL)));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.STORE_ON_DISPOSAL);
	}

	@Test
	public void testGetStoreOnDisposal() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL, "true");
		assertEquals("Found unexpected expand value", true, tester.getStoreOnDisposal());
		tester.setParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL, "false");
		assertEquals("Found unexpected expand value", false, tester.getStoreOnDisposal());
	}

	@Test
	public void testSetCached() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setCached(true);
		assertEquals("Found unexpected expand value", true, Boolean.valueOf(tester.getParameter(EpsilonEmfModelConfig.CACHED)));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.CACHED);
		tester.setCached(false);
		assertEquals("Found unexpected expand value", false, Boolean.valueOf(tester.getParameter(EpsilonEmfModelConfig.CACHED)));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.CACHED);
	}

	@Test
	public void testGetCached() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.CACHED, "true");
		assertEquals("Found unexpected expand value", true, tester.getCached());
		tester.setParameter(EpsilonEmfModelConfig.CACHED, "false");
		assertEquals("Found unexpected expand value", false, tester.getCached());
	}
	
	@Test
	public void testSetAliases() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setAliases(null);
		assertNull("Value should be null", tester.getParameter(EpsilonEmfModelConfig.ALIASES));
		tester.setAliases("AliasA");
		assertEquals("Found unexpected aliases list", "AliasA", tester.getParameter(EpsilonEmfModelConfig.ALIASES));
		tester.setAliases("AliasB,AliasC");
		assertEquals("Found unexpected aliases list", "AliasB,AliasC", tester.getParameter(EpsilonEmfModelConfig.ALIASES));
		assertAllParametersAreNullExcept(tester, EpsilonEmfModelConfig.ALIASES);
		
	}
	
	@Test
	public void testGetAliases() {
		EpsilonEmfModelConfig tester = new EpsilonEmfModelConfig();
		assertAllParametersAreNull(tester);
		tester.setParameter(EpsilonEmfModelConfig.ALIASES, null);
		assertNull("Value should be null", tester.getMetamodelPaths());
		tester.setParameter(EpsilonEmfModelConfig.ALIASES, "AliasA");
		assertEquals("Found unexpected metamodel list", "AliasA", tester.getAliases());
		tester.setParameter(EpsilonEmfModelConfig.ALIASES, "AliasB,AliasC");
		assertEquals("Found unexpected metamodel list", "AliasB,AliasC", tester.getAliases());
	}
	
	
	
	//========= HELPER ASSERTIONS
	private void assertAllParametersAreNull(EpsilonEmfModelConfig tester) {
		
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.EXPAND));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.BASE_PATH));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.ALIASES));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.CACHED));
		//assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.DRIVER));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.FILE));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.MODEL_URI));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.NAME));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.READ_ON_LOAD));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.SOURCE_FILE));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL));
		assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.XML_URI));
	}
	
	private void assertAllParametersAreNullExcept(EpsilonEmfModelConfig tester, String exception) {
		
		if(!exception.equals(EpsilonEmfModelConfig.EXPAND)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.EXPAND));
		}		
		if(!exception.equals(EpsilonEmfModelConfig.FILE_METAMODELS)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		}
		if(!exception.equals(EpsilonEmfModelConfig.URI_METAMODELS)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		}
		if(!exception.equals(EpsilonEmfModelConfig.BASE_PATH)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.BASE_PATH));
		}
		if(!exception.equals(EpsilonEmfModelConfig.ALIASES)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.ALIASES));
		}
		if(!exception.equals(EpsilonEmfModelConfig.CACHED)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.CACHED));
		}
		//assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.DRIVER));
		if(!exception.equals(EpsilonEmfModelConfig.FILE)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.FILE));
		}
		if(!exception.equals(EpsilonEmfModelConfig.MODEL_URI)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.MODEL_URI));
		}
		if(!exception.equals(EpsilonEmfModelConfig.NAME)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.NAME));
		}
		if(!exception.equals(EpsilonEmfModelConfig.READ_ON_LOAD)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.READ_ON_LOAD));
		}
		if(!exception.equals(EpsilonEmfModelConfig.SOURCE_FILE)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.SOURCE_FILE));
		}
		if(!exception.equals(EpsilonEmfModelConfig.STORE_ON_DISPOSAL)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL));
		}
		if(!exception.equals(EpsilonEmfModelConfig.XML_URI)) {
			assertNull("Paramter should have been null (not previously set)", tester.getParameter(EpsilonEmfModelConfig.XML_URI));
		}
	}

}
