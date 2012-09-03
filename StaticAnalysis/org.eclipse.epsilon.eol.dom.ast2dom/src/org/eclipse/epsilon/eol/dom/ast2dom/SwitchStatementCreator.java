package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SwitchCaseStatement;
import org.eclipse.epsilon.eol.dom.SwitchStatement;

public class SwitchStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		SwitchStatement statement = (SwitchStatement) context.getDomFactory().createSwitchStatement();
		AST expressionAst = ast.getFirstChild();
		statement.setExpression(context.getDomElementCreatorFactory().createExpression(expressionAst, statement, context));
		for (AST caseAst : ast.getChildren()) {
			if (caseAst != expressionAst) {
				statement.getCases().add((SwitchCaseStatement) context.getDomElementCreatorFactory().createDomElement(caseAst, statement, context));
			}
		}
		
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		return statement;
	}

}
