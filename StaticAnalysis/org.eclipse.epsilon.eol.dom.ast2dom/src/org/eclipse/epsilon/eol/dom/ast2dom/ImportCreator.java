package org.eclipse.epsilon.eol.dom.ast2dom;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.DomFactory;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ImportCreator extends DomElementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		DomFactory domFactory = context.getDomFactory();
		DomElementCreatorFactory factory = context.getDomElementCreatorFactory();
		
		Import imp = (Import) domFactory.createImport();
		imp.setLine(ast.getLine());
		imp.setColumn(ast.getColumn());
		imp.setImported(ast.getFirstChild().getText());
		//imp.printSelf();
		System.out.println(imp.getClass());
		try
		{
			AST importedAst = getAstForFile(imp.getImported());
			System.out.println("ImportedAst: " + imp.getImported());
			Program program = (Program)factory.createDomElement(importedAst, null, context);
			program.setName(imp.getImported());
		}
		catch(Exception e)
		{
			System.out.println(imp.getImported() + " does not exist");
		}
		return imp;
	}
	
	protected AST getAstForFile(String s) throws Exception
	{
		URL url = getClass().getResource(s);
		
		File file = new File(url.getPath());
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
		EolLexer lexer = new EolLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EolParser parser = new EolParser(stream);
		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
		parser.setDeepTreeAdaptor(adaptor);
		
		AST ast = (AST) parser.eolModule().getTree();	
		return ast;
	}

}
