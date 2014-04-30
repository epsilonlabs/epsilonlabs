package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public abstract class EolElementPrinter {
	
	public abstract String print(EolElement e, EolElementPrinterFactory f);
	
	@Deprecated
	public abstract boolean appliesTo(EolElement dom);
}
