package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.IntegerExpression;
import org.eclipse.epsilon.eol.dom.OrderedSetExpression;
import org.eclipse.epsilon.eol.dom.SequenceExpression;
import org.eclipse.epsilon.eol.dom.SetExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SetExpressionCreator extends CollectionExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {

		DomElement result = null;
		SetExpression e = context.getDomFactory().createSetExpression();
		AST parameterType = ast.getFirstChild();
		if(parameterType.getType() == EolParser.EXPRLIST)
		{
			for(AST child: parameterType.getChildren())
			{		
				e.getValues().add(context.getDomElementCreatorFactory().createExpression(child, e, context));
			}
			
		}
		else if(parameterType.getType() == EolParser.EXPRRANGE)
		{
			AST paramChild = parameterType.getFirstChild();
			if(paramChild.getType() == EolParser.INT && paramChild.getNextSibling().getType() == EolParser.INT)
			{
				int start = Integer.parseInt(paramChild.getText());
				int end = Integer.parseInt(paramChild.getNextSibling().getText());
				for(int i = start; i <= end; i++)
				{
					IntegerExpression intexpr = context.getDomFactory().createIntegerExpression();
					intexpr.setVal(i);
					intexpr.setContainer(e);
					e.getValues().add(intexpr);
				}
			}
			else
			{
				System.err.println("Pointpoint operator can only be used on integers");
			}
		}
		
		result = e;
		return result;
	}

}
