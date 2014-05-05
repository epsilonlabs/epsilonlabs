package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class SimpleAnnotationPrinter extends AnnotationPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		SimpleAnnotation annotation = (SimpleAnnotation) e;
		String result = "@" + f.print((EolElement) annotation.getName()) + " " + f.print(annotation.getValues(), " ");
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SimpleAnnotation;
	}

}
