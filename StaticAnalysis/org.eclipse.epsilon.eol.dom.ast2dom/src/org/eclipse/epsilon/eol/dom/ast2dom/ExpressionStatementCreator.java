package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.ExpressionStatement;

public class ExpressionStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) { //always returns false because not tested
		return false;
	}

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		ExpressionStatement statement = context.getEolFactory().createExpressionStatement();
		this.setAssets(ast, statement, container);
		
		statement.setExpression((Expression) context.getEolElementCreatorFactory().createDomElement(ast, statement, context)); //set expression
		
		return statement;
		
	}
}
