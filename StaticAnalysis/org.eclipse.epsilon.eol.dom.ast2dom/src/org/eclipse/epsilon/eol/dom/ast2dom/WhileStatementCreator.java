package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.WhileStatement;

public class WhileStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		WhileStatement statement = (WhileStatement) context.getDomFactory().createWhileStatement();
		statement.setCondition(context.getDomElementCreatorFactory().createExpression(ast.getFirstChild(), statement, context));
		for (AST statementAst : ast.getChild(1).getChildren()) {
			statement.getBody().add(context.getDomElementCreatorFactory().createStatement(statementAst, statement, context));
		}
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		return statement;
	}

}
