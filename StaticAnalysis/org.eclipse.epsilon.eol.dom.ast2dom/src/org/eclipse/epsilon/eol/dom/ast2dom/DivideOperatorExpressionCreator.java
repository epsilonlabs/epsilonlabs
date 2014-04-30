package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;


public class DivideOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createDivideOperatorExpression(); //create a DivideOperatorExpression
	}

	@Override
	public String getOperator() {
		return "/";
	}

}
