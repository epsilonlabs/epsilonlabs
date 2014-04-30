package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ExpRangePrinter extends CollectionInitValuePrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ExpRange expRange = (ExpRange) e;
		String result = "";
		result += f.print((EolElement) expRange.getStart()) + ".." + f.print((EolElement) expRange.getEnd());
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExpRange;
	}

}
