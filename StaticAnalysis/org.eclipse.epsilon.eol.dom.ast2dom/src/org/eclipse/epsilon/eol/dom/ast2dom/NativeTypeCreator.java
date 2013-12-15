package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NativeType;
import org.eclipse.epsilon.eol.dom.StringExpression;
import org.eclipse.epsilon.eol.dom.Type;

public class NativeTypeCreator extends TypeCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		NativeType type = context.getEolFactory().createNativeType();
		this.setAssets(ast, type, container);
		
		AST parameterAst = ast.getFirstChild();
		if(parameterAst != null)
		{
			type.setNativeExpression((StringExpression) context.getEolElementCreatorFactory().createDomElement(parameterAst, type, context));
		}
		
		return type;
	}

	@Override
	public String getType() {
		return "native";
	}

	@Override
	public Type create(Ast2DomContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
