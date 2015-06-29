package org.eclipse.epsilon.etl.ast2etl;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class ImportCreator extends org.eclipse.epsilon.eol.ast2eol.ImportCreator{
	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {

		Ast2EtlContext _context = (Ast2EtlContext) context;
		Import imp = _context.getEolFactory().createImport(); //create an Import
		this.setAssets(ast, imp, container);
		
		AST importedStringAST = ast.getFirstChild(); //obtain the imported string AST
		if(importedStringAST != null)
		{
			for(org.eclipse.epsilon.eol.dom.Import leImport: _context.getModule().getImports())
			{
				if (leImport.equals(ast)) {
					EolLibraryModule importedProgram = (EolLibraryModule) _context.getEtlElementCreatorFactory().createDomElement(leImport.getModule().getAst(), imp, _context);
					if (importedProgram != null) {
						imp.setImportedProgram(importedProgram);
					}
				}
			}
//			for(EolImport leImport: _context.getModule().getImports())
//			{
//				if (leImport.getAst().equals(ast)) {
//					EolLibraryModule importedProgram = (EolLibraryModule) _context.getEtlElementCreatorFactory().createDomElement(leImport.getModule().getAst(), imp, _context);
//					if (importedProgram != null) {
//						imp.setImportedProgram(importedProgram);
//					}
//				}
//			}
			imp.setImported((StringExpression)context.getEolElementCreatorFactory().createDomElement(importedStringAST, imp, context)); //create an StringExpression for the imported string
		}

		return imp;
	}
	

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EtlParser.IMPORT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
