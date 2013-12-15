package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class ImportPrinter extends EolElementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		Import imported = (Import) e;
		return "import " + "\"" + f.print((DomElement) imported.getImported()) + "\"" + ";";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof Import;
	}

}
