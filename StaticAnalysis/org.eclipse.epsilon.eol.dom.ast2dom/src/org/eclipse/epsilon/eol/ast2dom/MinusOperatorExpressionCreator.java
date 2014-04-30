package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;


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
