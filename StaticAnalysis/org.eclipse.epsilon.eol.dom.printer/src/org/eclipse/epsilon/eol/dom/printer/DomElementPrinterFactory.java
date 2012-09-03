package org.eclipse.epsilon.eol.dom.printer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.epsilon.eol.dom.*;




public class DomElementPrinterFactory {
	
	protected int indentation = 0;
	
	public String print(DomElement e) {
		
		DomElementPrinter printer = null;
		
		if (e instanceof Program) printer = new ProgramPrinter();
		else if (e instanceof Import) printer = new ImportPrinter();
		
		else if (e instanceof StringExpression) printer = new StringExpressionPrinter();
		else if (e instanceof IntegerExpression) printer = new IntegerExpressionPrinter();
		else if (e instanceof BooleanExpression) printer = new BooleanExpressionPrinter();
		else if (e instanceof RealExpression) printer = new RealExpressionPrinter();
		
		else if (e instanceof SequenceExpression) printer = new SequenceExpressionPrinter();
		else if (e instanceof SetExpression) printer = new SetExpressionPrinter();
		else if (e instanceof OrderedSetExpression) printer = new OrderedSetExpressionPrinter();
		else if (e instanceof BagExpression) printer = new BagExpressionPrinter();
		
		else if (e instanceof VariableDeclarationExpression) printer = new VariableDeclarationExpressionPrinter();
		else if (e instanceof PropertyCallExpression) printer = new PropertyCallExpressionPrinter();
		else if (e instanceof MethodCallExpression) printer = new MethodCallExpressionPrinter();
		else if (e instanceof FLOMethodCallExpression) printer = new FLOMethodCallExpressionPrinter();
		else if (e instanceof NameExpression) printer = new NameExpressionPrinter();
		
		else if (e instanceof PlusOperatorExpression) printer = new PlusOperatorExpressionPrinter();
		else if (e instanceof MinusOperatorExpression) printer = new MinusOperatorExpressionPrinter();
		else if (e instanceof MultiplyOperatorExpression) printer = new MultiplyOperatorExpressionPrinter();
		else if (e instanceof DivideOperatorExpression) printer = new DivOperatorExpressionPrinter();
		else if (e instanceof AndOperatorExpression) printer = new AndOperatorExpressionPrinter();
		else if (e instanceof OrOperatorExpression) printer = new OrOperatorExpressionPrinter();
		else if (e instanceof XorOperatorExpression) printer = new XorOperatorExpressionPrinter();
		else if (e instanceof EqualsOperatorExpression) printer = new EqualsOperatorExpressionPrinter();
		else if (e instanceof GreaterThanOperatorExpression) printer = new GreaterThanOperatorExpressionPrinter();
		else if (e instanceof LessThanOperatorExpression) printer = new LessThanOperatorExpressionPrinter();
		else if (e instanceof GreaterThanOrEqualToOperatorExpression) printer = new GreaterThanOrEqualToOperatorExpressionPrinter();
		else if (e instanceof LessThanOrEqualToOperatorExpression) printer = new LessThanOrEqualToOperatorExpressionPrinter();
		else if (e instanceof ImpliesOperatorExpression) printer = new ImpliesOperatorExpressionPrinter();
		//else if (e instanceof ExpressionEqualsEqualsOperator) printer = new ExpressionEqualsEqualsOperatorPrinter();
		else if (e instanceof NotEqualsOperatorExpression) printer = new NotEqualsOperatorExpressionPrinter();
		
		else if (e instanceof NotOperatorExpression) printer = new NotOperatorExpressionPrinter();
		else if (e instanceof NegativeOperatorExpression) printer = new NegativeOperatorExpressionPrinter();
		
		else if (e instanceof EnumerationLiteralExpression) printer = new EnumerationLiteralExpressionPrinter();
		
		else if (e instanceof AssignmentStatement) printer = new AssignmentStatementPrinter();
		else if (e instanceof ExpressionStatement) printer = new ExpressionStatementPrinter();
		else if (e instanceof IfStatement) printer = new IfStatementPrinter();
		else if (e instanceof ForStatement) printer = new ForStatementPrinter();
		else if (e instanceof WhileStatement) printer = new WhileStatementPrinter();
		else if (e instanceof SwitchStatement) printer = new SwitchStatementPrinter();
		else if (e instanceof ContinueStatement) printer = new ContinueStatementPrinter();
		else if (e instanceof BreakStatement) printer = new BreakStatementPrinter();
		else if (e instanceof BreakAllStatement) printer = new BreakAllStatementPrinter();
		else if (e instanceof SwitchCaseStatement) printer = new SwitchCaseStatementPrinter();
		else if (e instanceof ReturnStatement) printer = new ReturnStatementPrinter();
		
		else if (e instanceof OperationDefinition) printer = new OperationDefinitionPrinter();
		
		
		
		if (printer == null) throw new RuntimeException("No printer for " + e); 
		
		String str = "";
		
		if (e instanceof Statement) {
			str = whitespace();
		}
		
		return str + printer.print(e, this);
	}
	
	public String whitespace() {
		String str = "";
		for (int i = 0; i<indentation; i++) {
			str += "   ";
		}
		return str;
	}
	
	protected HashSet<String> keywords = null;
	protected Collection<String> getKeywords() {
		if (keywords == null) {
			keywords = new HashSet<String>();
			keywords.add("for");
		}
		return keywords;
	}
	
	protected boolean isValidIdentifier(String s) {
	    if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
	        return false;
	    }
	    for (int i=1; i<s.length(); i++) {
	        if (!Character.isJavaIdentifierPart(s.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public String escapeName(String name) {
		if (getKeywords().contains(name) || !isValidIdentifier(name)) {
			return "`" + name + "`";
		}
		else {
			return name;
		}
	}
	
	public boolean nameExists(String name)
	{
		if (getKeywords().contains(name) || !isValidIdentifier(name)) {
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String print(Collection c, String delimiter) {
		Iterator it = c.iterator();
		String str = "";
		while (it.hasNext()) {
			str = str + print((DomElement) it.next());
			if (it.hasNext()) {
				str = str + delimiter;
			}
		}
		return str;
	}
	
	public String addQuotes(String s) {
		return "\'" + s + "\'";
	}
	
	public String print(Collection c) {
		return print(c, true);
	}
	
	public String print(Collection c, boolean newline) {
		if (newline) return print(c, newline());
		else return print(c,"");
	}
	
	public String newline() {
		return System.getProperty("line.separator");
	}
	
	public String indent() {
		indentation++;
		return "";
	}
	
	public String outdent() {
		indentation--;
		if (indentation < 0) indentation = 0;
		return "";
	}
	
}
