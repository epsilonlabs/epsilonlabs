package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import java.io.File;
import java.net.URL;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.dom.ast2dom.Ast2DomContext;

public class ResolutionHelper {

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
	
	public Program generateProgram(AST ast)
	{
		Program result = null;
		Ast2DomContext context = new Ast2DomContext();
		result = (Program) context.getEolElementCreatorFactory().createDomElement(ast, null, context);
		return result;
	}
}
