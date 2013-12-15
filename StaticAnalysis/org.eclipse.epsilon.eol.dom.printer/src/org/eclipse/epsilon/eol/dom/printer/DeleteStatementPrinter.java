package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DeleteStatement;
import org.eclipse.epsilon.eol.dom.DomElement;

public class DeleteStatementPrinter extends StatementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		DeleteStatement statement = (DeleteStatement) e;
		String result = "delete";
		if (statement.getDeleted() != null) {
			result += " " + f.print((DomElement) statement.getDeleted());
		}
		result += ";";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof DeleteStatement;
	}

}
