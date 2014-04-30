package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;


public class GreaterThanOrEqualToOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createGreaterThanOrEqualToOperatorExpression(); //create a GreaterThanOrEqualToOperatorExpression;
	}

	@Override
	public String getOperator() {
		return ">=";
	}

}
