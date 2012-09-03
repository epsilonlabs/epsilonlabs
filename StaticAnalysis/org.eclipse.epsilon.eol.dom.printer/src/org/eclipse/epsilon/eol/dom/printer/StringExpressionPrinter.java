package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class StringExpressionPrinter implements PrimitiveExpressionPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		return "\'" + ((StringExpression) e).getVal() + "\'";
	}

	

}
