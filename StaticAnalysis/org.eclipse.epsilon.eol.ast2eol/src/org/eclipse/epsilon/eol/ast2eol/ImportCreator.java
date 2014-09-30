package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
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
			for(EolImport leImport: context.getModule().getImports())
			{
				if (leImport.getAst().equals(ast)) {
					EolProgram importedProgram = (EolProgram) context.getEolElementCreatorFactory().createDomElement(leImport.getModule().getAst(), imp, context);
					if (importedProgram != null) {
						imp.setImportedProgram(importedProgram);
					}
				}
			}
			imp.setImported((StringExpression)context.getEolElementCreatorFactory().createDomElement(importedStringAST, imp, context)); //create an StringExpression for the imported string
		}

		return imp;
	}
	
//	protected AST getAstForFile(String s, Ast2EolContext context) throws Exception
//	{
//		String directoryPath = context.getEolElementCreatorFactory().getDirectoryPathString();
//		if (directoryPath != null && s.endsWith(".eol")) {
//			/*String fullPath = directoryPath + s;
//			File file = new File(fullPath);
//			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
//			EolLexer lexer = new EolLexer(input);
//			CommonTokenStream stream = new CommonTokenStream(lexer);
//			EolParser parser = new EolParser(stream);
//			EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
//			parser.setDeepTreeAdaptor(adaptor);
//			AST ast = (AST) parser.eolModule().getTree();	
//			return ast;*/
//			EolModule eolModule = new EolModule();
//			String fullPath = directoryPath + s;
//			File file = new File(fullPath);
//			eolModule.parse(file);
//			return eolModule.getAst();
//		}
//		else {
//			return null;
//		}
//	}

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
