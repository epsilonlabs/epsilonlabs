package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class OrderedSetTypePrinter extends CollectionTypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "OrderedSet";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OrderedSetType;
	}

}
