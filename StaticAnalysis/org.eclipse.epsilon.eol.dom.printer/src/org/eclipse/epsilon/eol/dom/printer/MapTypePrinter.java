package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.MapType;

public class MapTypePrinter extends TypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Map";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof MapType;
	}

}
