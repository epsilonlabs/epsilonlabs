package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.BagExpression;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class BagExpressionCreator extends CollectionExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		BagExpression expression = context.getEolFactory().createBagExpression();
		this.buildCollection(ast, expression, container, context);
		
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, BagTypeCreator.class));

		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.COLLECTION && ast.getText().equalsIgnoreCase("Bag"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
