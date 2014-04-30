package org.eclipse.epsilon.eol.ast2dom;


import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class OrderedSetExpressionCreator extends CollectionExpressionCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {

		OrderedSetExpression expression = context.getEolFactory().createOrderedSetExpression();
		this.buildCollection(ast, expression, container, context);
		
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, OrderedSetTypeCreator.class));
		
		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.COLLECTION && ast.getText().equals("OrderedSet"))
		{
			return true;
		}
		else {
			return false;
		}
	}

}
