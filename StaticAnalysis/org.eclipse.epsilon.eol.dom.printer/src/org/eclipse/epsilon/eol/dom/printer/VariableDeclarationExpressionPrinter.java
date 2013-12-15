package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class VariableDeclarationExpressionPrinter extends ExpressionPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		VariableDeclarationExpression expression = (VariableDeclarationExpression) e;
		String result = "var";
		result += " " + f.print((DomElement) expression.getName());
		if(expression.getResolvedType() != null)
		{
			result += " : ";
			if(expression.getCreate().isVal())
			{
				result += "new ";
			}
			
			result += f.print((DomElement) expression.getResolvedType());
		}		
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof VariableDeclarationExpression;
	}
	
}
