package org.eclipse.epsilon.emc.ws;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;

public class RemoteObjectMethod extends ObjectMethod {
	
	protected String name;
	
	public RemoteObjectMethod(Object object, String name) {
		this.name = name;
		this.object = object;
	}
	
	@Override
	public Object execute(Object[] parameters, AST ast) throws EolRuntimeException {
		System.err.println("Executing " + name + " on " + object + " with " + parameters);
		return null;
	}
	
}
