package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class PropertyCallExpressionPrinter extends FeatureCallExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		PropertyCallExpression expression = (PropertyCallExpression) e;
		String result = "";
		result += f.print((EolElement) expression.getTarget());
		result += expression.getIsArrow().isVal() ? "->" : ".";
		//result += expression.getExtended().isVal() ? "~" : "";
		result += f.print((EolElement) expression.getProperty());
		
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof PropertyCallExpression;
	}

}
