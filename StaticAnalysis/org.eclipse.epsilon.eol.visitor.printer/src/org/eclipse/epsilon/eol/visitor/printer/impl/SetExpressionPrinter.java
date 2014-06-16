package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.SetExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SetExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class SetExpressionPrinter extends SetExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(SetExpression setExpression, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "Set{";
		if (setExpression.getParameterList() != null) {
			result += controller.visit(setExpression.getParameterList(), context);
		}
		result += "}";
		return result;
	}

}
