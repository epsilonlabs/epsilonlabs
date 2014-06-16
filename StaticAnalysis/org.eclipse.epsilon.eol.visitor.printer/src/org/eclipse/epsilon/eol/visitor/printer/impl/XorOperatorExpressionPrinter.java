package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.XorOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.XorOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class XorOperatorExpressionPrinter extends XorOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(XorOperatorExpression xorOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(xorOperatorExpression.getLhs(), context);
		result += " xor ";
		result += controller.visit(xorOperatorExpression.getRhs(), context);
		return result;
	}

}
