package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.DivideOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.DivideOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class DivideOperatorExpressionPrinter extends DivideOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(DivideOperatorExpression divideOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(divideOperatorExpression.getLhs(), context);
		result += " / ";
		result += controller.visit(divideOperatorExpression.getRhs(), context);
		return result;
	}

}
