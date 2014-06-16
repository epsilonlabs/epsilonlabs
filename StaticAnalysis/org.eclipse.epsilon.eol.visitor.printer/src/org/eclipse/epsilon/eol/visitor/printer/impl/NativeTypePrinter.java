package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.NativeType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NativeTypeVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class NativeTypePrinter extends NativeTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(NativeType nativeType, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "native(" + controller.visit(nativeType.getNativeExpression(), context) + ")";
		return result;
	}

}
