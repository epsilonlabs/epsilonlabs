package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.OrOperatorExpression;

public class OrOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "or";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OrOperatorExpression;
	}

}
