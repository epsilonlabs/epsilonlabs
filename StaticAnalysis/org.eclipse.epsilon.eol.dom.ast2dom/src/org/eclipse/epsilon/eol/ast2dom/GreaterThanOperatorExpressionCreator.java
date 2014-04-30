package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;


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
