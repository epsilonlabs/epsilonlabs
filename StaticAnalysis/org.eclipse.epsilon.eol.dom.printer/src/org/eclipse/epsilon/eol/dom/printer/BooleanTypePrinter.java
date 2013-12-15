package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.BooleanType;
import org.eclipse.epsilon.eol.dom.DomElement;

public class BooleanTypePrinter extends PrimitiveTypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Boolean";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BooleanType;
	}

}
