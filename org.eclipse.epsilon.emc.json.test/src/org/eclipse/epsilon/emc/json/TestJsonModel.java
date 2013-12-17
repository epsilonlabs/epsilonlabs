/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.json;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.Before;
import org.junit.Test;

public class TestJsonModel {
	
	protected ModelWithEolAssertions model;

	@Before
	public void setup() {
		String json = "{ \"state\" : [ { \"name\" : \"foo\" }, { \"name\" : \"bar\" } ] }";
		
		JsonModel jsonModel = new JsonModel();
		jsonModel.setName("M");
		jsonModel.setJson(json);
		jsonModel.setReadOnLoad(true);
		model = new ModelWithEolAssertions(jsonModel);
	}
	
	@Test
	public void simple() throws Exception {
		model.assertEquals(2, "t_state.all.size()");
		
	}
	
	@Test(expected=EolRuntimeException.class)
	public void unknownType() throws Throwable {
		model.evaluate("t_unknown.all.size()");
	}

	@Test
	public void attribute() throws Exception {
		model.assertEquals("foo", "t_state.all().first.a_name");
	}
}
