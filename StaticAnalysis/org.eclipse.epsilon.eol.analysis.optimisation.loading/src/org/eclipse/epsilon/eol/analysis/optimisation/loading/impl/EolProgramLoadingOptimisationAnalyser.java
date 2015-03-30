package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class EolProgramLoadingOptimisationAnalyser extends EolProgramVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(EolProgram program, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;

		
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
			leContext.addToCallGraph(od); // <================================================
			
			
			Type contextType = od.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: od.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			if (!context.getOperationDefinitionControl().containsOperation(od.getName().getName(), contextType, argTypes)) { //check if operation with the same name and arg list exists
				context.putOperationDefinition(od);
			}
			else {
				context.getLogBook().addError(od, "OperationDefinition with same signature already defined");
			}
			
		}
		
		controller.visitContents(program.getBlock(), context); //process statement block

		for(OperationDefinition od: program.getOperations())
		{			
			controller.visit(od, context);
		}
		
		leContext.processMap();
		
		
				
		return null;
	}

}
