package org.eclipse.epsilon.eol.dom.printer;

public class EqualsOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "=";
	}

}
