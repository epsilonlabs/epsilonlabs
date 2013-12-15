package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SequenceType;

public class SequenceTypePrinter extends CollectionTypePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "Sequence";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SequenceType;
	}

}
