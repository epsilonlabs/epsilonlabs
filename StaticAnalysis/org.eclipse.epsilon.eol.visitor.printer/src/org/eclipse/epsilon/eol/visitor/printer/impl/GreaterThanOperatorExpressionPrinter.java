package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.GreaterThanOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class GreaterThanOperatorExpressionPrinter extends GreaterThanOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			GreaterThanOperatorExpression greaterThanOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(greaterThanOperatorExpression.getLhs(), context);
		result += " > ";
		result += controller.visit(greaterThanOperatorExpression.getRhs(), context);
		return result;
	}

}
