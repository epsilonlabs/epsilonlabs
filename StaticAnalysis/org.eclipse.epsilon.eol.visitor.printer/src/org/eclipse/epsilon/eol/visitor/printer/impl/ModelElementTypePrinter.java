package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelElementTypeVisitor;

public class ModelElementTypePrinter extends ModelElementTypeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ModelElementType modelElementType,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if(modelElementType.getModelName() != null)
		{
			result = modelElementType.getModelName() + "!" + modelElementType.getElementName();
		}
		else {
			result = modelElementType.getElementName();
		}
		return result;
	}

}
