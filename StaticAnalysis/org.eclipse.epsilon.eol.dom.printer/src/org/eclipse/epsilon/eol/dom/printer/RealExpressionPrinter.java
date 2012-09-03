package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class RealExpressionPrinter implements PrimitiveExpressionPrinter{

	public String print(DomElement e, DomElementPrinterFactory f) {
		RealExpression exp = (RealExpression) e;
		return exp.getVal() + "";
	}
}
