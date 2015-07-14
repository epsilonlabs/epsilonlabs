package org.eclipse.epsilon.eol.ast2eol.util;

import java.io.File;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.*;



public class Ast2EolUtil {
	
	Ast2EolContext context = null;
	
	public Ast2EolUtil(Ast2EolContext context) {
		this.context = context;
	}
	
	public Ast2EolContext getContext() {
		return context;
	}

//	public AST generateAst(Class<?> clazz, String s)
//	{
//		EolModule eolModule = new EolModule();
//		
//		try {
//			eolModule.parse(new File(clazz.getProtectionDomain().getCodeSource().getLocation().getPath()));
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		AST ast = eolModule.getAst();
//		return ast;
//	}
//	
//	public EOLProgram generateProgram(AST ast)
//	{
//		EOLProgram result = null;
//		Ast2EolContext context = new Ast2EolContext();
//		result = (EOLProgram) context.getEolElementCreatorFactory().createDomElement(ast, null, context);
//		return result;
//	}
//	
//	public EOLProgram generate(Class<?> clazz, String s)
//	{
//		return generateProgram(generateAst(clazz, s));
//	}
	
	
	public EOLProgram createEOLProgramFromPath(String path)
	{
		EOLProgram result = null;
		AST ast = createASTFromPath(path);
		if (ast != null) {
			result = (EOLProgram) context.getEolElementCreatorFactory().createEOLElement(ast, null, context);	
		}
		return result;
	}
	
	public AST createASTFromPath(String path)
	{
		EolModule eolModule = new EolModule();
		
		try {
			eolModule.parse(new File(path));
		} catch (Exception e) {
			//warning, parse may fail
		}
		
		return eolModule.getAst();
	}
}
