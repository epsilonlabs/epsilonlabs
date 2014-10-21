package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class AssignmentStatementTypeResolver_T2 extends AssignmentStatementVisitor<TypeResolutionContext, Object>
{

	@Override
	public Object visit(AssignmentStatement assignmentStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		return null;
	}

}
