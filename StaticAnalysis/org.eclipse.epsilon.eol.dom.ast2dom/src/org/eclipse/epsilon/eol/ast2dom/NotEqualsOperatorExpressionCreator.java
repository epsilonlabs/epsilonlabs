package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class NotEqualsOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createNotEqualsOperatorExpression(); //create a NotEqualsOperatorExpression
	}

	@Override
	public String getOperator() {
		return "<>";
	}

}
