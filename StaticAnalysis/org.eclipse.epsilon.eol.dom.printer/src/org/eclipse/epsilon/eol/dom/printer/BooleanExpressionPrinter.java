package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class BooleanExpressionPrinter extends PrimitiveExpressionPrinter{

	public String print(DomElement e, EolElementPrinterFactory f) {
		BooleanExpression exp = (BooleanExpression) e;
		return exp.isVal() + "";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BooleanExpression;
	}
}
