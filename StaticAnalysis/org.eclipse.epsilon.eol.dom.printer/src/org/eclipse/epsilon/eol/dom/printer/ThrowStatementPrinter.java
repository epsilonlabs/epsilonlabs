package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ThrowStatementPrinter extends StatementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ThrowStatement statement = (ThrowStatement) e;
		String result = "throw";
		if (statement.getThrown() != null) {
			result += " " + f.print((EolElement) statement.getThrown());
		}
		result += ";";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ThrowStatement;
	}

}
