package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.RealExpression;

public class RealExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		RealExpression exp = (RealExpression) context.getDomFactory().createRealExpression();
		exp.setVal(Double.parseDouble(ast.getText()));
		
		exp.setLine(ast.getLine());
		exp.setColumn(ast.getColumn());
		
		return exp;
	}

}
