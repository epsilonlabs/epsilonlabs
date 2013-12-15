package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;

public class IntegerExpressionPrinter extends PrimitiveExpressionPrinter{

	public String print(DomElement e, EolElementPrinterFactory f) {
		IntegerExpression exp = (IntegerExpression) e;
		return exp.getVal() + "";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof IntegerExpression;
	}
}
