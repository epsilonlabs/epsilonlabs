package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class NotOperatorExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		NotOperatorExpression ex = (NotOperatorExpression) e;
		return "(not " + f.print((DomElement) ex.getExpr()) + ")";
	}
	
}
