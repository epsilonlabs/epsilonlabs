package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NativeType;

public class NativeTypePrinter extends TypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		NativeType type = (NativeType) e;
		String result = "native(" + f.print((DomElement) type.getNativeExpression()) + ")";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NativeType;
	}

}
