package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.BreakAllStatement;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class BreakAllStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		BreakAllStatement statement = context.getEolFactory().createBreakAllStatement(); //create a BreakAllStatement
		this.setAssets(ast, statement, container);
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.BREAKALL)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
