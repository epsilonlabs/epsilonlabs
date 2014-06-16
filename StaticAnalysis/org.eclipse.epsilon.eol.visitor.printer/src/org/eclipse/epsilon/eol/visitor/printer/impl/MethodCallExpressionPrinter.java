package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MethodCallExpressionVisitor;

public class MethodCallExpressionPrinter extends MethodCallExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if(methodCallExpression.getTarget() != null)
		{
			result += controller.visit(methodCallExpression.getTarget(), context);
			result += methodCallExpression.getIsArrow().isVal() ? "->" : ".";
		}
		result += controller.visit(methodCallExpression.getMethod(), context) + "(";
		
		if(methodCallExpression.getArguments().size() != 0)
		{
			result += controller.visit(methodCallExpression.getArguments().get(0), context);
			for(int i = 1; i < methodCallExpression.getArguments().size(); i ++)
			{
				result += ", " + controller.visit(methodCallExpression.getArguments().get(i), context);
			}
		}
		else {
			result += ")";
		}
		return result;
	}

}
