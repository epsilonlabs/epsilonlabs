package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.visitor.AnyTypeVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class AnyTypePrinter extends AnyTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(AnyType anyType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		return "Any";
	}

}
