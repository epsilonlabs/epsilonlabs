package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement;
import org.eclipse.epsilon.eol.dom.SwitchCaseStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchStatementCaseCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		SwitchCaseStatement statement = null;
		AST expressionAst = null;
		
		if (ast.getType() == EolParser.CASE) {
			statement = (SwitchCaseExpressionStatement) context.getDomFactory().createSwitchCaseExpressionStatement();
			
			expressionAst = ast.getFirstChild();
			((SwitchCaseExpressionStatement)statement).
				setExpression(context.getDomElementCreatorFactory().createExpression(expressionAst, statement, context));
		}
		else {
			statement = (SwitchCaseDefaultStatement) context.getDomFactory().createSwitchCaseDefaultStatement();
		}
		
		for (AST statementAst : ast.getChildren()) {
			if (statementAst != expressionAst) {
				statement.getBody().add(context.getDomElementCreatorFactory().createStatement(statementAst, statement, context));
			}
		}
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		return statement;
	}

}
