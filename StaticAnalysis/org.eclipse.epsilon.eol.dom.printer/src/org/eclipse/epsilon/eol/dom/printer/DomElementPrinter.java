package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public interface DomElementPrinter {
	
	public String print(DomElement e, DomElementPrinterFactory f);
	
}
