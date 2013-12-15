package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.KeyValue;
import org.eclipse.epsilon.eol.parse.EolParser;

public class KeyValueCreator extends EolElementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		KeyValue keyValue = context.getEolFactory().createKeyValue(); //create a KeyValueExpression
		this.setAssets(ast, keyValue, container);
		
		AST keyAst = ast.getChild(0); //fetch key ast
		AST valueAst = ast.getChild(1); //fetch value ast
		
		keyValue.setKey((Expression) context.getEolElementCreatorFactory().createDomElement(keyAst, keyValue, context)); //set key
		keyValue.setValue((Expression) context.getEolElementCreatorFactory().createDomElement(valueAst, keyValue, context)); //set value
		
		return keyValue;
	}

	@Override
	public boolean appliesTo(AST ast) {
		boolean condition = ast.getType() == EolParser.KEYVAL;
		if(condition)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
