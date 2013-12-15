package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.AbortStatement;
import org.eclipse.epsilon.eol.dom.DomElement;

public class AbortStatementPrinter extends StatementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		return "abort;";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AbortStatement;
	}

}
