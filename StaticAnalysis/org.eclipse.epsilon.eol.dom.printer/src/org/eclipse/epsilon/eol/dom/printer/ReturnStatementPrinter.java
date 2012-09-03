package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class ReturnStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		String r = "return";
		ReturnStatement s = (ReturnStatement) e;
		if (s.getReturned() != null) {
			r += " " + f.print((DomElement) s.getReturned());
		}
		r += ";";
		return r;
		
	}

}
