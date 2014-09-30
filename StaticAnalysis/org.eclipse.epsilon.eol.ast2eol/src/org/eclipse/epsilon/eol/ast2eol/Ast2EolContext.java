package org.eclipse.epsilon.eol.ast2eol;

import java.util.HashMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;

public class Ast2EolContext {

	protected EolElementCreatorFactory eolElementCreatorFactory;
	protected EolFactory eolFactory;
	protected HashMap<EolElement, AST> trace = new HashMap<EolElement, AST>();
	protected org.eclipse.epsilon.eol.EolLibraryModule module = null;
	
	public Ast2EolContext()
	{
		eolElementCreatorFactory = new EolElementCreatorFactory();
		eolFactory = new EolFactoryImpl();
	}
	
	public Ast2EolContext(org.eclipse.epsilon.eol.EolLibraryModule module)
	{
		eolElementCreatorFactory = new EolElementCreatorFactory();
		eolFactory = new EolFactoryImpl();
		this.module = module;
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
	
	public org.eclipse.epsilon.eol.EolLibraryModule getModule() {
		return module;
	}
}
