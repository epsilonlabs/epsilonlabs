package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ImpliesOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ImpliesOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ImpliesOperatorExpressionPrinter extends ImpliesOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ImpliesOperatorExpression impliesOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(impliesOperatorExpression.getLhs(), context);
		result += " imlpies ";
		result += controller.visit(impliesOperatorExpression.getRhs(), context);
		return result;
	}

}
