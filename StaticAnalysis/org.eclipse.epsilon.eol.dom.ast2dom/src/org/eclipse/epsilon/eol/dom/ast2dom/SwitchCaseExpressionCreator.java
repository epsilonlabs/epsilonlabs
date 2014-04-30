package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchCaseExpressionCreator extends SwitchStatementCaseCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.CASE)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {

		SwitchCaseExpressionStatement statement = (SwitchCaseExpressionStatement) context.getEolFactory().createSwitchCaseExpressionStatement(); //create a SwitchCaseExpressionStatement
		this.setAssets(ast, statement, container);
		
		AST expressionAst = ast.getFirstChild();
		if(expressionAst != null)
		{
			((SwitchCaseExpressionStatement)statement).setExpression((Expression) context.getEolElementCreatorFactory().createDomElement(expressionAst, statement, context)); //set the Expression	
		}
		
		AST blockAST = AstUtilities.getChild(ast, EolParser.BLOCK); //fetch the body AST for the switch case
		if(blockAST != null)
		{
			statement.setBody((Block)context.getEolElementCreatorFactory().createDomElement(blockAST, statement, context)); //set the body of the switch case
		}
		
		return statement;
	}

}
