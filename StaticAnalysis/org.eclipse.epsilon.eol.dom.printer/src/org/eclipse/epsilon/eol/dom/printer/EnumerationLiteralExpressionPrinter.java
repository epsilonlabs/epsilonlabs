package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class EnumerationLiteralExpressionPrinter extends ExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		EnumerationLiteralExpression exp = (EnumerationLiteralExpression) e;
		String s = "";
		if (exp.getModel() != null) {
			s += f.print((EolElement) exp.getModel()) + "!";
		}
		s += f.print((EolElement) exp.getEnumeration()) + "#" + f.print((EolElement) exp.getLiteral());
		return s;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof EnumerationLiteralExpression;
	}

}
