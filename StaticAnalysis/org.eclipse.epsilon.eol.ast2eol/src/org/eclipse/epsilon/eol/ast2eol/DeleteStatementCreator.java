package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class DeleteStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.DELETE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		DeleteStatement statement = (DeleteStatement) context.getEolFactory().createDeleteStatement(); //create a DeleteStatement 
		this.setAssets(ast, statement, container);
		
		AST deletedAst = ast.getFirstChild();
		if (deletedAst != null) {
			statement.setDeleted((Expression) context.getEolElementCreatorFactory().createDomElement(deletedAst, statement, context)); //set deleted
		}
		
		return statement;
	}

}
