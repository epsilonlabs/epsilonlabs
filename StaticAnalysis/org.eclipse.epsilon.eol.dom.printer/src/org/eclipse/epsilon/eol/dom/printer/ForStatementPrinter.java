package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;




public class ForStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		ForStatement s = (ForStatement) e;
		return "for (" + f.print((DomElement) s.getIterator()) + " in " + 
			f.print((DomElement) s.getIterated()) + ") {" + f.newline() + 
			f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() 
			+ f.whitespace() + "}";
	}

}
