package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.evl.metamodel.Context;
import org.eclipse.epsilon.evl.metamodel.Invariant;
import org.eclipse.epsilon.evl.metamodel.visitor.ContextVisitor;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;

public class ContextTypeResolver extends ContextVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Context _context, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {

		EvlTypeResolutionContext leContext = (EvlTypeResolutionContext) context;
		
		leContext.setCurrentContext(_context);
		
		controller.visit(_context.getType(), context);
		
		if (_context.getSelf() != null) {
			_context.getSelf().setResolvedType(EcoreUtil.copy(_context.getType()));	
			_context.getSelf().getName().setResolvedType(EcoreUtil.copy(_context.getType()));
		}
		
		ExpressionOrStatementBlock guard = _context.getGuard();
		if (guard != null) {
			controller.visit(guard, context);
		}
		
		for (Invariant inv: _context.getInvariants()) {
			controller.visit(inv, context);
		}
		return null;
	}

}
