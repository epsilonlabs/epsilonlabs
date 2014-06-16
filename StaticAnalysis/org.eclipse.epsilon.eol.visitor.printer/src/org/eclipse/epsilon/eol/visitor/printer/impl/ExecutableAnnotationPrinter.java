package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ExecutableAnnotation;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ExecutableAnnotationVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ExecutableAnnotationPrinter extends ExecutableAnnotationVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ExecutableAnnotation executableAnnotation,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "$" + controller.visit(executableAnnotation.getName(), context) + " " + controller.visit(executableAnnotation.getExpression(), context);
		return result;
	}

}
