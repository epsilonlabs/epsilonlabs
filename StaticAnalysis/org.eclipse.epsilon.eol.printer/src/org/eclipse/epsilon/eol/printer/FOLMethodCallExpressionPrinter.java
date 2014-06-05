package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class FOLMethodCallExpressionPrinter extends FeatureCallExpressionPrinter{
	
	public String print(EolElement e, EolElementPrinterFactory f) {
		FOLMethodCallExpression expression = (FOLMethodCallExpression) e;
		String result = "";
		if(expression.getTarget() != null)
		{
			result += f.print((EolElement) expression.getTarget());
			result += expression.getIsArrow().isVal() ? "->" : ".";
		}
		result += f.print((EolElement) expression.getMethod());
		result += "(" + f.print(expression.getIterator()) + " | " + f.print(expression.getCondition()) + ")";
		
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof FOLMethodCallExpression;
	}

}
