package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;

public class XorOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createXorOperatorExpression(); //create an XorOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "xor";
	}

}
