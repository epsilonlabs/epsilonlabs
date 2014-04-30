package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class BagTypePrinter extends CollectionTypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "Bag";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BagType;
	}

}
