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
		
		//cast the context to be the etl type resolution context
		EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
		//set the current rule to be this rule
		leContext.setCurrentRule(transformationRule);
		
		//get the annotation block, if not null, visit it
		AnnotationBlock annotationBlock = transformationRule.getAnnotationBlock();
		if (annotationBlock != null) {
			controller.visit(annotationBlock, context);
		}
		
		//get the source, if not null, visit it
		FormalParameterExpression source = transformationRule.getSource();
		if (source != null) {
			controller.visit(source, context);
		}
		else {
			//
		}
		
		//iterate the targets, and visit
		for(FormalParameterExpression target: transformationRule.getTargets())
		{
			controller.visit(target, context);
		}
		
		//get the guard, if not null, visit it
		Guard guard = transformationRule.getGuard();
		if (guard != null) {
			controller.visit(guard, context);
		}
		
		//visit body if not null
		Block body = transformationRule.getBody();
		if (body != null) {
			controller.visit(body, context);
		}
		
		return null;
	}
	
	
	public EClass getEcoreType(FormalParameterExpression fpe)
	{
		//get the MET, if not null, get the ecore of it
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
