package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;

public class MinusOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createMinusOperatorExpression(); //create a MinusOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "-";
	}

}
