package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.metamodel.*;

public class PlusOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2EolContext context) {
		return context.getEolFactory().createPlusOperatorExpression(); //create a PlusOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "+";
	}

}
