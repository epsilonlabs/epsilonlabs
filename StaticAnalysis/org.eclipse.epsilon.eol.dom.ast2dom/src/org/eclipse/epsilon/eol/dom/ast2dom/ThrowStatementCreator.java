package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.ThrowStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ThrowStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.THROW)
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
		
		ThrowStatement statement = context.getEolFactory().createThrowStatement();
		this.setAssets(ast, statement, container);
		
		AST thrownAst = ast.getFirstChild();
		if(thrownAst != null)
		{
			statement.setThrown((Expression) context.getEolElementCreatorFactory().createDomElement(thrownAst, statement, context));
		}
		
		return statement;
	}

}
