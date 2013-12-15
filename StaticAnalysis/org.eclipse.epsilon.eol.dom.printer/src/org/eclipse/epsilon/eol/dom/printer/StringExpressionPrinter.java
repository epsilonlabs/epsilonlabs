package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class StringExpressionPrinter extends PrimitiveExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		return "\'" + ((StringExpression) e).getVal() + "\'";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof StringExpression;
	}

	

}
