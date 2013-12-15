package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.DomElement;

public class AnyTypePrinter extends TypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Any";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AnyType;
	}

}
