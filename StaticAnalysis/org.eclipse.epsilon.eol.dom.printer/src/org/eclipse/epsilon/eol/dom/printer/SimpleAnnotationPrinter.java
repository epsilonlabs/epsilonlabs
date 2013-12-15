package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SimpleAnnotation;

public class SimpleAnnotationPrinter extends AnnotationPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		SimpleAnnotation annotation = (SimpleAnnotation) e;
		String result = "@" + f.print((DomElement) annotation.getName()) + " " + f.print(annotation.getValues(), " ");
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SimpleAnnotation;
	}

}
