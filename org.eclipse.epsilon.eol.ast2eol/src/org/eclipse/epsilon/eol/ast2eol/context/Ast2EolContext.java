package org.eclipse.epsilon.eol.ast2eol.context;

import java.util.HashMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.problem.LogBook;

public class Ast2EolContext {

	protected EolElementCreatorFactory eolElementCreatorFactory;
	protected EolFactory eolFactory = EolFactory.eINSTANCE;
	protected HashMap<EOLElement, AST> trace = new HashMap<EOLElement, AST>();
	protected EolModule module = null;
	protected LogBook logBook = new LogBook();
	
	public Ast2EolContext()
	{
		eolElementCreatorFactory = new EolElementCreatorFactory();
	}
	
	public Ast2EolContext(EolModule module)
	{
		eolElementCreatorFactory = new EolElementCreatorFactory();
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
	
	public HashMap<EOLElement, AST> getTrace() {
		return trace;
	}
	
	public EolModule getModule() {
		return module;
	}
	
	public LogBook getLogBook() {
		return logBook;
	}
}