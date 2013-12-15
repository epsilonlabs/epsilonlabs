package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ExprList;

public class ExprListPrinter extends CollectionInitValuePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ExprList list = (ExprList) e;
		String result = "";
		result += f.print(list.getExpressions(), ",");
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExprList;
	}

}
