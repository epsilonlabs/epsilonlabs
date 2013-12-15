package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NewExpression;

public class NewExpressionPrinter extends ExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		NewExpression expression = (NewExpression) e;
		String result = "";
		result += "new " + f.print((DomElement) expression.getResolvedType());
		if(expression.getParameters().size() != 0)
		{
			result += "(" + f.print(expression.getParameters(), ", ") + ")";
		}
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NewExpression;
	}

}
