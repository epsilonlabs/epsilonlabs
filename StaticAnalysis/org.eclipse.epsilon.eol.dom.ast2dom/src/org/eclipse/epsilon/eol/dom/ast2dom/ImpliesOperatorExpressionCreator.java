package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;

public class ImpliesOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createImpliesOperatorExpression(); //create an ImpliesOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "implies";
	}

}
