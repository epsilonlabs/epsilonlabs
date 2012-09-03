package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.IntegerExpression;

public class IntegerExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		IntegerExpression exp = (IntegerExpression) context.getDomFactory().createIntegerExpression();
		int val = Integer.parseInt(ast.getText());
		exp.setVal(val);
		//exp.printSelf();
		
		//System.out.println(exp.getClass());
		
		exp.setLine(ast.getLine());
		exp.setColumn(ast.getColumn());
		return exp;
	}

}
