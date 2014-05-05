package org.eclipse.epsilon.etl.ast2etl;

import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.AstUtilities;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class EtlProgramCreator extends EtlElementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EtlParser.ETLMODULE)
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
		
		Ast2EtlContext _context = (Ast2EtlContext) context;
		
		EtlProgram program = _context.getEtlFactory().createEtlProgram();
		this.setAssets(ast, program, null);
		
		
		ArrayList<AST> importAsts = AstUtilities.getChildren(ast, EtlParser.IMPORT); //get Import ASTs
		if(importAsts != null)
		{
			for (AST importAst : importAsts) {
				program.getImports().add((Import)_context.getEtlElementCreatorFactory().createDomElement(importAst, program, _context)); //process import ASTs
			}
		}
		
		ArrayList<AST> modelDeclAsts = AstUtilities.getChildren(ast, EtlParser.MODELDECLARATION);
		if (modelDeclAsts != null) {
			for(AST modelDecl: modelDeclAsts)
			{
				program.getModelDeclarations().add((ModelDeclarationStatement) _context.getEtlElementCreatorFactory().createDomElement(modelDecl, program, _context));
			}
		}
				
		ArrayList<AST> preAsts = AstUtilities.getChildren(ast, EtlParser.PRE); //get Pre AST
		if (preAsts != null) {
			for(AST preBlockAst: preAsts)
			{
				program.getPreBlocks().add((PreBlock) _context.getEtlElementCreatorFactory().createDomElement(preBlockAst, program, _context));
			}
		}
		
		ArrayList<AST> postAsts = AstUtilities.getChildren(ast, EtlParser.PRE); //get Post AST
		if (postAsts != null) {
			for(AST postBlockAst: postAsts)
			{
				program.getPreBlocks().add((PreBlock) _context.getEtlElementCreatorFactory().createDomElement(postBlockAst, program, _context));
			}
		}
		
		ArrayList<AST> operations = AstUtilities.getChildren(ast, EtlParser.HELPERMETHOD); //obtain ASTs for operation defintions
		if(operations != null)
		{
			for (AST operation : operations) {
				program.getOperations().add((OperationDefinition)_context.getEtlElementCreatorFactory().createDomElement(operation, program, _context)); //process operation ASTs
			}
		}
		
		ArrayList<AST> transformationRules = AstUtilities.getChildren(ast, EtlParser.TRANSFORM);
		if (transformationRules != null) {
			for(AST transformationRule: transformationRules)
			{
				program.getTransformationRules().add((TransformationRule) _context.getEtlElementCreatorFactory().createDomElement(transformationRule, program, _context));
			}
		}
			
		return program;
	}

}
