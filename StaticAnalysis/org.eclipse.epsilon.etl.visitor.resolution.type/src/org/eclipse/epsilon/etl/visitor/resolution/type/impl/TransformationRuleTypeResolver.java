package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.TransformationRuleVisitor;
import org.eclipse.epsilon.etl.visitor.resolution.type.context.EtlTypeResolutionContext;

public class TransformationRuleTypeResolver extends TransformationRuleVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(TransformationRule transformationRule,
			TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		
		EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
		leContext.setCurrentRule(transformationRule);
		
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
	
	
	public EClass getEcoreType(FormalParameterExpression fpe)
	{
		ModelElementType met = (ModelElementType) fpe.getResolvedType();
		if (met != null) {
			EClass eClass = (EClass) met.getEcoreType();
			return eClass;
		}
		else {
			return null;
		}
	}

}
