package org.eclipse.epsilon.eol.printer;


import org.eclipse.epsilon.eol.metamodel.*;

public class OrderedSetExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		OrderedSetExpression set = (OrderedSetExpression)e;
		String result = "OrderedSet{" + f.print((EolElement) set.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OrderedSetExpression;
	}

}
