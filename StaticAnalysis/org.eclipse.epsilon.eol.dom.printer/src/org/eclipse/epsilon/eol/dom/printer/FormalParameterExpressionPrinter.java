package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class FormalParameterExpressionPrinter extends ExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		FormalParameterExpression expression = (FormalParameterExpression) e;
		String result = "";
		result += f.print((EolElement) expression.getName());
		if(expression.getResolvedType() != null)
		{
			result += " : " + f.print((EolElement) expression.getResolvedType()); 
		}
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof FormalParameterExpression;
	}

}
