package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public abstract class BinaryOperatorExpressionPrinter extends OperatorExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		BinaryOperatorExpression exp = (BinaryOperatorExpression) e;
		return "(" + f.print((DomElement) exp.getLhs()) + " " + getOperatorSymbol() + " " + f.print((DomElement) exp.getRhs()) + ")";
	}
	
	protected abstract String getOperatorSymbol();
	
}
