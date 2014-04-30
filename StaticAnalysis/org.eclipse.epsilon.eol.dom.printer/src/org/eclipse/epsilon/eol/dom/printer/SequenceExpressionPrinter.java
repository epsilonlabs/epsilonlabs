package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class SequenceExpressionPrinter extends CollectionExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		SequenceExpression sequence = (SequenceExpression)e;
		String result = "Sequence{" + f.print((EolElement) sequence.getParameterList()) + "}";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SequenceExpression;
	}

}
