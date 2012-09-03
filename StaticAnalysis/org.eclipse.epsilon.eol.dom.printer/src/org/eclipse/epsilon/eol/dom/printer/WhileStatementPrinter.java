package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class WhileStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		WhileStatement s = (WhileStatement) e;
		String r = "while (" + f.print((DomElement) s.getCondition()) + ") {" + f.newline()
			+ f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() + 
			f.whitespace() + "}";
		return r;
	}

}
