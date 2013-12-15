package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.TransactionStatement;

public class TransactionStatementPrinter extends StatementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		TransactionStatement statement = (TransactionStatement) e;
		String result = "transaction";
		if(statement.getNames() != null) {
			result += f.print(statement.getNames(), ",");
		}
		
		if(statement.getBody() != null)
		{
			result += f.print((DomElement) statement.getBody());
		}
		
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof TransactionStatement;
	}

}
