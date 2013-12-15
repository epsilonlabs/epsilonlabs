package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ExecutableAnnotation;

public class ExecutableAnnotationPrinter extends AnnotationPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ExecutableAnnotation annotation = (ExecutableAnnotation) e;
		String result = "$" + f.print((DomElement) annotation.getName()) + " " + f.print((DomElement) annotation.getExpression());
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExecutableAnnotation;
	}

}
