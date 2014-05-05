package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class RealTypePrinter extends PrimitiveTypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "Real";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof RealType;
	}

}
