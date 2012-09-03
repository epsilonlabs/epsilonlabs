package org.eclipse.epsilon.eol.dom.printer;

public class GreaterThanOrEqualToOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return ">=";
	}

}
