package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import java.io.File;
import java.net.URL;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;

public class deprecated_ResolutionHelper {

	public AST generateAst(String s)
	{
		URL url = getClass().getResource(s);
		//System.out.println(url.toString());
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		AST ast = eolModule.getAst();
		return ast;
	}
	
	public EolProgram generateProgram(AST ast)
	{
		EolProgram result = null;
		Ast2EolContext context = new Ast2EolContext();
		result = (EolProgram) context.getEolElementCreatorFactory().createDomElement(ast, null, context);
		return result;
	}
}
