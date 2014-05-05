package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class BooleanExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		BooleanExpression expression = (BooleanExpression) context.getEolFactory().createBooleanExpression(); //create a BooleanExpression
		this.setAssets(ast, expression, container);		
		
		boolean val = false;
		
		if(ast.getText().equalsIgnoreCase("true"))
		{
			val = true;
		}
		else
		{
			val = false;
		}
		
		//System.err.println("value is " + val + " " +ast.getLine() + "-" + ast.getColumn());
		expression.setVal(val);
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, BooleanTypeCreator.class));
		
		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.BOOLEAN)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
