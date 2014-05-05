package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class NewExpressionPrinter extends ExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		NewExpression expression = (NewExpression) e;
		String result = "";
		result += "new " + f.print((EolElement) expression.getResolvedType());
		if(expression.getParameters().size() != 0)
		{
			result += "(" + f.print(expression.getParameters(), ", ") + ")";
		}
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof NewExpression;
	}

}
