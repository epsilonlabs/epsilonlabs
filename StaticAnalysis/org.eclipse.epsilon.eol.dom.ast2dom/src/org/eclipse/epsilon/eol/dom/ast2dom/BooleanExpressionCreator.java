package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.BooleanExpression;
import org.eclipse.epsilon.eol.dom.DomElement;

public class BooleanExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		BooleanExpression exp = (BooleanExpression) context.getDomFactory().createBooleanExpression();
		boolean val;
		if(ast.getText().equalsIgnoreCase("true"))
		{
			val = true;
		}
		else
		{
			val = false;
		}
		exp.setVal(val);
		
		exp.setLine(ast.getLine());
		exp.setColumn(ast.getColumn());
		return exp;
	}

}
