package org.eclipse.epsilon.eol.ast2eol;

import java.util.ArrayList;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ProgramCreator extends EolElementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.EOLMODULE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		EolProgram program = context.getEolFactory().createEolProgram(); //create a program 
		this.setAssets(ast, program, null);
		
		ArrayList<AST> importAsts = AstUtilities.getChildren(ast, EolParser.IMPORT); //get Import ASTs
		if(importAsts != null)
		{
			for (AST importAst : importAsts) {
				program.getImports().add((Import)context.getEolElementCreatorFactory().createDomElement(importAst, program, context)); //process import ASTs
			}
		}
		
		ArrayList<AST> modelDeclAsts = AstUtilities.getChildren(ast, EolParser.MODELDECLARATION);
		if (modelDeclAsts != null) {
			for(AST modelDecl: modelDeclAsts)
			{
				program.getModelDeclarations().add((ModelDeclarationStatement) context.getEolElementCreatorFactory().createDomElement(modelDecl, program, context));
			}
		}
				
		AST blockAst = AstUtilities.getChild(ast, EolParser.BLOCK); //get Block AST
		if(blockAst != null)
		{
			program.setBlock((Block)context.getEolElementCreatorFactory().createDomElement(blockAst, program, context)); //process block AST
		}
						
		ArrayList<AST> operations = AstUtilities.getChildren(ast, EolParser.HELPERMETHOD); //obtain ASTs for operation defintions
		if(operations != null)
		{
			for (AST operation : operations) {
				program.getOperations().add((OperationDefinition)context.getEolElementCreatorFactory().createDomElement(operation, program, context)); //process operation ASTs
			}
		}
			
		return program;
	}

}
