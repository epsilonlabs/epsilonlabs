package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.MapExpression;

public class MapExpressionPrinter extends LiteralExpressionPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		MapExpression map = (MapExpression) e;
		String result = "Map{" + f.print(map.getKeyValues(), ",") + "}";
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof MapExpression;
	}

}
