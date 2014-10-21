package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class ForStatementTypeResolver_T2 extends ForStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		
		//push to stack
		context.getStack().push(forStatement, true);
		//visit the iterator
		controller.visit(forStatement.getIterator(), context);
		//visit the iterated
		controller.visit(forStatement.getIterated(), context);
		//visit the body
		controller.visit(forStatement.getBody(), context);
		//pop from stack
		context.getStack().pop();
		return null;
	}

}
