package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BagType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.SpecialAssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SpecialAssignmentStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.RuleDependency;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.visitor.resolution.type.context.EtlTypeResolutionContext;

public class SpecialAssignmentStatementTypeResolver extends SpecialAssignmentStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SpecialAssignmentStatement specialAssignmentStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		Expression lhs = specialAssignmentStatement.getLhs(); //get lhs expression
		Expression rhs = specialAssignmentStatement.getRhs(); //get rhs expression
		if (lhs instanceof PropertyCallExpression || lhs instanceof NameExpression || lhs instanceof VariableDeclarationExpression) {
			controller.visit(rhs, context); //visit rhs
			controller.visit(lhs, context); //visit lhs
			
			EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
			
			if (lhs.getResolvedType() instanceof ModelElementType && rhs.getResolvedType() instanceof ModelElementType) {
				ModelElementType rhsType = (ModelElementType) rhs.getResolvedType();
				EClass ecoreType = (EClass) rhsType.getEcoreType();
				if (ecoreType != null) {
					TransformationRule dependingRule = leContext.getTraceUnitContainerWhichTransforms(ecoreType, false).getTransformationRule(); //get the depending rule from the context
					if (dependingRule == null) { //if depending rule is null, return null
						context.getLogBook().addError(specialAssignmentStatement, "No applicable transformation rule is found");
						return null;
					}
					TransformationRule currentRule = leContext.getCurrentRule(); //get the current rul
					if (currentRule == null) { //if the current rule is not null
						return null;
					}
					RuleDependency ruleDependency = leContext.getEtlFactory().createRuleDependency();
					ruleDependency.setDependingRule(dependingRule);
					ruleDependency.setSourceElement(specialAssignmentStatement);
					context.setAssets(ruleDependency, currentRule);

					currentRule.getResolvedRuleDependencies().add(ruleDependency); //resolve the dependency
					if (dependingRule.getTargets().size() > 0) { //if the depending rule has targets 
						FormalParameterExpression primaryTarget = dependingRule.getTargets().get(0); //get the first target
						ModelElementType primaryTargetType = (ModelElementType) primaryTarget.getResolvedType();
						if (primaryTargetType != null) { //if the first target is not null
							if (primaryTargetType.getEcoreType() != null) {
								rhs.setResolvedType(EcoreUtil.copy(primaryTargetType));
							}
							else {
								context.getLogBook().addError(primaryTarget, "type not resolved properly");
							}
						}
					}
				}
				else {
					context.getLogBook().addError(rhs, "type is not properly resolved");
				}
			}
			else if (lhs.getResolvedType() instanceof CollectionType && rhs.getResolvedType() instanceof CollectionType) {
				CollectionType rhsType = (CollectionType) rhs.getResolvedType();
				ModelElementType rhsContentType = (ModelElementType) rhsType.getContentType();
				if (rhsContentType != null) {
					EClass ecoreType = (EClass) rhsContentType.getEcoreType();
					TransformationRule dependingRule = leContext.getTraceUnitContainerWhichTransforms(ecoreType, false).getTransformationRule(); //get the depending rule from the context
					if (dependingRule == null) { //if depending rule is null, return null
						context.getLogBook().addError(specialAssignmentStatement, "No applicable transformation rule is found");
						return null;
					}
					TransformationRule currentRule = leContext.getCurrentRule(); //get the current rul
					if (currentRule != null) { //if the current rule is not null
						RuleDependency ruleDependency = leContext.getEtlFactory().createRuleDependency();
						ruleDependency.setDependingRule(dependingRule);
						ruleDependency.setSourceElement(specialAssignmentStatement);
						context.setAssets(ruleDependency, currentRule);

						currentRule.getResolvedRuleDependencies().add(ruleDependency); //resolve the dependency
					}
					if (dependingRule.getTargets().size() > 0) { //if the depending rule has targets 
						FormalParameterExpression primaryTarget = dependingRule.getTargets().get(0); //get the first target
						ModelElementType primaryTargetType = (ModelElementType) primaryTarget.getResolvedType();
						if (primaryTargetType != null) { //if the first target is not null
							if (primaryTargetType.getEcoreType() != null) {
								BagType bag = context.getEolFactory().createBagType();
								bag.setContentType(EcoreUtil.copy(primaryTargetType));
								
								rhs.setResolvedType(bag);
								context.setAssets(bag, rhs);
							}
							else {
								context.getLogBook().addError(primaryTarget, "type not resolved properly");
							}
						}
					}
				}
				else {
					context.getLogBook().addError(rhs, "type not resolved properly");
				}

			}
		}
		else {
			context.getLogBook().addError(lhs, "can only assign values to variables and features");
		}
		return null;
	}
	
	public Type getDynamicType(AnyType anyType)
	{
		while(anyType.getDynamicType() != null)
		{
			if (anyType.getDynamicType() instanceof AnyType) {
				anyType = (AnyType) anyType.getDynamicType();
			}
			else {
				return anyType.getDynamicType();
			}
		}
		return anyType;
	}


}
