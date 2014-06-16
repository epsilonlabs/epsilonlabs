package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.PlusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class PlusOperatorExpressionPrinter extends PlusOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(plusOperatorExpression.getLhs(), context);
		result += " + ";
		result += controller.visit(plusOperatorExpression.getRhs(), context);
		return result;
	}

}
