package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class AssignmentStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		AssignmentStatement s = (AssignmentStatement) e;
		return f.print((DomElement) s.getLhs()) + " = " + f.print((DomElement) s.getRhs()) + ";";
	}

}
