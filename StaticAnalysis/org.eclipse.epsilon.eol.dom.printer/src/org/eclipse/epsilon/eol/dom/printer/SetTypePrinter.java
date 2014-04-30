package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class SetTypePrinter extends CollectionTypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "Set";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SetType;
	}

}
