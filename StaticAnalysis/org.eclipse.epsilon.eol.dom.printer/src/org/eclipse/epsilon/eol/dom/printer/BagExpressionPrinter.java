package org.eclipse.epsilon.eol.dom.printer;

import java.util.LinkedList;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.BagExpression;
import org.eclipse.epsilon.eol.dom.Expression;

public class BagExpressionPrinter implements CollectionExpressionPrinter{

	@Override
	public String print(DomElement e, DomElementPrinterFactory f) {
		String result = "Bag{";
		BagExpression sequence = (BagExpression)e;
		
		LinkedList<Expression> values = new LinkedList<Expression>(sequence.getValues());
		for(int i = 0; i < values.size()-1; i++)
		{
			result += f.print(values.get(i)) + ", ";
		}
		result += f.print(values.getLast()) + "}";
		return result;
	}

}
