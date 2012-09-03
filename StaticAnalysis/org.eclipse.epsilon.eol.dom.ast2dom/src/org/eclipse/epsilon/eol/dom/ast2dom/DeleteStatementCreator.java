package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DeleteStatement;
import org.eclipse.epsilon.eol.dom.DomElement;

public class DeleteStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		DeleteStatement statement = (DeleteStatement) context.getDomFactory().createDeleteStatement();
		if (ast.getFirstChild() != null) {
			statement.setDeleted(context.getDomElementCreatorFactory().createExpression(ast.getFirstChild(), statement, context));
		}
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		return statement;
	}

}
