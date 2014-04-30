package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class NotOperatorExpressionCreator extends UnaryOperatorExpressionCreator{

	@Override
	public UnaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createNotOperatorExpression(); //create a NotOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "not";
	}

}
