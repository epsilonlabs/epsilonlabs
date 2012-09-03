package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class BooleanExpressionPrinter implements PrimitiveExpressionPrinter{

	public String print(DomElement e, DomElementPrinterFactory f) {
		BooleanExpression exp = (BooleanExpression) e;
		return exp.getVal() + "";
	}
}
