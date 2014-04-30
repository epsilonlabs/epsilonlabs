package org.eclipse.epsilon.eol.ast2dom;


//Obsolete class
public class NameOrMethodCallExpressionCreator {
	
	/*
	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		AST parametersAst = ast.getFirstChild();
		
		if (parametersAst != null && parametersAst.getType() == EolParser.PARAMETERS) { //if contains parameters then it is a method call
			MethodCallExpression exp = (MethodCallExpression)context.getDomFactory().createMethodCallExpression(); //create a methodCallExpression
			exp.setLine(ast.getLine()); //set line number
			exp.setColumn(ast.getColumn());	//set column number
			
			NameExpression method = context.getDomFactory().createNameExpression(); //create an NameExpression for method
			method.setContainer(exp); //set container
			method.setLine(ast.getLine()); //set line
			method.setColumn(ast.getColumn()); //set column 
			method.setName(ast.getText()); //set name
			exp.setMethod(method); //set method for MethodCall
			
			for (AST parameterAst : parametersAst.getChildren()) {
				exp.getArguments().add((Expression) context.getDomElementCreatorFactory().createDomElement(parameterAst, exp, context)); //process parameters
			}
			
			return exp;
		}
		else { //if there are no parameters, it is a NameExpression
			if(ast.getText().contains("!")) //if it contains a "!" then it should be a type Expression
			{
				
			}
			NameExpression exp = (NameExpression) context.getDomFactory().createNameExpression(); //create a NameExpression
			exp.setLine(ast.getLine()); //set line
			exp.setColumn(ast.getColumn()); //set column 
			exp.setName(ast.getText()); //setName
			
			return exp;
		}
	}*/

}
