package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.IntegerType;

public class IntegerTypePrinter extends PrimitiveTypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Integer";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof IntegerType;
	}

}
