package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class FLOMethodCallExpressionPrinter implements DomElementPrinter {
	
	public String print(DomElement e, DomElementPrinterFactory f) {
		FLOMethodCallExpression exp = (FLOMethodCallExpression) e;
		String pointOrArrow = ".";
		if (exp.isArrow()) pointOrArrow = "->";
		String s = "";
		if (exp.getTarget() != null) {
			s +=f.print((DomElement) exp.getTarget()) + pointOrArrow;
		}
		s += f.escapeName(exp.getMethod()) + "("
			+ f.print((DomElement) exp.getIterator()) + "|" + f.print((DomElement) exp.getCondition()) + ")";
		return s;
	}

}
