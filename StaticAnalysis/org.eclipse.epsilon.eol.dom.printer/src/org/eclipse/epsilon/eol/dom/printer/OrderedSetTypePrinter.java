package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.OrderedSetType;

public class OrderedSetTypePrinter extends CollectionTypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "OrderedSet";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OrderedSetType;
	}

}
