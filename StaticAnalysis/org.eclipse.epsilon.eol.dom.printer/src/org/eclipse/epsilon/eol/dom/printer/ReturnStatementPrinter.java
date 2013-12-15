package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class ReturnStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		ReturnStatement s = (ReturnStatement) e;
		String result = "return";
		if (s.getReturned() != null) {
			result += " " + f.print((DomElement) s.getReturned());
		}
		result += ";";
		return result;
		
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ReturnStatement;
	}

}
