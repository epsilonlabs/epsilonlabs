package org.eclipse.epsilon.eol.dom.ast2dom;

import java.util.LinkedList;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.DomFactory;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ProgramCreator extends DomElementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		DomFactory domFactory = context.getDomFactory();
		DomElementCreatorFactory factory = context.getDomElementCreatorFactory();
		
		Program program = (Program)domFactory.createProgram(); 
		program.setLine(ast.getLine());
		program.setColumn(ast.getColumn());
		
		LinkedList<AST> imports = AstUtilities.getChildren(ast, EolParser.IMPORT);
		for (AST importAst : imports) {
			program.getImports().add((Import)factory.createDomElement(importAst, program, context));
		}
				
		AST block = AstUtilities.getChild(ast, EolParser.BLOCK);
		for (AST statementAst : block.getChildren()) {
			//System.out.println("Should be run many times");
			//System.out.println("statements build for program: " + program.getName());
			program.getStatements().add(factory.createStatement(statementAst, program, context));
		}
		
		LinkedList<AST> operations = AstUtilities.getChildren(ast, EolParser.HELPERMETHOD);
		for (AST operation : operations) {
			//System.out.println("op build for program: " + program.getName());
			program.getOperations().add((OperationDefinition)factory.createDomElement(operation, program, context));
		}
		
		//System.out.println(program.getClass());
		return program;
	}

}
