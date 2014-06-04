package org.eclipse.epsilon.eol.ast2eol.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;



public class Ast2EolUtil {

	public AST generateAst(Class<?> clazz, String s)
	{
		URL temp = clazz.getResource(s);
		URL url = null;
		try {
			url = FileLocator.toFileURL(temp);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.err.println("errrrrrr");
		}
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
	
	public EolProgram generate(Class<?> clazz, String s)
	{
		
		return generateProgram(generateAst(clazz, s));
	}
}
