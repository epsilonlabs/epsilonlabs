package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class IfStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.IF)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public EOLElement create(AST ast, EOLElement container,
			Ast2EolContext context) {
		
		IfStatement statement = (IfStatement) context.getEolFactory().createIfStatement(); //create an IfStatement
		this.setAssets(ast, statement, container);
		
		AST conditionAst = ast.getFirstChild(); //fetch the condition ast
		AST ifBodyAst = conditionAst.getNextSibling(); //fetch the body ast
		AST elseBodyAst = ifBodyAst.getNextSibling(); //fetch the else body ast
		
		statement.setCondition((Expression) context.getEolElementCreatorFactory().createEOLElement(conditionAst, statement, context)); //process condition
		
		if (ifBodyAst != null) {
			statement.setIfBody((ExpressionOrStatementBlock) context.getEolElementCreatorFactory().createEOLElement(ifBodyAst, statement, context, ExpressionOrStatementBlockCreator.class));		
		}
		if (elseBodyAst != null) { //if there is a else-body
			statement.setElseBody((ExpressionOrStatementBlock) context.getEolElementCreatorFactory().createEOLElement(elseBodyAst, statement, context, ExpressionOrStatementBlockCreator.class));
		}
		
		return statement;
	}
}
