package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class MapExpressionCreator extends LiteralExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.MAP)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {

		MapExpression expression = context.getEolFactory().createMapExpression(); //create a map expression first
		this.setAssets(ast, expression, container); //set assets
		
		AST keyValueListAst = ast.getFirstChild(); //keyValueList could be null
		if(keyValueListAst!=null && keyValueListAst.getType() == EolParser.KEYVALLIST) //if keyvalue is not null
		{
			for(AST child: keyValueListAst.getChildren()) //process keys and values
			{
				expression.getKeyValues().add((KeyValue) context.getEolElementCreatorFactory().createDomElement(child, expression, context)); //add pair
			}
		}
		
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, MapTypeCreator.class)); //set resolved type
		
		return expression; //return
	}

}
