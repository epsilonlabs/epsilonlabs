package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class PropertyCallExpressionTypeResolver_T2 extends PropertyCallExpressionVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		EolElement container = propertyCallExpression.getContainer();
		if (container instanceof AssignmentStatement && ((AssignmentStatement)container).getLhs().equals(propertyCallExpression)) {
			AssignmentStatement as = (AssignmentStatement) container;
			if (propertyCallExpression.getTarget() instanceof NameExpression) {
				NameExpression target = (NameExpression) propertyCallExpression.getTarget();
			}
		}
		return null;
	}

}
