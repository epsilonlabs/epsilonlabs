package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.BreakStatement;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class BreakStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		BreakStatement statement = context.getEolFactory().createBreakStatement();
		this.setAssets(ast, statement, container);
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.BREAK)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
