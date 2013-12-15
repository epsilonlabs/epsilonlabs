package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.IntegerExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class IntegerExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		IntegerExpression expression = (IntegerExpression) context.getEolFactory().createIntegerExpression(); //create an IntegerExpression
		this.setAssets(ast, expression, container);
		
		int val = 0;
		val = Integer.parseInt(ast.getText()); //parse value
		expression.setVal(val); //set value
		
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, IntegerTypeCreator.class));
		
		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.INT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
