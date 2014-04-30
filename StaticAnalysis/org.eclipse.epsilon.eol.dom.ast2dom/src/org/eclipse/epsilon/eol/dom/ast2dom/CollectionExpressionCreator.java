package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;

public abstract class CollectionExpressionCreator extends LiteralExpressionCreator{

	public void buildCollection(AST ast, CollectionExpression collection, EolElement container, Ast2DomContext context)
	{
		this.setAssets(ast, collection, container);
		
		AST parameterAst = ast.getFirstChild();
		
		if(parameterAst != null)
		{
			collection.setParameterList((CollectionInitValue) context.getEolElementCreatorFactory().createDomElement(parameterAst, collection, context));
		}
	}
}
