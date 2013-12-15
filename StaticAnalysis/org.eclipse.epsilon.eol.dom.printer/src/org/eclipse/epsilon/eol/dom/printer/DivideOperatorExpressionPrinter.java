package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DivideOperatorExpression;
import org.eclipse.epsilon.eol.dom.DomElement;

public class DivideOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "/";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof DivideOperatorExpression;
	}

}
