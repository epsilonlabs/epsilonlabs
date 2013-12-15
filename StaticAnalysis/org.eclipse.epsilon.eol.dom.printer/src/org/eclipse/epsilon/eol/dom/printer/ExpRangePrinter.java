package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ExpRange;

public class ExpRangePrinter extends CollectionInitValuePrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ExpRange expRange = (ExpRange) e;
		String result = "";
		result += f.print((DomElement) expRange.getStart()) + ".." + f.print((DomElement) expRange.getEnd());
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExpRange;
	}

}
