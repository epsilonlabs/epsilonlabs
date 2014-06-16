package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.visitor.BooleanTypeVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class BooleanTypePrinter extends BooleanTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(BooleanType booleanType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		return "Boolean";
	}

}
