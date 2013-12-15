package org.eclipse.epsilon.eol.dom.printer;


import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.OrderedSetExpression;

public class OrderedSetExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		OrderedSetExpression set = (OrderedSetExpression)e;
		String result = "OrderedSet{" + f.print((DomElement) set.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OrderedSetExpression;
	}

}
