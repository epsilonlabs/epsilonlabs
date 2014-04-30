package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class TypeCreator extends EolElementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		return (ast.getType() == EolParser.TYPE && ast.getText().equals(getType()));
	}
	
	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		Type type = create(context);
		this.setAssets(ast, type, container);
		return type;
	}
	
	public Type create(Ast2DomContext context)
	{
		return context.getEolFactory().createType();
	}
	
	public String getType()
	{
		return "Type";
	}
}
