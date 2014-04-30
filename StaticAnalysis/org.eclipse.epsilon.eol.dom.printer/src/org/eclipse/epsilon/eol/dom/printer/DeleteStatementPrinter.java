package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class DeleteStatementPrinter extends StatementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		DeleteStatement statement = (DeleteStatement) e;
		String result = "delete";
		if (statement.getDeleted() != null) {
			result += " " + f.print((EolElement) statement.getDeleted());
		}
		result += ";";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof DeleteStatement;
	}

}
