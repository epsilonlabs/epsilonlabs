package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlProgramVisitor;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;

public class EtlProgramTypeResolver extends EtlProgramVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(EtlProgram etlProgram, TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		for(Import _import: etlProgram.getImports())
		{
			controller.visit(_import, context);
		}
		
		for(ModelDeclarationStatement mds: etlProgram.getModelDeclarations()) //process each model declaration statement
		{
			controller.visit(mds, context);
		}
		
		for(OperationDefinition od: etlProgram.getOperations()) //process each operation
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
		
		for(OperationDefinition od: etlProgram.getOperations())
		{
			controller.visit(od, context);
		}
		
		for(PreBlock pb: etlProgram.getPreBlocks())
		{
			controller.visit(pb, context);
		}
		
		for(TransformationRule tr: etlProgram.getTransformationRules())
		{
			controller.visit(tr, context);
		}
		
		for(PostBlock pb: etlProgram.getPostBlocks())
		{
			controller.visit(pb, context);
		}
		
		return null;
	}

}
