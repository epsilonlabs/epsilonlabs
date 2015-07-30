package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_VariableResolution;


public class VariableResolutionContext {
	
	protected HashSet<VariableDeclarationExpression> variables = new HashSet<VariableDeclarationExpression>();
	
	protected ArrayList<String> keywordPool = new ArrayList<String>();
	
	protected FrameStack stack = new FrameStack(); //the frameStack
	
	protected ArrayList<AssignmentStatement> assignmentsToAvoid = new ArrayList<AssignmentStatement>();
	
	protected EOLElement currentEolElement = null;
	
	protected EOLLibraryModule mainProgram = null; //main program, which is the EOL program in question

	protected ArrayList<String> modelNames = new ArrayList<String>();

	public FrameStack getStack()
	{
		return stack;
	}
	
	public void setMainProgram(EOLLibraryModule p)
	{
		mainProgram = p;
	}
	
	public EOLLibraryModule getMainProgram()
	{
		return mainProgram;
	}
		
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
				s.equals("null") ||
				s.equals("pre") ||
				s.equals("post") ||
				s.equals("_ModelElementType_") ||
				s.equalsIgnoreCase("model") ||
				s.equalsIgnoreCase("import") ||
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
			return isReservedWord(temp);
		}
		else if (s.contains("Set\\(")) {
			String temp = s.replaceFirst("Set\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isReservedWord(temp);
		}
		else if (s.contains("OrderedSet(")) {
			String temp = s.replaceFirst("OrderedSet\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isReservedWord(temp);
		}
		else if (s.contains("Sequence(")) {
			String temp = s.replaceFirst("Sequence\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isReservedWord(temp);
		}
		else if (s.contains("Collection(")) {
			String temp = s.replaceFirst("Collection\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isReservedWord(temp);
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
	
	public void setCurrentEolElement(EOLElement currentEolElement) {
		this.currentEolElement = currentEolElement;
	}
	
	public EOLElement getCurrentEolElement() {
		return currentEolElement;
	}
	
	public void storeVariable(VariableDeclarationExpression var)
	{
		variables.add(var);
	}
	
	public HashSet<VariableDeclarationExpression> getVariables() {
		return variables;
	}
	
	public void lookForUnusedVariables() {
		for(VariableDeclarationExpression vde: variables)
		{
			if (vde.getReferences().size() == 0) {
				LogBook.getInstance().addWarning(vde, IMessage_VariableResolution.bindMessage(IMessage_VariableResolution.VARIABLE_UNUSED, vde.getName().getName()));
			}
		}
	}
}
