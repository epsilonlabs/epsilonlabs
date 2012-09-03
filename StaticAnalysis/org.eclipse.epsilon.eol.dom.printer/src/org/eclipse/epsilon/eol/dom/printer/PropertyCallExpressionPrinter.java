package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class PropertyCallExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		PropertyCallExpression exp = (PropertyCallExpression) e;
		return f.print((DomElement) exp.getTarget()) + "." + f.escapeName(exp.isExtended() ? "~" + exp.getProperty() :exp.getProperty());
		//return f.print(exp.getTarget()) + "." + (exp.isExtended() ? "~" + exp.getProperty() :exp.getProperty());
	}

}
