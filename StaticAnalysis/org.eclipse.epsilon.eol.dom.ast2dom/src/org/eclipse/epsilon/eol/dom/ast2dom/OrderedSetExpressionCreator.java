package org.eclipse.epsilon.eol.dom.ast2dom;


import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.OrderedSetExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class OrderedSetExpressionCreator extends CollectionExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
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
