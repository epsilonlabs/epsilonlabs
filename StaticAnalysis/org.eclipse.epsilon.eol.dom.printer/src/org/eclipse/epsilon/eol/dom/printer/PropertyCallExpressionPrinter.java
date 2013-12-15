package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class PropertyCallExpressionPrinter extends FeatureCallExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		PropertyCallExpression expression = (PropertyCallExpression) e;
		String result = "";
		result += f.print((DomElement) expression.getTarget());
		result += expression.getIsArrow().isVal() ? "->" : ".";
		//result += expression.getExtended().isVal() ? "~" : "";
		result += f.print((DomElement) expression.getProperty());
		
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof PropertyCallExpression;
	}

}
