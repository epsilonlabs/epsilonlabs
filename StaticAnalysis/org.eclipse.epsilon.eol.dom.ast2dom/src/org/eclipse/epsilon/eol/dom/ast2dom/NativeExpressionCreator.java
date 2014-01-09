package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NativeExpression;
import org.eclipse.epsilon.eol.dom.StringExpression;
import org.eclipse.epsilon.eol.dom.Type;
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
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		NativeExpression expr = context.getEolFactory().createNativeExpression(); //create expression
		this.setAssets(ast, expr, container); //set assets
				
		expr.setNativeExpr((StringExpression) context.getEolElementCreatorFactory().createDomElement(ast.getFirstChild(), expr, context)); //set native expression
		expr.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expr, context, NativeTypeCreator.class)); //set resolved type
		
		
		return expr;
	}

}
