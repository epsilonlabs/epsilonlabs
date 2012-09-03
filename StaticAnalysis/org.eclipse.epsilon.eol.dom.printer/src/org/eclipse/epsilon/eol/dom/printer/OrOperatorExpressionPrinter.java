package org.eclipse.epsilon.eol.dom.printer;

public class OrOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "or";
	}

}
