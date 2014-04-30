package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class PlusOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {
		return context.getEolFactory().createPlusOperatorExpression(); //create a PlusOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "+";
	}

}
