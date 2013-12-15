package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.AndOperatorExpression;
import org.eclipse.epsilon.eol.dom.DomElement;

public class AndOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "and";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AndOperatorExpression;
	}

}
