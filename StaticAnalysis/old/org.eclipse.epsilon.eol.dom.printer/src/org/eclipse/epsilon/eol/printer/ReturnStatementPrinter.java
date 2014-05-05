package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class ReturnStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		ReturnStatement s = (ReturnStatement) e;
		String result = "return";
		if (s.getReturned() != null) {
			result += " " + f.print((EolElement) s.getReturned());
		}
		result += ";";
		return result;
		
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ReturnStatement;
	}

}
