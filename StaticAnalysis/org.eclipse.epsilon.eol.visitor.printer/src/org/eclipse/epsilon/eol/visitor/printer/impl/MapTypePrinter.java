package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.MapType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MapTypeVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class MapTypePrinter extends MapTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(MapType mapType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		return "Map";
	}

}
