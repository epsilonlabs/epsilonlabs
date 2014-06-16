package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.RealTypeVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class RealTypePrinter extends RealTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(RealType realType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		
		return "Real";
	}

}
