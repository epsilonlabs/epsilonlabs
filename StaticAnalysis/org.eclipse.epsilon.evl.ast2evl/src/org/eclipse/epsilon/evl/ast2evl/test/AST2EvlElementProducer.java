package org.eclipse.epsilon.evl.ast2evl.test;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.ast2evl.Ast2EvlContext;

public class AST2EvlElementProducer {

	public static EolElement parseAST(String text)
	{
		EvlModule module = new EvlModule();
		
		try {
			module.parse(text);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Ast2EvlContext context = new Ast2EvlContext(module);
		
		EolElement result = context.getEvlElementCreatorFactory().createDomElement(module.getAst(), null, context);
		return result;
	}
	
}
