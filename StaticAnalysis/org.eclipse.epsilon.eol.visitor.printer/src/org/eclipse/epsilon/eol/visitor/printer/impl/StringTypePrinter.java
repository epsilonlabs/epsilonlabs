package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.StringTypeVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class StringTypePrinter extends StringTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(StringType stringType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		
		return "String";
	}

}
