package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IntegerTypeVisitor;

public class IntegerTypePrinter extends IntegerTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(IntegerType integerType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		return "Integer";
	}

}
