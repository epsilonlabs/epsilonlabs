package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;




public class ProgramPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		Program p = (Program) e;
		return f.print(p.getImports()) + f.newline() + 
			f.print(p.getStatements()) + f.newline() + 
			f.print(p.getOperations()) + f.newline();
	}

}
