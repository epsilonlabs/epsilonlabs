package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.SequenceExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SequenceExpressionVisitor;

public class SequenceExpressionPrinter extends SequenceExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(SequenceExpression sequenceExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "Sequence{";
		if (sequenceExpression.getParameterList() != null) {
			result += controller.visit(sequenceExpression.getParameterList(), context);
		}
		result += "}";
		return result;
	}

}
