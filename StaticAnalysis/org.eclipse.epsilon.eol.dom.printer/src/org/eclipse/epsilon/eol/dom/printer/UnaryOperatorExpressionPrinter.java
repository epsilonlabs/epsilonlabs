package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public abstract class UnaryOperatorExpressionPrinter extends OperatorExpressionPrinter{

	protected boolean prefixed;
	
	public String print(DomElement e, EolElementPrinterFactory f) {
		UnaryOperatorExpression exp = (UnaryOperatorExpression) e;
		if(prefixed)
		{
			return getOperatorSymbol() + f.print((DomElement) exp.getExpr()) ;
		}
		else
		{
			return f.print((DomElement) exp.getExpr()) + getOperatorSymbol();
		}
	}
	
	protected abstract String getOperatorSymbol();
}
