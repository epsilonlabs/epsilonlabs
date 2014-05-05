package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public abstract class UnaryOperatorExpressionPrinter extends OperatorExpressionPrinter{

	protected boolean prefixed;
	
	public String print(EolElement e, EolElementPrinterFactory f) {
		UnaryOperatorExpression exp = (UnaryOperatorExpression) e;
		if(prefixed)
		{
			return getOperatorSymbol() + f.print((EolElement) exp.getExpr()) ;
		}
		else
		{
			return f.print((EolElement) exp.getExpr()) + getOperatorSymbol();
		}
	}
	
	protected abstract String getOperatorSymbol();
}
