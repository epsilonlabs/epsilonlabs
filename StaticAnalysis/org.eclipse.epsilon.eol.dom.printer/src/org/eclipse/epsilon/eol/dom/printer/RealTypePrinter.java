package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.RealType;

public class RealTypePrinter extends PrimitiveTypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Real";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof RealType;
	}

}
