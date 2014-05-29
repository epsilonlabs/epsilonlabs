package org.eclipse.epsilon.evl.visitor.resolution.impl;

import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.evl.metamodel.Context;
import org.eclipse.epsilon.evl.metamodel.EvlProgram;
import org.eclipse.epsilon.evl.metamodel.PostBlock;
import org.eclipse.epsilon.evl.metamodel.PreBlock;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlProgramVisitor;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;

public class EvlProgramVariableResolver extends EvlProgramVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(EvlProgram evlProgram,
			VariableResolutionContext context,
			EvlVisitorController<VariableResolutionContext, Object> controller) {
		
		if (context.getMainProgram() == null) { //if the program is the ETL in question (the main program)
			context.getStack().push(evlProgram, true); //insert a stack
			context.setMainProgram(evlProgram); //set the main program to be this one
		}
			for(Import imported : evlProgram.getImports())
			{
				controller.visit(imported, context); //visit each import statement and resolve the imported programs
			}
			for(PreBlock pre: evlProgram.getPreBlocks())
			{
				controller.visit(pre, context);
			}
			for(OperationDefinition op: evlProgram.getOperations())
			{
				controller.visit(op, context);
			}
			for(Context c: evlProgram.getContexts())
			{
				controller.visit(c, context);
			}
			
			for(PostBlock post: evlProgram.getPostBlocks())
			{
				controller.visit(post, context);
			}
		
		return null;
	}

}
