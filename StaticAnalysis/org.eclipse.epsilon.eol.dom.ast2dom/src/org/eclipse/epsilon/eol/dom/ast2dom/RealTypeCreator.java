package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.RealType;

public class RealTypeCreator extends PrimitiveTypeCreator{

	public static void main(String[] args)
	{
		RealTypeCreator a = new RealTypeCreator();
		IntegerTypeCreator b = new IntegerTypeCreator();
		Ast2DomContext c = new Ast2DomContext();
		DomElement d = a.create(null, null, c);
		DomElement e = b.create(null, null, c);
		System.out.println(d.getClass());
		System.out.println(e.getClass());
		System.out.println(d instanceof RealType);
		
	}
	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		// TODO Auto-generated method stub
		return context.getDomFactory().createRealType();
	}

}
