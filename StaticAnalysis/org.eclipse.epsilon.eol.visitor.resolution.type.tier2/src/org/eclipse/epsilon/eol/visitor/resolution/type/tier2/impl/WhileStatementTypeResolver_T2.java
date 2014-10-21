package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.WhileStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.WhileStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class WhileStatementTypeResolver_T2 extends WhileStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(WhileStatement whileStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		context.setCurrentEolElement(whileStatement);
		controller.visitContents(whileStatement, context);
		return null;
	}


}
