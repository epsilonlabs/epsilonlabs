package org.eclipse.epsilon.eol.visitor.printer.impl;

import java.util.Iterator;

import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SimpleAnnotationVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class SimpleAnnotationPrinter extends SimpleAnnotationVisitor<PrinterContext, Object>{

	@Override
	public Object visit(SimpleAnnotation simpleAnnotation,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "@" + controller.visit(simpleAnnotation.getName(), context);
		if (simpleAnnotation.getValues() != null && simpleAnnotation.getValues().size() != 0) {
			Iterator<StringExpression> iterator = simpleAnnotation.getValues().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += " ";
				}
			}
		}
		return result;
	}

}
