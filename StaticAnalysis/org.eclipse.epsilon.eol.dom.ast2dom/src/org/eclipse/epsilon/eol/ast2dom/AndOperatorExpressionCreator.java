package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.BinaryOperatorExpression;



public class AndOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createAndOperatorExpression();
	}

	@Override
	public String getOperator() {
		return "and";
	}

}
