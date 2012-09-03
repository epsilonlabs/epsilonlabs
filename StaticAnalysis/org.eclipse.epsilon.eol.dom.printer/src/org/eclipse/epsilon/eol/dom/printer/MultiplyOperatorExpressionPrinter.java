package org.eclipse.epsilon.eol.dom.printer;

public class MultiplyOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "*";
	}

}
