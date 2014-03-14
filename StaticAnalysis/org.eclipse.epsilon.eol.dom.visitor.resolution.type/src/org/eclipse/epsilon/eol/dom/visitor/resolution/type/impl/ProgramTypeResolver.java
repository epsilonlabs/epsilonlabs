package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ProgramVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class ProgramTypeResolver extends ProgramVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Program program, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
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
		}
		
		for(OperationDefinition od: program.getOperations())
		{
			controller.visit(od, context);
		}
		
		controller.visitContents(program.getBlock(), context); //process statement block
		/*for(OperationDefinition op: context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer().getOperations())
		{
			System.out.println(op.getName().getName());
		}*/
		return null;
	}

}
