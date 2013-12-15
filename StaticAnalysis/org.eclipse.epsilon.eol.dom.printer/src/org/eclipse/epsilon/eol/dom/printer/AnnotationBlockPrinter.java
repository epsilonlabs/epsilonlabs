package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.AnnotationBlock;
import org.eclipse.epsilon.eol.dom.DomElement;

public class AnnotationBlockPrinter extends EolElementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		AnnotationBlock block = (AnnotationBlock) e;
		String result = "";
		result += f.print(block.getSimpleAnnotations());
		result += f.newline();
		result += f.print(block.getExecutableAnnotations());
		result += f.newline();
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AnnotationBlock;
	}

}
