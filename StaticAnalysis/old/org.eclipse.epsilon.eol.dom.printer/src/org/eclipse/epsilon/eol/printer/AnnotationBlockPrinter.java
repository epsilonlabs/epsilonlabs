package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class AnnotationBlockPrinter extends EolElementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		AnnotationBlock block = (AnnotationBlock) e;
		String result = "";
		result += f.print(block.getSimpleAnnotations());
		result += f.newline();
		result += f.print(block.getExecutableAnnotations());
		result += f.newline();
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AnnotationBlock;
	}

}
