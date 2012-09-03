package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;

public class IntegerExpressionPrinter implements PrimitiveExpressionPrinter{

	public String print(DomElement e, DomElementPrinterFactory f) {
		IntegerExpression exp = (IntegerExpression) e;
		return exp.getVal() + "";
	}
}
