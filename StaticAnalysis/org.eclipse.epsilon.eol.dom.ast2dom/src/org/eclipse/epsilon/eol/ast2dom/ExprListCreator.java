package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExprListCreator extends CollectionInitValueCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if (ast.getType() == EolParser.EXPRLIST) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		
		ExprList list = context.getEolFactory().createExprList();
		this.setAssets(ast, list, container);
		
		for(AST child: ast.getChildren()) //ast MUST have at least one children
		{
			list.getExpressions().add((Expression) context.getEolElementCreatorFactory().createDomElement(child, list, context));
		}
		
		return list;
	}
}
