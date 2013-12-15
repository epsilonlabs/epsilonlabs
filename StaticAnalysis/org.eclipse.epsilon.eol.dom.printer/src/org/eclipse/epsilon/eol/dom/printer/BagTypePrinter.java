package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.BagType;
import org.eclipse.epsilon.eol.dom.DomElement;

public class BagTypePrinter extends CollectionTypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Bag";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BagType;
	}

}
