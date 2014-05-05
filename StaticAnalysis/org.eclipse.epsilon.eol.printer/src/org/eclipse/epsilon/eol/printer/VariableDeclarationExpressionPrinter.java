package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class VariableDeclarationExpressionPrinter extends ExpressionPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		VariableDeclarationExpression expression = (VariableDeclarationExpression) e;
		String result = "var";
		result += " " + f.print((EolElement) expression.getName());
		if(expression.getResolvedType() != null)
		{
			result += " : ";
			if(expression.getCreate().isVal())
			{
				result += "new ";
			}
			
			result += f.print((EolElement) expression.getResolvedType());
		}		
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof VariableDeclarationExpression;
	}
	
}
