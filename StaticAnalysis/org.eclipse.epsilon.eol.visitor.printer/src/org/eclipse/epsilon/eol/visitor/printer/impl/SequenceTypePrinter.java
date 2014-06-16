package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.SequenceType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SequenceTypeVisitor;

public class SequenceTypePrinter extends SequenceTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(SequenceType sequenceType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (sequenceType.getContentType() == null) {
			result = "Sequence";
		}
		else {
			result += "Sequence(" + controller.visit(sequenceType.getContentType(), context) + ")";
		}
		return result;
	}

}
