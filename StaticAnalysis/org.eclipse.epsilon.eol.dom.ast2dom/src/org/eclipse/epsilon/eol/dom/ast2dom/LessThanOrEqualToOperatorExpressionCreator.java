package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;

public class LessThanOrEqualToOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createLessThanOrEqualToOperatorExpression(); //create a LessThanOrEqualToOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "<=";
	}

}
