package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class ExpressionStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		ExpressionStatement s = (ExpressionStatement) e;
		return f.print((DomElement) s.getExpression()) + ";";
	}

}
