package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class BreakStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		return "break;";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BreakStatement;
	}

}
