package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class NativeExpressionCreator extends LiteralExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if((ast.getType() == EolParser.TYPE && ast.getText().equals("Native") && ast.getParent().getType() == EolParser.POINT) ||
				(ast.getType() == EolParser.TYPE && ast.getText().equals("Native") && ast.getParent().getType() == EolParser.PARAMETERS))//native expression is used when Native("xxx").foo is used
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
			Ast2DomContext context) {
		NativeExpression expr = context.getEolFactory().createNativeExpression(); //create expression
		this.setAssets(ast, expr, container); //set assets
				
		expr.setNativeExpr((StringExpression) context.getEolElementCreatorFactory().createDomElement(ast.getFirstChild(), expr, context)); //set native expression
		expr.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expr, context, NativeTypeCreator.class)); //set resolved type
		
		
		return expr;
	}

}
