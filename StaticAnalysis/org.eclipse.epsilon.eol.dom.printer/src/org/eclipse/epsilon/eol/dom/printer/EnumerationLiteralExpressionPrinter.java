package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class EnumerationLiteralExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		String s = "";
		EnumerationLiteralExpression ex = (EnumerationLiteralExpression) e;
		if (ex.getModel() != null) {
			s = ex.getModel() + "!";
		}
		s = s + ex.getEnumeration() + "#" + ex.getLiteral();
		return s;
	}

}
