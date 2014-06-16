package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.OrderedSetExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OrderedSetExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class OrderedSetExpressionPrinter extends OrderedSetExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(OrderedSetExpression orderedSetExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "OrderedSet{";
		if (orderedSetExpression.getParameterList() != null) {
			result += controller.visit(orderedSetExpression.getParameterList(), context);
		}
		result += "}";
		return result;
	}

}
