package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class EnumerationLiteralExpressionPrinter extends ExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		EnumerationLiteralExpression exp = (EnumerationLiteralExpression) e;
		String s = "";
		if (exp.getModel() != null) {
			s += f.print((DomElement) exp.getModel()) + "!";
		}
		s += f.print((DomElement) exp.getEnumeration()) + "#" + f.print((DomElement) exp.getLiteral());
		return s;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof EnumerationLiteralExpression;
	}

}
