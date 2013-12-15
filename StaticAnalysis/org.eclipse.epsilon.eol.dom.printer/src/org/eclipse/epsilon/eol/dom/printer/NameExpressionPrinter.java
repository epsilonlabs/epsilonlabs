package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class NameExpressionPrinter extends ExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		NameExpression exp = (NameExpression) e;
		return exp.getName();
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NameExpression;
	}

}
