package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import log.LogBook;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.ast2eol.util.Ast2EolUtil;


public class VariableResolutionContext {
	
	public final String VARIABLE_EXISTED = "Variable with the same is already defined: ";
	public final String RESERVED_KEYWORD = "cannot create an variable with a reserved keyword";
	
	
	protected FrameStack stack = new FrameStack(); //the frameStack
	protected EolFactory eolFactory = new EolFactoryImpl(); //the eolFactory for creating DomElements
	protected LogBook logBook = new LogBook(); //logbook for storing warnings and errors
	protected EolLibraryModule mainProgram = null; //main program, which is the EOL program in question
	protected Ast2EolUtil ast2DomUtil = new Ast2EolUtil();

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
	
	public void setMainProgram(EolLibraryModule p)
	{
		mainProgram = p;
	}
	
	public EolLibraryModule getMainProgram()
	{
		return mainProgram;
	}
	
	public Ast2EolUtil getAst2DomUtil()
	{
		return ast2DomUtil;
	}
		
	public boolean isKeyWordSimple(String s)
	{
		if (s.equals("Any") ||
				s.equals("Integer") ||
				s.equals("Boolean") ||
				s.equals("Real") ||
				s.equals("String") ||
				s.equals("Bag") ||
				s.equals("Set") ||
				s.equals("OrderedSet") ||
				s.equals("Sequence") ||
				s.equals("Map") ||
				s.equals("_ModelElementType_")) {
			return true;
		}
		else if (s.contains("Bag(")) {
			String temp = s.replaceFirst("Bag\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else if (s.contains("Set\\(")) {
			String temp = s.replaceFirst("Set\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else if (s.contains("OrderedSet(")) {
			String temp = s.replaceFirst("OrderedSet\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else if (s.contains("Sequence(")) {
			String temp = s.replaceFirst("Sequence\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else {
			return false;
		}
	}
}
