package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SequenceExpression;

public class SequenceExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		SequenceExpression sequence = (SequenceExpression)e;
		String result = "Sequence{" + f.print((DomElement) sequence.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SequenceExpression;
	}

}
