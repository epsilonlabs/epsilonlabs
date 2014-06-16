package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.LessThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.LessThanOrEqualToOperatorExpressionVisitor;

public class LessThanOrEqualToOperatorExpressionPrinter extends LessThanOrEqualToOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			LessThanOrEqualToOperatorExpression lessThanOrEqualToOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(lessThanOrEqualToOperatorExpression.getLhs(), context);
		result += " <= ";
		result += controller.visit(lessThanOrEqualToOperatorExpression.getRhs(), context);
		return result;
	}

}
