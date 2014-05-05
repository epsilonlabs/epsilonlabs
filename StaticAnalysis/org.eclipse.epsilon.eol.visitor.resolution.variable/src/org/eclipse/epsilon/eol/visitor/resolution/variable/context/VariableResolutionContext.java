package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import log.LogBook;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.ast2eol.util.Ast2DomUtil;


public class VariableResolutionContext {
	protected FrameStack stack = new FrameStack(); //the frameStack
	protected EolFactory eolFactory = new EolFactoryImpl(); //the eolFactory for creating DomElements
	protected LogBook logBook = new LogBook(); //logbook for storing warnings and errors
	protected Program mainProgram = null; //main program, which is the EOL program in question
	protected Ast2DomUtil ast2DomUtil = new Ast2DomUtil();

	public FrameStack getStack()
	{
		return stack;
	}
	
	public EolFactory getEolFactory()
	{
		return eolFactory;
	}
	
	public LogBook getLogBook()
	{
		return logBook;
	}
	
	public void setMainProgram(Program p)
	{
		mainProgram = p;
	}
	
	public Program getMainProgram()
	{
		return mainProgram;
	}
	
	public Ast2DomUtil getAst2DomUtil()
	{
		return ast2DomUtil;
	}
	
	public void setAssets(EolElement obj, EolElement container)
	{
		obj.setLine(container.getLine());
		obj.setColumn(container.getColumn());
		obj.setContainer(container);
	}

	
}
