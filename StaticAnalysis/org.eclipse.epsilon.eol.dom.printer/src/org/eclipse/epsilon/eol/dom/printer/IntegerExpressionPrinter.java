package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class IntegerExpressionPrinter extends PrimitiveExpressionPrinter{

	public String print(EolElement e, EolElementPrinterFactory f) {
		IntegerExpression exp = (IntegerExpression) e;
		return exp.getVal() + "";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof IntegerExpression;
	}
}
