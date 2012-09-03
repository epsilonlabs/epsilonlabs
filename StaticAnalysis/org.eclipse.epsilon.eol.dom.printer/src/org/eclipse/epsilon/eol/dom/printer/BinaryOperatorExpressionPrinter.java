package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public abstract class BinaryOperatorExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		BinaryOperatorExpression exp = (BinaryOperatorExpression) e;
		return "(" + f.print((DomElement) exp.getLhs()) + " " + getOperatorSymbol() + " " + f.print((DomElement) exp.getRhs()) + ")";
	}
	
	protected abstract String getOperatorSymbol();
	
}
