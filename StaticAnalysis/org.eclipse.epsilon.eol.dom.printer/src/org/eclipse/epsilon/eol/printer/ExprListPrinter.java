package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ExprListPrinter extends CollectionInitValuePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ExprList list = (ExprList) e;
		String result = "";
		result += f.print(list.getExpressions(), ",");
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExprList;
	}

}
