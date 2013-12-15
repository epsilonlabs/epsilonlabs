package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.PlusOperatorExpression;

public class PlusOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "+";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof PlusOperatorExpression;
	}

}
