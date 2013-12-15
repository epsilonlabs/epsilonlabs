package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class MethodCallExpressionPrinter extends FeatureCallExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		MethodCallExpression expression = (MethodCallExpression) e;
		String result = "";
		if(expression.getTarget() != null)
		{
			result += f.print((DomElement) expression.getTarget());
			result += expression.getIsArrow().isVal() ? "->" : ".";;
		}
		
		result += f.print((DomElement) expression.getMethod()) + "(";
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
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof MethodCallExpression;
	}
	
	
	
}
