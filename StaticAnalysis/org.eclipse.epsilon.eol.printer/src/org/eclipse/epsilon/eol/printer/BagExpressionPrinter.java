package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class BagExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		BagExpression bag = (BagExpression)e;
		String result = "Bag{" + f.print((EolElement) bag.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BagExpression;
	}

}
