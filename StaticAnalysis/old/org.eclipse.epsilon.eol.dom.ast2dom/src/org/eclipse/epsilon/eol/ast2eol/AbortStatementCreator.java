package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.AbortStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
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
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		AbortStatement statement = context.getEolFactory().createAbortStatement();
		this.setAssets(ast, statement, container);

		return statement;
	}

}
