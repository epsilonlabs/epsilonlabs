package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ModelDeclarationParameterPrinter extends EolElementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ModelDeclarationParameter parameter = (ModelDeclarationParameter) e;
		String result = f.print((EolElement) parameter.getName()) + " = " + f.print((EolElement) parameter.getValue());
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ModelDeclarationParameter;
	}

}
