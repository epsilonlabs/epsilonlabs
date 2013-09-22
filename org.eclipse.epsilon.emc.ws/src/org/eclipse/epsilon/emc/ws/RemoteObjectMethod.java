package org.eclipse.epsilon.emc.ws;

import javax.wsdl.BindingOperation;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;

public class RemoteObjectMethod extends ObjectMethod {
	
	protected BindingOperation operation;
	
	public RemoteObjectMethod(Object object, BindingOperation operation) {
		this.operation = operation;
		this.object = object;
	}
	
	@Override
	public Object execute(Object[] parameters, AST ast) throws EolRuntimeException {
		System.err.println("Executing " + operation + " on " + object + " with " + parameters);
		return null;
	}
	
}
