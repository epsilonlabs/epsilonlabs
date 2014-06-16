package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.OrderedSetType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OrderedSetTypeVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class OrderedSetTypePrinter extends OrderedSetTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(OrderedSetType orderedSetType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (orderedSetType.getContentType() == null) {
			result = "OrderedSet";
		}
		else {
			result += "OrderedSet(" + controller.visit(orderedSetType.getContentType(), context) + ")";
		}
		return result;
	}

}
