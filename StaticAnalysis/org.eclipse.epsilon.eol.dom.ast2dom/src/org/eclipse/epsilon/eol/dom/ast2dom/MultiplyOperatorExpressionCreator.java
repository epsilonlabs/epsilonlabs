package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;

public class MultiplyOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createMultiplyOperatorExpression(); //create a MultiplyOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "*";
	}

}
