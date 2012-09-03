package org.eclipse.epsilon.eol.dom.printer;

public class MinusOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "-";
	}

}
