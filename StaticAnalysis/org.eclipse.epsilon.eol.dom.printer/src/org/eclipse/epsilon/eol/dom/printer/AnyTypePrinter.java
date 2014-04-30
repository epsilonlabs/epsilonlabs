package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class AnyTypePrinter extends TypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "Any";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AnyType;
	}

}
