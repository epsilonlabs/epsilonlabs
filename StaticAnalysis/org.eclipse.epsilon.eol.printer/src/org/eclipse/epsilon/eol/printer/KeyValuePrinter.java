package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class KeyValuePrinter extends EolElementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		KeyValue keyValue = (KeyValue) e;
		String result = "";
		result += f.print((EolElement) keyValue.getKey()) + " = " + f.print((EolElement) keyValue.getValue());
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof KeyValue;
	}

}
