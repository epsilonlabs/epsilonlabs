package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.BagExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.BagExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class BagExpressionPrinter extends BagExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(BagExpression bagExpression, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "Bag{";
		if (bagExpression.getParameterList() != null) {
			result += controller.visit(bagExpression.getParameterList(), context);
		}
		result += "}";
		return result;
	}

}
