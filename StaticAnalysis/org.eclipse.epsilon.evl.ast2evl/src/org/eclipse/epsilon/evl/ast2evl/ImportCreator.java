package org.eclipse.epsilon.evl.ast2evl;

import java.io.File;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class ImportCreator extends org.eclipse.epsilon.eol.ast2eol.ImportCreator{

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
				importedAst = getAstForFile(importedString, (Ast2EvlContext)context);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (importedAst!=null) {
				imp.setImportedProgram((EolLibraryModule) context.getEolElementCreatorFactory().createDomElement(importedAst, imp, context));
			}
			imp.setImported((StringExpression)context.getEolElementCreatorFactory().createDomElement(importedStringAST, imp, context)); //create an StringExpression for the imported string
		}

		return imp;
	}
	
	protected AST getAstForFile(String s, Ast2EvlContext context) throws Exception
	{
		String directoryPath = context.getEvlElementCreatorFactory().getDirectoryPathString();
		if (directoryPath != null && (s.endsWith(".evl") || s.endsWith(".eol"))) {
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
		if(ast.getType() == EvlParser.IMPORT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
