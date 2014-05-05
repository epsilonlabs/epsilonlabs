package org.eclipse.epsilon.eol.ast2eol;

import java.io.File;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;


public class ImportCreator extends EolElementCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {

		Import imp = context.getEolFactory().createImport(); //create an Import
		this.setAssets(ast, imp, container);
		
		AST importedStringAST = ast.getFirstChild(); //obtain the imported string AST
		if(importedStringAST != null)
		{
			String importedString = importedStringAST.getText();
			AST importedAst = null;
			
			try {
				importedAst = getAstForFile(importedString, context);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (importedAst!=null) {
				imp.setImportedProgram((Program) context.getEolElementCreatorFactory().createDomElement(importedAst, imp, context));
			}
			imp.setImported((StringExpression)context.getEolElementCreatorFactory().createDomElement(importedStringAST, imp, context)); //create an StringExpression for the imported string
		}

		return imp;
	}
	
	protected AST getAstForFile(String s, Ast2EolContext context) throws Exception
	{
		String directoryPath = context.getEolElementCreatorFactory().getDirectoryPathString();
		if (directoryPath != null) {
			/*String fullPath = directoryPath + s;
			File file = new File(fullPath);
			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
			EolLexer lexer = new EolLexer(input);
			CommonTokenStream stream = new CommonTokenStream(lexer);
			EolParser parser = new EolParser(stream);
			EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
			parser.setDeepTreeAdaptor(adaptor);
			AST ast = (AST) parser.eolModule().getTree();	
			return ast;*/
			EolModule eolModule = new EolModule();
			String fullPath = directoryPath + s;
			File file = new File(fullPath);
			eolModule.parse(file);
			return eolModule.getAst();
		}
		else {
			return null;
		}
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.IMPORT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
