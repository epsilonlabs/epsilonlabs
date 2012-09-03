package org.eclipse.epsilon.eol.dom.printer;

public class AndOperatorExpressionPrinter extends BinaryOperatorExpressionPrinter {

	@Override
	protected String getOperatorSymbol() {
		return "and";
	}

}
