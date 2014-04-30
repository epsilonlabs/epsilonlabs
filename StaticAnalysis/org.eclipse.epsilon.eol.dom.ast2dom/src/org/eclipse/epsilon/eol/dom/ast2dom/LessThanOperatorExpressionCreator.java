package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;


public class LessThanOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createLessThanOperatorExpression(); //create a LessThanOperatorExpression
	}

	@Override
	public String getOperator() {
		return "<";
	}

}
