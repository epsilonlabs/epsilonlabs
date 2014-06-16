package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.MinusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MinusOperatorExpressionVisitor;

public class MinusOperatorExpressionPrinter extends MinusOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(MinusOperatorExpression minusOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(minusOperatorExpression.getLhs(), context);
		result += " - ";
		result += controller.visit(minusOperatorExpression.getRhs(), context);
		return result;
	}

}
