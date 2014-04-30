package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class TransactionStatementPrinter extends StatementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		TransactionStatement statement = (TransactionStatement) e;
		String result = "transaction";
		if(statement.getNames() != null) {
			result += f.print(statement.getNames(), ",");
		}
		
		if(statement.getBody() != null)
		{
			result += f.print((EolElement) statement.getBody());
		}
		
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof TransactionStatement;
	}

}
