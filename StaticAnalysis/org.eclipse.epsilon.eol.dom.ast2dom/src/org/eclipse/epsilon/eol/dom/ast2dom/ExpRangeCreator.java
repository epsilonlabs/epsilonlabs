package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ExpRange;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExpRangeCreator extends CollectionInitValueCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.EXPRRANGE && ast.getNumberOfChildren() == 2)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		ExpRange list = context.getEolFactory().createExpRange();
		this.setAssets(ast, list, container);
		
		AST beginAst = ast.getChild(0);
		AST endAst = ast.getChild(1);
		
		list.setStart((Expression) context.getEolElementCreatorFactory().createDomElement(beginAst, list, context));
		list.setEnd((Expression) context.getEolElementCreatorFactory().createDomElement(endAst, list, context));
		
		return list;
	}

}
