package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class NameExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		NameExpression exp = (NameExpression) e;
		return f.escapeName(exp.getName());
		//return (exp.getName());
	}

}
