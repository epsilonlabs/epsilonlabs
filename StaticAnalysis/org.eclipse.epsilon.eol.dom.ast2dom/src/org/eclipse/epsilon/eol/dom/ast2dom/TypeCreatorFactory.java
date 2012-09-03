package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Type;

public class TypeCreatorFactory {

	protected Ast2DomContext context;
	
	public TypeCreatorFactory(Ast2DomContext c)
	{
		context = c;
	}
	public Type createType(DomElement e, String s)
	{
		Type t = null;
		if(s.equalsIgnoreCase("Boolean")) t = (Type) new BooleanTypeCreator().create(null, null, context);
		else if(s.equalsIgnoreCase("Integer")) t = (Type) new IntegerTypeCreator().create(null, null, context);
		else if(s.equalsIgnoreCase("Real")) t = (Type) new RealTypeCreator().create(null, null, context);
		else if(s.equalsIgnoreCase("String")) t = (Type) new StringTypeCreator().create(null, null, context);
		
		else if(s.equals("Any")) t = (Type) new AnyTypeCreator().create(null, null, context);
		
		else if(s.equalsIgnoreCase("Map")) t = (Type) new MapTypeCreator().create(null, null, context);
		
		else if(s.equalsIgnoreCase("Set")) t = (Type) new SetTypeCreator().create(null, null, context);
		else if(s.equalsIgnoreCase("OrderedSet")) t = (Type) new OrderedSetTypeCreator().create(null, null, context);
		else if(s.equalsIgnoreCase("Sequence")) t = (Type) new SequenceTypeCreator().create(null, null, context);
		else if(s.equalsIgnoreCase("Bag")) t = (Type) new BagTypeCreator().create(null, null, context);
		
		t.setContainer(e);
		t.setLine(e.getLine());
		t.setColumn(e.getColumn());
		return t;
	}
}
