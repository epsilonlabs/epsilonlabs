package org.eclipse.epsilon.eol.ast2eol;

import java.util.HashMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;

public class Ast2EolContext {

	EolElementCreatorFactory eolElementCreatorFactory;
	EolFactory eolFactory;
	HashMap<EolElement, AST> trace = new HashMap<EolElement, AST>();
	
	public Ast2EolContext()
	{
		eolElementCreatorFactory = new EolElementCreatorFactory();
		eolFactory = new EolFactoryImpl();
	}
	
	public Ast2EolContext(EolElementCreatorFactory eolElementCreatorFactory)
	{
		this.eolElementCreatorFactory = eolElementCreatorFactory;
		eolFactory = new EolFactoryImpl();
	}
	
	public EolFactory getEolFactory()
	{
		return eolFactory;
	}
	
	public EolElementCreatorFactory getEolElementCreatorFactory()
	{
		return eolElementCreatorFactory;
	}
	
	public HashMap<EolElement, AST> getTrace() {
		return trace;
	}
}
