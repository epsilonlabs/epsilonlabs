package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ThrowStatement;

public class ThrowStatementPrinter extends StatementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ThrowStatement statement = (ThrowStatement) e;
		String result = "throw";
		if (statement.getThrown() != null) {
			result += " " + f.print((DomElement) statement.getThrown());
		}
		result += ";";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ThrowStatement;
	}

}
