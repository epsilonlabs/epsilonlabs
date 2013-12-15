package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class RealExpressionPrinter extends PrimitiveExpressionPrinter{

	public String print(DomElement e, EolElementPrinterFactory f) {
		RealExpression exp = (RealExpression) e;
		return exp.getVal() + "";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof RealExpression;
	}
}
