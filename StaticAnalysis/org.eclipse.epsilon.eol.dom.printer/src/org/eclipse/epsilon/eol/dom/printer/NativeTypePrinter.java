package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class NativeTypePrinter extends TypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		NativeType type = (NativeType) e;
		String result = "native(" + f.print((EolElement) type.getNativeExpression()) + ")";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NativeType;
	}

}
