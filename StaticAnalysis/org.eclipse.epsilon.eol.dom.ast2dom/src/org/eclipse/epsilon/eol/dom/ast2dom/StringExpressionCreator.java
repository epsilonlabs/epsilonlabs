package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.StringExpression;

public class StringExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		StringExpression exp = (StringExpression) context.getDomFactory().createStringExpression();
		exp.setVal(ast.getText());
		exp.setLine(ast.getLine());
		exp.setColumn(ast.getColumn());
		
		//exp.printSelf();
		//System.out.println(exp.getClass());
		return exp;
	}

}
