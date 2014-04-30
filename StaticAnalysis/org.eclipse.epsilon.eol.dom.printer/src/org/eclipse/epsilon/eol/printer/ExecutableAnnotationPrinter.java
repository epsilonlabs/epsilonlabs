package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ExecutableAnnotationPrinter extends AnnotationPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ExecutableAnnotation annotation = (ExecutableAnnotation) e;
		String result = "$" + f.print((EolElement) annotation.getName()) + " " + f.print((EolElement) annotation.getExpression());
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExecutableAnnotation;
	}

}
