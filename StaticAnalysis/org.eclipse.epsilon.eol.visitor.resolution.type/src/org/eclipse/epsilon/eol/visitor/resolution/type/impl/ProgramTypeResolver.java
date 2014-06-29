package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class ProgramTypeResolver extends EolProgramVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(EolProgram program, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		if (context.getPessimistic()) {
			if (context.getMainProgram() == null) {
				context.getStack().push(program, true);
				context.setMainProgram(program);
			}
		}
		
		for(Import import1: program.getImports())
		{
			controller.visit(import1, context);
		}
		
		for(ModelDeclarationStatement mds: program.getModelDeclarations()) //process each model declaration statement
		{
			controller.visit(mds, context);
		}
		
		for(OperationDefinition od: program.getOperations()) //process each operation
		{
			if (context.getPessimistic()) {
				context.getStack().push(od, true);
			}
			
			if (od.getContextType() != null) {
				controller.visit(od.getContextType(), context); //resolve context type	
			}
			controller.visit(od.getReturnType(), context); //resolve return type
			if (od.getSelf() != null) {
				od.getSelf().setResolvedType(EcoreUtil.copy(od.getContextType()));	
				od.getSelf().getName().setResolvedType(EcoreUtil.copy(od.getContextType()));
			}
			Type contextType = od.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: od.getParameters()) //process each arg type
			{
				controller.visit(v, context);
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			if (!context.getOperationDefinitionControl().containsOperation(od.getName().getName(), contextType, argTypes)) { //check if operation with the same name and arg list exists
				context.putOperationDefinition(od);
			}
			else {
				context.getLogBook().addError(od, "OperationDefinition with same signature already defined");
				///handle signature existence
			}
			
			if (context.getPessimistic()) {
				context.getStack().pop();
			}
		}
		
		controller.visitContents(program.getBlock(), context); //process statement block

		for(OperationDefinition od: program.getOperations())
		{			
			if (context.getPessimistic()) {
			context.getStack().push(od, true);
			}

			controller.visit(od, context);
			
			if (context.getPessimistic()) {
				context.getStack().pop();
			}

		}
				
		if (context.getPessimistic()) {
			if (context.getMainProgram().equals(program)) {
				context.getStack().pop();
			}
		}
		return null;
	}

}
