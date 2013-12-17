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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.json.simple.JSONObject;

public class JsonPropertyGetter implements IPropertyGetter {

	@Override
	public boolean hasProperty(Object object, String property) {
		return false;
	}

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		return ((JSONObject)object).get(property);
	}

	@Override
	public AST getAst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAst(AST ast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContext(IEolContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEolContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
