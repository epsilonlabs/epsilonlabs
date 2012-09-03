package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ReturnStatement;

public class ReturnStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		ReturnStatement statement = (ReturnStatement) context.getDomFactory().createReturnStatement();
		if (ast.getFirstChild() != null) {
			statement.setReturned(context.getDomElementCreatorFactory().createExpression(ast.getFirstChild(), statement, context));
		}
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		return statement;
	}

}
