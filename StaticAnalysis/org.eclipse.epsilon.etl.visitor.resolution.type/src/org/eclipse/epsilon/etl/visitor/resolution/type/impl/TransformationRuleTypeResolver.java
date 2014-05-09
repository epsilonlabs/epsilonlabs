package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.TransformationRuleVisitor;

public class TransformationRuleTypeResolver extends TransformationRuleVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(TransformationRule transformationRule,
			TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		AnnotationBlock annotationBlock = transformationRule.getAnnotationBlock();
		if (annotationBlock != null) {
			controller.visit(annotationBlock, context);
		}
		FormalParameterExpression source = transformationRule.getSource();
		if (source != null) {
			controller.visit(source, context);
		}
		else {
			//
		}
		
		for(FormalParameterExpression target: transformationRule.getTargets())
		{
			controller.visit(target, context);
		}
		
		Guard guard = transformationRule.getGuard();
		if (guard != null) {
			controller.visit(guard, context);
		}
		
		Block body = transformationRule.getBody();
		if (body != null) {
			controller.visit(body, context);
		}
		
		return null;
	}

}
