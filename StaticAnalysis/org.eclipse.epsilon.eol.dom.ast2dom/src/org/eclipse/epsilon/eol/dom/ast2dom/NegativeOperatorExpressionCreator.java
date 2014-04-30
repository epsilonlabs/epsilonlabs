package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class NegativeOperatorExpressionCreator extends UnaryOperatorExpressionCreator{

	@Override
	public UnaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createNegativeOperatorExpression(); //create an NegativeOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "-";
	}

}
