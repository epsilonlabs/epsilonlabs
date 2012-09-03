package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;
import org.eclipse.epsilon.eol.dom.impl.BooleanExpressionImpl;
import org.eclipse.epsilon.eol.dom.impl.OrderedSetExpressionImpl;


public class VariableDeclarationExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		VariableDeclarationExpression exp = (VariableDeclarationExpression) e;
		String s = "";
		if ((exp.getContainer() instanceof ExpressionStatement) || 
				((exp.getContainer() instanceof AssignmentStatement) && ((AssignmentStatement) exp.getContainer()).getLhs() == exp)) {
			s += "var ";
			s += exp.getName();
			if (exp.getType() != null) {
				s = s + " : ";
				if (exp.isCreate())
				{
					if(f.nameExists(getType(exp.getType())))
					{
						s += " new ";
					}
					else 
					{
						
					}
				}
				
				s += getType(exp.getType());
			}
		}
		else if(exp.getContainer() instanceof OperationDefinition)
		{
			//if (exp.isCreate()) s += " new ";
			s += exp.getName() + ": ";
			s += getType(exp.getType());
		}
		else
		{
			if (exp.isCreate()) s += " new ";
			s += exp.getName();
		}
		
		return s;
	}
	
	public String getType(Type exp)
	{
		String result = "Any";
		if(exp instanceof BooleanType)
		{
			result = "Boolean";
		}
		else if(exp instanceof IntegerType)
		{
			result = "Integer";
		}
		else if(exp instanceof RealType)
		{
			result = "Real";
		}
		else if(exp instanceof StringType)
		{
			result = "String";
		}
		else if(exp instanceof SetType)
		{
			result = "Set";
		}
		else if(exp instanceof BagType)
		{
			result = "Bag";
		}
		else if(exp instanceof OrderedSetType)
		{
			result = "OrderedSet";
		}
		else if(exp instanceof SequenceType)
		{
			result = "Sequence";
		}
		else if(exp instanceof MapType)
		{
			result = "Map";
		}
		
		return result;
		
	}

}
