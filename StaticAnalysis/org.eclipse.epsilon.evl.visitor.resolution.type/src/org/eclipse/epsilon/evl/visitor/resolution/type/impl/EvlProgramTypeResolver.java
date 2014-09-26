package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.evl.metamodel.Context;
import org.eclipse.epsilon.evl.metamodel.EvlProgram;
import org.eclipse.epsilon.evl.metamodel.Invariant;
import org.eclipse.epsilon.evl.metamodel.PostBlock;
import org.eclipse.epsilon.evl.metamodel.PreBlock;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlProgramVisitor;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;

public class EvlProgramTypeResolver extends EvlProgramVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(EvlProgram evlProgram, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {
		EvlTypeResolutionContext leContext = (EvlTypeResolutionContext) context;
		for(Import _import: evlProgram.getImports())
		{
			controller.visit(_import, context);
		}
		
		for(ModelDeclarationStatement mds: evlProgram.getModelDeclarations())
		{
			controller.visit(mds, context);
		}
		
		for(OperationDefinition od: evlProgram.getOperations())
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
		
		for(OperationDefinition od: evlProgram.getOperations())
		{
			controller.visit(od, context);
		}
		
		for(PreBlock pb: evlProgram.getPreBlocks())
		{
			controller.visit(pb, context);
		}
		
		for(Context _context: evlProgram.getContexts())
		{
			if (_context.getInvariants() != null) {
				for(Invariant inv: _context.getInvariants())
				{
					leContext.insertInv(_context, inv.getName().getName(), inv);
				}
			}
			controller.visit(_context, context);
		}
		
		for(PostBlock pb: evlProgram.getPostBlocks())
		{
			controller.visit(pb, context);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
