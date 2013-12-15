package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.FormalParameterExpression;

public class FormalParameterExpressionPrinter extends ExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		FormalParameterExpression expression = (FormalParameterExpression) e;
		String result = "";
		result += f.print((DomElement) expression.getName());
		if(expression.getResolvedType() != null)
		{
			result += " : " + f.print((DomElement) expression.getResolvedType()); 
		}
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof FormalParameterExpression;
	}

}
