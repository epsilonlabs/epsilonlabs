package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.TypeImpl;

public class TypePrinter extends EolElementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		// TODO Auto-generated method stub
		return "Type";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom.getClass().equals(TypeImpl.class);
	}

}
