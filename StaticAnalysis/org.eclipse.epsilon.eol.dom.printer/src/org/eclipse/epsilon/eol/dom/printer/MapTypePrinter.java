package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class MapTypePrinter extends TypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "Map";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof MapType;
	}

}
