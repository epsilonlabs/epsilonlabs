package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.NegativeOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NegativeOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class NegativeOperatorExpressionPrinter extends NegativeOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(NegativeOperatorExpression negativeOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "-" + controller.visit(negativeOperatorExpression.getExpr(), context);
		return result;
	}

}
