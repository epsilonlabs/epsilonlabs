package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelDeclarationParameterVisitor;

public class ModelDeclarationParameterPrinter extends ModelDeclarationParameterVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ModelDeclarationParameter modelDeclarationParameter,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = controller.visit(modelDeclarationParameter.getName(), context) + " = " + controller.visit(modelDeclarationParameter.getValue(), context); 
		return result;
	}


}
