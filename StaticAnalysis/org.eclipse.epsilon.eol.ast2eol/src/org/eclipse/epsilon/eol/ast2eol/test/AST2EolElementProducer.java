package org.eclipse.epsilon.eol.ast2eol.test;

import java.io.File;
import java.net.URL;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EolElement;

public class AST2EolElementProducer {

	public static EolElement parseAST(String text)
	{
		EolModule eolModule = new EolModule();
		
		try {
			eolModule.parse(text);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Ast2EolContext context = new Ast2EolContext(eolModule);
		
		EolElement result = context.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, context);
		return result;
	}
	
}
