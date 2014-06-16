package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NotEqualsOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class NotEqualsOperatorExpressionPrinter extends NotEqualsOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			NotEqualsOperatorExpression notEqualsOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(notEqualsOperatorExpression.getLhs(), context);
		result += " <> ";
		result += controller.visit(notEqualsOperatorExpression.getRhs(), context);
		return result;
	}

}
