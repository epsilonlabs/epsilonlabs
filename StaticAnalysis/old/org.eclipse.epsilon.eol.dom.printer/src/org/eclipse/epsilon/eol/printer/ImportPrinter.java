package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class ImportPrinter extends EolElementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		Import imported = (Import) e;
		return "import " + "\"" + f.print((EolElement) imported.getImported()) + "\"" + ";";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof Import;
	}

}
