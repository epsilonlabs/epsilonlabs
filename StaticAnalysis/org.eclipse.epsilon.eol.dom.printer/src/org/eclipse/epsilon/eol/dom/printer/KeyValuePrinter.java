package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.KeyValue;

public class KeyValuePrinter extends EolElementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		KeyValue keyValue = (KeyValue) e;
		String result = "";
		result += f.print((DomElement) keyValue.getKey()) + " = " + f.print((DomElement) keyValue.getValue());
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof KeyValue;
	}

}
