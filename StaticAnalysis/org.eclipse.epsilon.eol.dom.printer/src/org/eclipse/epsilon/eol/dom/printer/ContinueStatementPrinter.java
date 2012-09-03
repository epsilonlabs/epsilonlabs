package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class ContinueStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		return "continue;";
	}

}
