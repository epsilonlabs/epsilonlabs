package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class AndOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "and";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AndOperatorExpression;
	}

}
