package org.eclipse.epsilon.eol.dom.printer;

public class NotEqualsOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter{

	@Override
	protected String getOperatorSymbol() {
		return "<>";
	}

}
