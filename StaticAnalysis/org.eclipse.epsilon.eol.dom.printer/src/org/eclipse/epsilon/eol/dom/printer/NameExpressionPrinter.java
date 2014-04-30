package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class NameExpressionPrinter extends ExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		NameExpression exp = (NameExpression) e;
		return exp.getName();
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NameExpression;
	}

}
