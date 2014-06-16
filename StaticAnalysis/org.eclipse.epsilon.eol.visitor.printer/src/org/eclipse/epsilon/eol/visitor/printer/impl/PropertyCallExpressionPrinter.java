package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;

public class PropertyCallExpressionPrinter extends PropertyCallExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (propertyCallExpression.getTarget() != null) {
			result += controller.visit(propertyCallExpression.getTarget(), context);
		}
		
		result += propertyCallExpression.getIsArrow().isVal() ? "->" : ".";
		if (propertyCallExpression.getProperty() != null) {
			result += controller.visit(propertyCallExpression.getProperty(), context);
		}
		
		return result;
	}

}
