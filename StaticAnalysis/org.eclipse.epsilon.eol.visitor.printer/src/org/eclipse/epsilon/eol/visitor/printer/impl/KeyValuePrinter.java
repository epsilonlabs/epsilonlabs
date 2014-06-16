package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.KeyValue;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.KeyValueVisitor;

public class KeyValuePrinter extends KeyValueVisitor<PrinterContext, Object>{

	@Override
	public Object visit(KeyValue keyValue, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(keyValue.getKey(), context) + " = " + controller.visit(keyValue.getValue(), context);
		
		return result;
	}

}
