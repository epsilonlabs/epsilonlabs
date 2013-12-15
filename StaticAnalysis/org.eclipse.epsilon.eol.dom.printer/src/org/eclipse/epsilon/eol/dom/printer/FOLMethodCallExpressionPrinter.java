package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class FOLMethodCallExpressionPrinter extends FeatureCallExpressionPrinter{
	
	public String print(DomElement e, EolElementPrinterFactory f) {
		FOLMethodCallExpression expression = (FOLMethodCallExpression) e;
		String result = "";
		if(expression.getTarget() != null)
		{
			result += f.print((DomElement) expression.getTarget());
			result += expression.getIsArrow().isVal() ? "->" : ".";
		}
		result += f.print((DomElement) expression.getMethod());
		result += "(" + f.print(expression.getIterators(), ",") + " | " + f.print(expression.getConditions(), ",") + ")";
		
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof FOLMethodCallExpression;
	}

}
