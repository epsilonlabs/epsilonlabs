package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class FOLMethodCallExpressionPrinter extends FOLMethodCallExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if(fOLMethodCallExpression.getTarget() != null)
		{
			result += controller.visit(fOLMethodCallExpression.getTarget(), context);
			result += fOLMethodCallExpression.getIsArrow().isVal() ? "->" : ".";
		}
		result += controller.visit(fOLMethodCallExpression.getMethod(), context);
		result += "(" + controller.visit(fOLMethodCallExpression.getIterator(), context) + "|" + controller.visit(fOLMethodCallExpression.getCondition(), context) + ")";
		return result;
	}

}
