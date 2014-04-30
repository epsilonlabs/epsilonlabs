package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ContinueStatementCreator extends StatementCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		
		ContinueStatement statement = context.getEolFactory().createContinueStatement(); //create a ContinueStatement
		this.setAssets(ast, statement, container);
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.CONTINUE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
