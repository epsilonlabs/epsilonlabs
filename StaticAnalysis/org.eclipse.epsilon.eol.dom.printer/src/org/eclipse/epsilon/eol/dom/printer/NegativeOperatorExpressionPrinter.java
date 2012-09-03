package org.eclipse.epsilon.eol.dom.printer;

public class NegativeOperatorExpressionPrinter extends UnaryOperatorExpressionPrinter{

	public NegativeOperatorExpressionPrinter()
	{
		prefixed = true;
	}
	
	@Override
	protected String getOperatorSymbol() {
		return "-";
	}

	


}
