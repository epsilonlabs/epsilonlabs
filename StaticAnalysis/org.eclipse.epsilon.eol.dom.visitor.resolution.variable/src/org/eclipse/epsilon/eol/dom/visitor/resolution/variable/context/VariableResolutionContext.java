package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context;

import log.LogBook;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.EolFactory;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.ast2dom.util.Ast2DomUtil;
import org.eclipse.epsilon.eol.dom.impl.EolFactoryImpl;


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
	
	public void setAssets(DomElement obj, DomElement container)
	{
		obj.setLine(container.getLine());
		obj.setColumn(container.getColumn());
		obj.setContainer(container);
	}

	
}
