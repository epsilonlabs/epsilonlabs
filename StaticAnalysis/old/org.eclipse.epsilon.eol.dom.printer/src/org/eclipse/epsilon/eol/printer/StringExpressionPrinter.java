package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class StringExpressionPrinter extends PrimitiveExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		return "\'" + ((StringExpression) e).getVal() + "\'";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof StringExpression;
	}

	

}
