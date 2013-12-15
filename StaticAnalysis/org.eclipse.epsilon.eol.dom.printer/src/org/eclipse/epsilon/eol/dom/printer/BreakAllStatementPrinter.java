package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class BreakAllStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		return "breakAll;";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BreakAllStatement;
	}

}
