package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.metamodel.*;

public class XorOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public BinaryOperatorExpression create(Ast2EolContext context) {
		return context.getEolFactory().createXorOperatorExpression(); //create an XorOperatorExpression;
	}

	@Override
	public String getOperator() {
		return "xor";
	}

}
