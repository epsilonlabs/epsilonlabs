package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class MapExpressionPrinter extends LiteralExpressionPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		MapExpression map = (MapExpression) e;
		String result = "Map{" + f.print(map.getKeyValues(), ",") + "}";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof MapExpression;
	}

}
