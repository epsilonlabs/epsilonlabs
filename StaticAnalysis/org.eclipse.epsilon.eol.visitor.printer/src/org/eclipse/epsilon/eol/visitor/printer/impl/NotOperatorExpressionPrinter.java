package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.NotOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NotOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class NotOperatorExpressionPrinter extends NotOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(NotOperatorExpression notOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "not " + controller.visit(notOperatorExpression.getExpr(), context);
		return result;
	}

}
