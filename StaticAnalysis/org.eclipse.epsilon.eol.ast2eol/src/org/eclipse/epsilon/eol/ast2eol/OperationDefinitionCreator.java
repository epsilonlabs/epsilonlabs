package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class OperationDefinitionCreator extends EolElementCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		OperationDefinition operation = (OperationDefinition) context.getEolFactory().createOperationDefinition(); //create an OperationDefinition
		
		this.setAssets(ast, operation, container);
		
		AST previousAst = AstUtilities.getPreviousSibling(ast); //get the previous sibling
		if(previousAst.getType() == EolParser.ANNOTATIONBLOCK) //check if there is an annotation block
		{
			operation.setAnnotationBlock((AnnotationBlock) context.getEolElementCreatorFactory().createDomElement(previousAst, operation, context)); //process annotation block
		}
		
		AST contextTypeAst = null; //declare contextTypeAst
		AST nameAst = null; //declare nameAst
		AST parameterListAst = null; //declare parameterListAst
		AST returnTypeAst = null; //declare returnTypeAst
		AST bodyAst = null; //declare bodyAst
		
		if (ast.getFirstChild().getType() == EolParser.TYPE) { //if there is a contextType specified
			contextTypeAst = ast.getFirstChild(); //assign contextTypeAst
			nameAst = contextTypeAst.getNextSibling();  //assign nameAst
		}
		else { //if there is no contextType specified
			nameAst = ast.getFirstChild(); //assign nameAst

			AnyType contextType = context.getEolFactory().createAnyType(); //if there's no context type, it should be any
			contextType.setDeclared(false);
			setAssets(nameAst, contextType, operation);
			operation.setContextType(contextType);

		}
		
		if (nameAst.getNextSibling().getType() == EolParser.PARAMLIST){ //if there is a parameter list
			parameterListAst = nameAst.getNextSibling(); //assign parameterListAst
		}
		
		if (parameterListAst != null){ // helper with parameters
			if (parameterListAst.getNextSibling().getType() == EolParser.TYPE){ // it there is a return type specified
				returnTypeAst = parameterListAst.getNextSibling();
				bodyAst = returnTypeAst.getNextSibling();
			} else { // if there is no return type
				bodyAst = parameterListAst.getNextSibling();
			}
		} else { // helper without parameters
			if (nameAst.getNextSibling().getType() == EolParser.TYPE){ //if there is a return type specified
				returnTypeAst = nameAst.getNextSibling(); //assign return type
				bodyAst = returnTypeAst.getNextSibling(); //assign bodyAst
			} else { // without return type
				bodyAst = nameAst.getNextSibling(); //assign bodyAst
			}
		}
		
		if(contextTypeAst != null) //if there is a contextType
		{
			Type contextType = (Type) context.getEolElementCreatorFactory().createDomElement(contextTypeAst, operation, context); //process context type
			operation.setContextType(contextType); //assign context type
		}
		
		operation.setName((NameExpression)context.getEolElementCreatorFactory().createDomElement(nameAst, operation, context)); //process name
		
		if(parameterListAst != null) //if there is a parameter list
		{
			for(AST parameterAst : parameterListAst.getChildren())
			{
				operation.getParameters().add((FormalParameterExpression) context.getEolElementCreatorFactory().createDomElement(parameterAst, operation, context));
			}
		}
		
		if(returnTypeAst != null) //if there is a return type
		{
			Type returnType = (Type) context.getEolElementCreatorFactory().createDomElement(returnTypeAst, operation, context); //create a return type
			operation.setReturnType(returnType); //assign the return type to the operation
		}
		else {
			//Type returnType = context.getEolFactory().createVoidType(); //if there's no return type, it should be void
			AnyType returnType = context.getEolFactory().createAnyType();
			returnType.setDeclared(false);
			setAssets(nameAst, returnType, operation);
			operation.setReturnType(returnType);
		}
		
		if(bodyAst != null) //if there is a body
		{
			operation.setBody((Block)context.getEolElementCreatorFactory().createDomElement(bodyAst, operation, context)); //process body
		}
		
		VariableDeclarationExpression self = context.getEolFactory().createVariableDeclarationExpression();
		NameExpression selfName = context.getEolFactory().createNameExpression();
		selfName.setName("self");
		self.setName(selfName);
		self.setResolvedType(EcoreUtil.copy(operation.getContextType()));
		selfName.setResolvedType(EcoreUtil.copy(operation.getContextType()));
		operation.setSelf(self);

		VariableDeclarationExpression _result = context.getEolFactory().createVariableDeclarationExpression();
		NameExpression resultName = context.getEolFactory().createNameExpression();
		resultName.setName("_result");
		_result.setName(resultName);
		_result.setResolvedType(EcoreUtil.copy(operation.getReturnType()));
		resultName.setResolvedType(EcoreUtil.copy(operation.getReturnType()));
		operation.set_result(_result);

		
//		if(returnTypeAst != null){ //this is based on the assumption that a operation definition MUST define a returnType if it returns anything
//		}
		
		return operation;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.HELPERMETHOD)
		{
			return true;
		}
		else {
			return false;
		}
	}
	


}
