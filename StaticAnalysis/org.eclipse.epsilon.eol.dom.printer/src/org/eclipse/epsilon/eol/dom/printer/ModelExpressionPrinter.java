package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ModelExpression;

public class ModelExpressionPrinter extends NameExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ModelExpression expression = (ModelExpression) e;
		return expression.getName();
	}

}
