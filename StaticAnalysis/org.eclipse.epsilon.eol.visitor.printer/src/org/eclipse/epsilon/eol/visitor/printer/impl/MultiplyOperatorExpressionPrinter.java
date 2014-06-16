package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.MultiplyOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MultiplyOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class MultiplyOperatorExpressionPrinter extends MultiplyOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(MultiplyOperatorExpression multiplyOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(multiplyOperatorExpression.getLhs(), context);
		result += " * ";
		result += controller.visit(multiplyOperatorExpression.getRhs(), context);
		return result;
	}

}
