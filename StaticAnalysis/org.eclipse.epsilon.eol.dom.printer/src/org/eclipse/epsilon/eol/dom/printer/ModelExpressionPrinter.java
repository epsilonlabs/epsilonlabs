package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ModelExpressionPrinter extends NameExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ModelExpression expression = (ModelExpression) e;
		return expression.getName();
	}

}
