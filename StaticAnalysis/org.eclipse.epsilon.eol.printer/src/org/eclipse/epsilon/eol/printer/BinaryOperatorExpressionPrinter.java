package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public abstract class BinaryOperatorExpressionPrinter extends OperatorExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		BinaryOperatorExpression exp = (BinaryOperatorExpression) e;
		return "(" + f.print((EolElement) exp.getLhs()) + " " + getOperatorSymbol() + " " + f.print((EolElement) exp.getRhs()) + ")";
	}
	
	protected abstract String getOperatorSymbol();
	
}
