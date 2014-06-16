package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.GreaterThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.GreaterThanOrEqualToOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class GreaterThanOrEqualToOperatorExpressionPrinter extends GreaterThanOrEqualToOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			GreaterThanOrEqualToOperatorExpression greaterThanOrEqualToOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(greaterThanOrEqualToOperatorExpression.getLhs(), context);
		result += " >= ";
		result += controller.visit(greaterThanOrEqualToOperatorExpression.getRhs(), context);
		return result;
	}

}
