package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class NegativeOperatorExpressionPrinter extends UnaryOperatorExpressionPrinter{

	public NegativeOperatorExpressionPrinter()
	{
		prefixed = true;
	}
	
	@Override
	protected String getOperatorSymbol() {
		return "-";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NegativeOperatorExpression;
	}

	


}
