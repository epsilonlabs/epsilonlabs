package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;

public class GreaterThanOperatorExpressionCreator extends BinaryOperatorExpressionCreator{


	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createGreaterThanOperatorExpression(); //create a GreaterThanOperatorExpression
	}

	@Override
	public String getOperator() {
		return ">";
	}

}
