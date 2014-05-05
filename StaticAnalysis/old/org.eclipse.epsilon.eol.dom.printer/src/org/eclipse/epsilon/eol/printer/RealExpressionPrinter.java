package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class RealExpressionPrinter extends PrimitiveExpressionPrinter{

	public String print(EolElement e, EolElementPrinterFactory f) {
		RealExpression exp = (RealExpression) e;
		return exp.getVal() + "";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof RealExpression;
	}
}
