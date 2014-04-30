package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ModelElementTypePrinter extends TypePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ModelElementType type = (ModelElementType) e;
		String result = "";
		if(type.getModelName() != null)
		{
			result = type.getModelName() + "!" + type.getElementName();
		}
		else {
			result = type.getElementName();
		}
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ModelElementType;
	}

}
