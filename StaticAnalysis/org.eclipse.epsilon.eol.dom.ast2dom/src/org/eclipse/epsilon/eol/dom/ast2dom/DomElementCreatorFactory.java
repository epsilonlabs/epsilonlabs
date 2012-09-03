package org.eclipse.epsilon.eol.dom.ast2dom;


import java.util.LinkedList;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.dom.*;

public class DomElementCreatorFactory {
	
	
	LinkedList<Program> programs;

	public DomElementCreatorFactory()
	{
		programs = new LinkedList<Program>();
	}
	
	public LinkedList<Program> getPrograms()
	{
		return programs;
	}
	
	public void printPrograms()
	{
		for(Program program : programs)
		{
			System.out.println("program: " + program.getName() + " Number of statements: " + program.getStatements().size() + " Number of operations: " + program.getOperations().size());
		}
	}
	


public DomElement createDomElement(AST ast, DomElement container, Ast2DomContext context) {
		
		DomElement e = null;
		//System.out.println(ast.getType());
		
		switch (ast.getType()) {
			case EolParser.EOLMODULE : e = new ProgramCreator().create(ast, container, context); break; //done
			case EolParser.IMPORT : e = new ImportCreator().create(ast, container, context);break; //done 
					
			
			case EolParser.VAR : e = new VariableDeclarationExpressionCreator().create(ast, container, context); break; //done
			case EolParser.NEW : e = processKeywordNew(ast, container, context); break; //done
			case EolParser.FORMAL : e = new VariableDeclarationExpressionCreator().create(ast, container, context); break; //done
			case EolParser.ASSIGNMENT : e = new AssignmentStatementCreator().create(ast, container, context); break; //done

			case EolParser.NAME : e = new NameOrMethodCallExpressionCreator().create(ast, container, context); break;
			case EolParser.POINT : e = new FeatureCallExpressionCreator().create(ast, container, context); break;
			case EolParser.ARROW : e = new FeatureCallExpressionCreator().create(ast, container, context); break;
			case EolParser.FEATURECALL : e = new NameOrMethodCallExpressionCreator().create(ast, container, context); break;
			
			case EolParser.OPERATOR : e = createOperatorExpression(ast, context); break;
			
			case EolParser.INT : e = new IntegerExpressionCreator().create(ast, container, context); break;
			case EolParser.BOOLEAN : e = new BooleanExpressionCreator().create(ast, container, context); break;
			case EolParser.STRING : e = new StringExpressionCreator().create(ast, container, context); break;
			case EolParser.FLOAT : e = new RealExpressionCreator().create(ast, container, context); break;
			
			case EolParser.COLLECTION : e = processKeywordCollection(ast, container, context); break;

			case EolParser.IF : e = new IfStatementCreator().create(ast, container, context); break;
			
			case EolParser.FOR : e = new ForStatementCreator().create(ast, container, context); break;
			
			case EolParser.WHILE : e = new WhileStatementCreator().create(ast, container, context); break;

			case EolParser.RETURN : e = new ReturnStatementCreator().create(ast, container, context); break;
			case EolParser.CONTINUE : e = new ContinueStatementCreator().create(ast, container, context); break;
			case EolParser.BREAK : e = new BreakStatementCreator().create(ast, container, context); break;
			case EolParser.BREAKALL : e = new BreakAllStatementCreator().create(ast, container, context); break;
			case EolParser.DELETE : e = new DeleteStatementCreator().create(ast, container, context); break;
			case EolParser.SWITCH : e = new SwitchStatementCreator().create(ast, container, context); break;
			case EolParser.CASE : e = new SwitchStatementCaseCreator().create(ast, container, context); break;
			case EolParser.DEFAULT : e = new SwitchStatementCaseCreator().create(ast, container, context); break;
			case EolParser.ENUMERATION_VALUE : e = new EnumerationLiteralExpressionCreator().create(ast, container, context); break;
			
			case EolParser.HELPERMETHOD : e = new OperationDefinitionCreator().create(ast, container, context); break;

			// TODO: Add commit abort transaction etc.
		}
		
		if (e == null) {
			throw new RuntimeException("Cannot create dom element for " + ast.getText() + "->" + ast.getType());
		}
		else {
			//System.out.println(e.getClass());
			e.setContainer(container);
			return e;
		}
	}

	protected DomElement processKeywordNew(AST ast, DomElement container, Ast2DomContext context)
	{
		DomElement result = null;
		if(isLiteralKeyWord(ast.getFirstChild().getText()))
		{
			result = createDomElement(ast.getFirstChild(), container, context);
		}
		else
		{
			result = new VariableDeclarationExpressionCreator().create(ast, container, context);
		}
		return result;
	}
	
	protected DomElement processKeywordCollection(AST ast, DomElement container, Ast2DomContext context)
	{
		DomElement result = null;
		if(ast.getText().equalsIgnoreCase("Sequence"))
		{
			result = new SequenceExpressionCreator().create(ast, container, context);
		}
		else if(ast.getText().equalsIgnoreCase("Set"))
		{
			result = new SetExpressionCreator().create(ast, container, context);
		}
		else if(ast.getText().equalsIgnoreCase("OrderedSet"))
		{
			result = new OrderedSetExpressionCreator().create(ast, container, context);
		}
		else if(ast.getText().equalsIgnoreCase("Bag"))
		{
			result = new BagExpressionCreator().create(ast, container, context);
		}
		return result;
	}

	
	protected OperatorExpression createOperatorExpression(AST ast, Ast2DomContext context) {
		
		OperatorExpression exp = null;
		String operator = ast.getText();
		if (operator.equals("and")) {
			exp = (AndOperatorExpression) new AndOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("or")) {
			exp = (OrOperatorExpression) new OrOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("xor")) {
			exp = (XorOperatorExpression) new XorOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("implies")) {
			exp = (ImpliesOperatorExpression) new ImpliesOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("not")) {
			exp = (NotOperatorExpression) new NotOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("+")) {
			exp = (PlusOperatorExpression) new PlusOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("-")) {
			if (ast.getChildren().size() == 1) {
				exp = ( NegativeOperatorExpression) new NegativeOperatorExpressionCreator().create(null, null, context);
			}
			else {
				exp = (MinusOperatorExpression) new MinusOperatorExpressionCreator().create(null, null, context);
			}
		}
		else if (operator.equals("*")) {
			exp = (MultiplyOperatorExpression) new MultiplyOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("/")) {
			exp = (DivideOperatorExpression) new DivideOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("=") || operator.equals("==")) {
			exp = (EqualsOperatorExpression) new EqualsOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("<>") || operator.equals("!=")) {
			exp = (NotEqualsOperatorExpression) new NotEqualsOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals(">")) {
			exp = (GreaterThanOperatorExpression) new GreaterThanOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("<")) {
			exp = (LessThanOperatorExpression) new LessThanOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals("<=")) {
			exp = (LessThanOrEqualToOperatorExpression) new LessThanOrEqualsToOperatorExpressionCreator().create(null, null, context);
		}
		else if (operator.equals(">=")) {
			exp = (GreaterThanOrEqualToOperatorExpression) new GreaterThanOrEqualToOperatorExpressionCreator().create(null, null, context);
		}	
		
		if (exp instanceof BinaryOperatorExpression) {
			((BinaryOperatorExpression) exp).setLhs((Expression) createDomElement(ast.getChild(0), exp, context));
			try {
				((BinaryOperatorExpression) exp).setRhs((Expression) createDomElement(ast.getChild(1), exp, context));
			}
			catch (Exception ex) {
				System.err.println(ex);
				System.err.println("error: " + ast.getLine() + ":" + ast.getColumn());
			}
		}
		else {
			((UnaryOperatorExpression) exp).setExpr((Expression) createDomElement(ast.getFirstChild(), exp, context));
		}
		
		exp.setLine(ast.getLine());
		exp.setColumn(ast.getColumn());
		
		return exp;
	}


	
	protected Expression createExpression(AST ast, DomElement parent, Ast2DomContext context) {
		return (Expression) createDomElement(ast, parent, context);
	}
	
	

	
	protected Statement createStatement(AST ast, DomElement container, Ast2DomContext context) {		
		Statement statement = null;
		DomElement e = createDomElement(ast, container, context);
		if (e instanceof Statement) {
			//e.printSelf();
			//System.out.println(e.getClass());
			return statement = (Statement) e;
		}
		else if (e instanceof EqualsOperatorExpression) {
			EqualsOperatorExpression exp = (EqualsOperatorExpression) e;
			AssignmentStatement as = (AssignmentStatement) context.getDomFactory().createAssignmentStatement();
			as.setContainer(container);
			as.setLhs(exp.getLhs());
			as.setRhs(exp.getRhs());
			Expression lhs = (Expression)as.getLhs();
			Expression rhs = (Expression)as.getRhs();
			lhs.setContainer(as);
			rhs.setContainer(as);
			statement = as;
		}
		else {
			statement = (ExpressionStatement) context.getDomFactory().createExpressionStatement() ;
			statement.setContainer(container);
			((ExpressionStatement) statement).setExpression((Expression) e);
			((Expression) e).setContainer(statement);
		}
		//System.out.println(statement.getClass());
		
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		
		return statement;
	}
	
	public boolean isLiteralKeyWord(String s)
	{
		boolean result = false;
		LinkedList<String> keywords = new LinkedList<String>();
		keywords.add("Boolean");
		keywords.add("Integer");
		keywords.add("Real");
		keywords.add("String");
		keywords.add("Any");
		keywords.add("Map");
		keywords.add("Set");
		keywords.add("OrderedSet");
		keywords.add("Sequence");
		keywords.add("Bag");
		
		for(String key: keywords)
		{
			if(s.equalsIgnoreCase(key))
			{
				result = true;
				break;
			}
		}
		
		return result;
	}

}
