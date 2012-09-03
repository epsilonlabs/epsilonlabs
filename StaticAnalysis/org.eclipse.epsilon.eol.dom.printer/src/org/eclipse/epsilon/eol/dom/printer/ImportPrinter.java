package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class ImportPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		Import imp = (Import) e;
		return "import " + f.addQuotes(imp.getImported()) + ";";
	}

}
