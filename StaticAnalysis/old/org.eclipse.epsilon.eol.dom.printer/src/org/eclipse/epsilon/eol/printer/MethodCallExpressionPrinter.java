package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class MethodCallExpressionPrinter extends FeatureCallExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		MethodCallExpression expression = (MethodCallExpression) e;
		String result = "";
		if(expression.getTarget() != null)
		{
			result += f.print((EolElement) expression.getTarget());
			result += expression.getIsArrow().isVal() ? "->" : ".";;
		}
		
		result += f.print((EolElement) expression.getMethod()) + "(";
		if(expression.getArguments().size() != 0)
		{
			result += f.print(expression.getArguments(), ",") + ")";
		}
		else {
			result += ")";
		}
		
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof MethodCallExpression;
	}
	
	
	
}
