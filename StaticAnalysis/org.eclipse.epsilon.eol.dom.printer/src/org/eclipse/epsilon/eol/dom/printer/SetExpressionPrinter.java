package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class SetExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		SetExpression set = (SetExpression)e;
		String result = "Set{" + f.print((EolElement)set.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SetExpression;
	}

}
