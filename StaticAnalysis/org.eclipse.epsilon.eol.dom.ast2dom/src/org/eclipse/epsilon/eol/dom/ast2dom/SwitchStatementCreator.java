package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement;
import org.eclipse.epsilon.eol.dom.SwitchStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		SwitchStatement statement = (SwitchStatement) context.getEolFactory().createSwitchStatement(); //create a SwitchStatement
		this.setAssets(ast, statement, container);
		
		AST expressionAst = ast.getFirstChild(); //get expression AST
		statement.setExpression((Expression) context.getEolElementCreatorFactory().createDomElement(expressionAst, statement, context)); //process expression AST
		
		for (AST caseAst : ast.getChildren()) {
			if (caseAst != expressionAst) {
				if(caseAst.getType() == EolParser.CASE)
				{
					statement.getCases().add( (SwitchCaseExpressionStatement) context.getEolElementCreatorFactory().createDomElement(caseAst, statement, context)); //process switch cases
				}
				else {
					statement.setDefault((SwitchCaseDefaultStatement) context.getEolElementCreatorFactory().createDomElement(caseAst, statement, context));
				}
			}
		}
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.SWITCH)
		{
			return true;
		}
		else {
			return false;
		}
	}

}