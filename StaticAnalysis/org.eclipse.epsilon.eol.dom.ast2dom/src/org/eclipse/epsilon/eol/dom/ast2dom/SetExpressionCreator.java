package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SetExpressionCreator extends CollectionExpressionCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {

		SetExpression expression = context.getEolFactory().createSetExpression(); //create a set Expression
		this.buildCollection(ast, expression, container, context);
		
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, SetTypeCreator.class));
		
		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.COLLECTION && ast.getText().equals("Set"))
		{
			return true;
		}
		else {
			return false;
		}
	}

}
