package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.StringExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ImportCreator extends EolElementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {

		Import imp = context.getEolFactory().createImport(); //create an Import
		this.setAssets(ast, imp, container);
		
		AST importedStringAST = ast.getFirstChild(); //obtain the imported string AST
		if(importedStringAST != null)
		{
			imp.setImported((StringExpression)context.getEolElementCreatorFactory().createDomElement(importedStringAST, imp, context)); //create an StringExpression for the imported string
		}

		return imp;
	}
	
	/*protected AST getAstForFile(String s) throws Exception
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
	}*/

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
