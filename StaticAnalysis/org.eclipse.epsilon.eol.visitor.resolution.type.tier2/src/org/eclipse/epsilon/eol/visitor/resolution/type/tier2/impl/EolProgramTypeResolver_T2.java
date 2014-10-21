package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class EolProgramTypeResolver_T2 extends EolProgramVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(EolProgram eolProgram,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		
		for(OperationDefinition od: eolProgram.getOperations()) //process each operation
		{
			
			context.getStack().push(od, true); //insert a stack
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
			context.getStack().pop();
		}

		if (context.getMainProgram() == null) { //if the program is the EOL in question (the main program)
			context.setMainProgram(eolProgram); //set the main program to be this one
			context.getStack().push(eolProgram, true); //insert a stack
			for(ModelDeclarationStatement mds: eolProgram.getModelDeclarations())
			{
				controller.visit(mds, context);
			}
			for(Import imported : eolProgram.getImports())
			{
				controller.visit(imported, context); //visit each import statement and resolve the imported programs
			}
			controller.visit(eolProgram.getBlock(), context); //visit the contents of the program in question
			for(OperationDefinition op: eolProgram.getOperations())
			{
				controller.visit(op, context);
			}
			context.getStack().pop();
		}
		else { //if the program is the program that is imported
			for(ModelDeclarationStatement mds: eolProgram.getModelDeclarations())
			{
				controller.visit(mds, context);
			}

			for(Import imported : eolProgram.getImports()) 
			{
				controller.visit(imported, context); //visit each import statement and resolve the imported programs
			}
			controller.visit(eolProgram.getBlock(), context); //visit the contents of the program in question
			for(OperationDefinition op: eolProgram.getOperations())
			{
				controller.visit(op, context);
			}
		}
		 return null;
	}

}
