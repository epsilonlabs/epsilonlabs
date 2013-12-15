package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.XorOperatorExpression;

public class XorOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "xor";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof XorOperatorExpression;
	}

}
