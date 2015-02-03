package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import java.util.ArrayList;

import log.LogBook;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.ast2eol.util.Ast2EolUtil;


public class VariableResolutionContext {
	
	public final String VARIABLE_EXISTED = "Variable with the same name is already defined: ";
	public final String RESERVED_KEYWORD = "Cannot create an variable with a reserved keyword";
	public final String MODEL_DECL_NO_NAME = "Model declaration needs to define a name";
	public final String MODEL_ALIAS_NAME_TAKEN = "Alias name already used in a model name";
	public final String MODEL_DECL_NO_DRIVER = "No model driver specified";
	
	protected ArrayList<String> keywordPool = new ArrayList<String>();
	
	protected FrameStack stack = new FrameStack(); //the frameStack
	protected LogBook logBook = new LogBook(); //logbook for storing warnings and errors
	
	protected ArrayList<AssignmentStatement> assignmentsToAvoid = new ArrayList<AssignmentStatement>();
	
//	protected Ast2EolUtil ast2DomUtil = new Ast2EolUtil();
//	protected EolFactory eolFactory = new EolFactoryImpl(); //the eolFactory for creating DomElements

	protected EolElement currentEolElement = null;
	
	protected EolLibraryModule mainProgram = null; //main program, which is the EOL program in question

	protected ArrayList<String> modelNames = new ArrayList<String>();

	public FrameStack getStack()
	{
		return stack;
	}
	
//	public EolFactory getEolFactory()
//	{
//		return eolFactory;
//	}
	
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
	
//	public Ast2EolUtil getAst2DomUtil()
//	{
//		return ast2DomUtil;
//	}
	
	public boolean isReservedWord(String s)
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
				s.equals("_ModelElementType_") ||
				s.equalsIgnoreCase("Sequence") ||
				s.equalsIgnoreCase("model") ||
				s.equalsIgnoreCase("switch") ||
				s.equalsIgnoreCase("abort") ||
				s.equalsIgnoreCase("native") ||
				s.equalsIgnoreCase("return") ||
				s.equalsIgnoreCase("for") ||
				s.equalsIgnoreCase("function") ||
				s.equalsIgnoreCase("delete") ||
				s.equalsIgnoreCase("breakAll") ||
				s.equalsIgnoreCase("Set") ||
				s.equalsIgnoreCase("import") ||
				s.equalsIgnoreCase("if") ||
				s.equalsIgnoreCase("else") ||
				s.equalsIgnoreCase("break") ||
				s.equalsIgnoreCase("and") ||
				s.equalsIgnoreCase("var") ||
				s.equalsIgnoreCase("not") ||
				s.equalsIgnoreCase("while") ||
				s.equalsIgnoreCase("in") ||
				s.equalsIgnoreCase("default") ||
				s.equalsIgnoreCase("new") ||
				s.equalsIgnoreCase("OrderedSet") ||
				s.equalsIgnoreCase("alias") ||
				s.equalsIgnoreCase("Collection") ||
				s.equalsIgnoreCase("Bag") ||
				s.equalsIgnoreCase("throw") ||
				s.equalsIgnoreCase("xor") ||
				s.equalsIgnoreCase("operation") ||
				s.equalsIgnoreCase("case") ||
				s.equalsIgnoreCase("continue") ||
				s.equalsIgnoreCase("List") ||
				s.equalsIgnoreCase("Map") ||
				s.equalsIgnoreCase("or") ||
				s.equalsIgnoreCase("transaction") ||
				s.equalsIgnoreCase("driver") ||
				s.equalsIgnoreCase("float") ||
				s.equalsIgnoreCase("boolean") ||
				s.equalsIgnoreCase("string") ||
				s.equalsIgnoreCase("implies") ||
				s.equalsIgnoreCase("model")) {
			return true;
		}
		else if (s.contains("Bag(")) {
			return true;
		}
		else if (s.contains("Set\\(")) {
			return true;		
		}
		else if (s.contains("OrderedSet(")) {
			return true;	
		}
		else if (s.contains("Sequence(")) {
			return true;		
		}
		else if (s.contains("Collection(")) {
			return true;	
		}
		else {
			return false;
		}
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
				s.equals("_ModelElementType_") ||
				s.equalsIgnoreCase("Sequence") ||
				s.equalsIgnoreCase("model") ||
				s.equalsIgnoreCase("switch") ||
				s.equalsIgnoreCase("abort") ||
				s.equalsIgnoreCase("native") ||
				s.equalsIgnoreCase("return") ||
				s.equalsIgnoreCase("for") ||
				s.equalsIgnoreCase("function") ||
				s.equalsIgnoreCase("delete") ||
				s.equalsIgnoreCase("breakAll") ||
				s.equalsIgnoreCase("Set") ||
				s.equalsIgnoreCase("import") ||
				s.equalsIgnoreCase("if") ||
				s.equalsIgnoreCase("else") ||
				s.equalsIgnoreCase("break") ||
				s.equalsIgnoreCase("and") ||
				s.equalsIgnoreCase("var") ||
				s.equalsIgnoreCase("not") ||
				s.equalsIgnoreCase("while") ||
				s.equalsIgnoreCase("in") ||
				s.equalsIgnoreCase("default") ||
				s.equalsIgnoreCase("new") ||
				s.equalsIgnoreCase("OrderedSet") ||
				s.equalsIgnoreCase("alias") ||
				s.equalsIgnoreCase("Collection") ||
				s.equalsIgnoreCase("Bag") ||
				s.equalsIgnoreCase("throw") ||
				s.equalsIgnoreCase("xor") ||
				s.equalsIgnoreCase("operation") ||
				s.equalsIgnoreCase("case") ||
				s.equalsIgnoreCase("continue") ||
				s.equalsIgnoreCase("List") ||
				s.equalsIgnoreCase("Map") ||
				s.equalsIgnoreCase("or") ||
				s.equalsIgnoreCase("transaction") ||
				s.equalsIgnoreCase("driver") ||
				s.equalsIgnoreCase("float") ||
				s.equalsIgnoreCase("boolean") ||
				s.equalsIgnoreCase("string") ||
				s.equalsIgnoreCase("implies") ||
				s.equalsIgnoreCase("model")) {
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
		else if (s.contains("Collection(")) {
			String temp = s.replaceFirst("Collection\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		
		else {
			return false;
		}
	}
	
	public boolean nameDefinedInModelNames(String s)
	{
		if (modelNames.contains(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void putModelName(String name)
	{
		modelNames.add(name);
	}
	
	public ArrayList<AssignmentStatement> getAssignmentsToAvoid() {
		return assignmentsToAvoid;
	}
	
	public void addAssignmentToAvoid(AssignmentStatement assignmentStatement)
	{
		if (!assignmentsToAvoid.contains(assignmentStatement)) {
			assignmentsToAvoid.add(assignmentStatement);	
		}
	}
	
	public boolean isAssignmentToAvoid(AssignmentStatement assignmentStatement)
	{
		return assignmentsToAvoid.contains(assignmentStatement);
	}
	
	public void setCurrentEolElement(EolElement currentEolElement) {
		this.currentEolElement = currentEolElement;
	}
	
	public EolElement getCurrentEolElement() {
		return currentEolElement;
	}
	
}
