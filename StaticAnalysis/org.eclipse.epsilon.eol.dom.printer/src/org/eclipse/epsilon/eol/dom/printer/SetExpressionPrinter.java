package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SetExpression;

public class SetExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		SetExpression set = (SetExpression)e;
		String result = "Set{" + f.print((DomElement)set.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SetExpression;
	}

}
