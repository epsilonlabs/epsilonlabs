package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.ExecutableAnnotation;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.metamodel.visitor.AnnotationBlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class AnnotationBlockPrinter extends AnnotationBlockVisitor<PrinterContext, Object>{

	@Override
	public Object visit(AnnotationBlock annotationBlock,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (annotationBlock.getSimpleAnnotations() != null) {
			for(SimpleAnnotation sa : annotationBlock.getSimpleAnnotations())
			{
				result += controller.visit(sa, context);
			}
		}
		if (annotationBlock.getExecutableAnnotations() != null) {
			for(ExecutableAnnotation ea: annotationBlock.getExecutableAnnotations())
			{
				result += controller.visit(ea, context);
			}
		}
		return result;
	}

}
