package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
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
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		ExpRange list = context.getEolFactory().createExpRange();
		this.setAssets(ast, list, container);
		
		AST beginAst = ast.getChild(0);
		AST endAst = ast.getChild(1);
		
		list.setStart((Expression) context.getEolElementCreatorFactory().createDomElement(beginAst, list, context));
		list.setEnd((Expression) context.getEolElementCreatorFactory().createDomElement(endAst, list, context));
		
		return list;
	}

}
