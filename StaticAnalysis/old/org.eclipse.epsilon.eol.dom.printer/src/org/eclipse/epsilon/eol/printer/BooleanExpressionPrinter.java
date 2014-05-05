package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class BooleanExpressionPrinter extends PrimitiveExpressionPrinter{

	public String print(EolElement e, EolElementPrinterFactory f) {
		BooleanExpression exp = (BooleanExpression) e;
		return exp.isVal() + "";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BooleanExpression;
	}
}
