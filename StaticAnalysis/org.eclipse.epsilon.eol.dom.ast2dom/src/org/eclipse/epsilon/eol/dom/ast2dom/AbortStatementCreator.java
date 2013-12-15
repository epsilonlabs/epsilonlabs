package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.AbortStatement;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class AbortStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.ABORT)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		AbortStatement statement = context.getEolFactory().createAbortStatement();
		this.setAssets(ast, statement, container);

		return statement;
	}

}
