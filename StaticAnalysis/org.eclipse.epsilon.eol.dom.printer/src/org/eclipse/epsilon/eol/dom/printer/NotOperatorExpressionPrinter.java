package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NotOperatorExpression;


public class NotOperatorExpressionPrinter extends UnaryOperatorExpressionPrinter {
	
	public NotOperatorExpressionPrinter() {
		this.prefixed = true;
	}

	@Override
	protected String getOperatorSymbol() {
		return "not ";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NotOperatorExpression;
	}
	
}
