package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ModelDeclarationParameter;

public class ModelDeclarationParameterPrinter extends EolElementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ModelDeclarationParameter parameter = (ModelDeclarationParameter) e;
		String result = f.print((DomElement) parameter.getName()) + " = " + f.print((DomElement) parameter.getValue());
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ModelDeclarationParameter;
	}

}
