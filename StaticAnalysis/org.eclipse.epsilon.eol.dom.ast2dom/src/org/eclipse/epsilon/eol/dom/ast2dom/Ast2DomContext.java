package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.DomFactory;
import org.eclipse.epsilon.eol.dom.impl.DomFactoryImpl;

public class Ast2DomContext {

	DomElementCreatorFactory domElementCreatorFactory;
	DomFactory domFactory;
	TypeCreatorFactory typeCreatorFactory;
	
	public Ast2DomContext()
	{
		domElementCreatorFactory = new DomElementCreatorFactory();
		domFactory = new DomFactoryImpl();
		typeCreatorFactory = new TypeCreatorFactory(this);
	}
	
	public DomFactory getDomFactory()
	{
		return domFactory;
	}
	
	public DomElementCreatorFactory getDomElementCreatorFactory()
	{
		return domElementCreatorFactory;
	}
	
	public TypeCreatorFactory getTypeCreatorFactory()
	{
		return typeCreatorFactory;
	}
	
}
