package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.LessThanOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class LessThanOperatorExpressionPrinter extends LessThanOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(LessThanOperatorExpression lessThanOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(lessThanOperatorExpression.getLhs(), context);
		result += " < ";
		result += controller.visit(lessThanOperatorExpression.getRhs(), context);
		return result;
	}

}
