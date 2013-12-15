package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.BagExpression;
import org.eclipse.epsilon.eol.dom.DomElement;

public class BagExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		BagExpression bag = (BagExpression)e;
		String result = "Bag{" + f.print((DomElement) bag.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BagExpression;
	}

}
