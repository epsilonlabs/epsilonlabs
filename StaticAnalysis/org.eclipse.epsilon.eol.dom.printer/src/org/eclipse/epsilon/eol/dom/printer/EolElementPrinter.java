package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public abstract class EolElementPrinter {
	
	public abstract String print(DomElement e, EolElementPrinterFactory f);
	
	@Deprecated
	public abstract boolean appliesTo(DomElement dom);
}
