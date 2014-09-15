package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import java.util.ArrayList;

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
import org.eclipse.epsilon.etl.visitor.resolution.type.context.TraceUnitContainer;

public class SpecialAssignmentStatementTypeResolver extends SpecialAssignmentStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SpecialAssignmentStatement specialAssignmentStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get lhs expression
		Expression lhs = specialAssignmentStatement.getLhs(); 
		//get rhs expression
		Expression rhs = specialAssignmentStatement.getRhs();
		
		//if the lhs is a property call, a name expression or a variable declaration
		if (lhs instanceof PropertyCallExpression || lhs instanceof NameExpression || lhs instanceof VariableDeclarationExpression) {
			//visit rhs
			controller.visit(rhs, context); 
			//visit lhs
			controller.visit(lhs, context); 
			
			//cast the context to be an ETL type resolution context
			EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
			
			
			//if both the lhs and the rhs are model element types
			if (lhs.getResolvedType() instanceof ModelElementType && rhs.getResolvedType() instanceof ModelElementType) {
				//get the rhs type
				ModelElementType rhsType = (ModelElementType) rhs.getResolvedType();
				//get the ecoretype of the rhs type
				EClass ecoreType = (EClass) rhsType.getEcoreType();
				
				//if ecore type is not null
				if (ecoreType != null) {
					//get the depending rule from the context
					TransformationRule dependingRule = leContext.getTraceUnitContainerWhichTransforms(ecoreType).getTransformationRule(); 
					
					//if depending rule is null, return null
					if (dependingRule == null) { 
						context.getLogBook().addError(specialAssignmentStatement, "No applicable transformation rule is found");
						return null;
					}
					
					TransformationRule currentRule = leContext.getCurrentRule(); //get the current rule
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
					
					ArrayList<TraceUnitContainer> containers = leContext.getTraceUnitContainersWhichTransforms(ecoreType);
					for(TraceUnitContainer tuc : containers)
					{
						TransformationRule dependingRule = tuc.getTransformationRule(); //get the depending rule from the context
						TransformationRule currentRule = leContext.getCurrentRule(); //get the current rul
						if (currentRule != null) { //if the current rule is not null
							RuleDependency ruleDependency = leContext.getEtlFactory().createRuleDependency();
							ruleDependency.setDependingRule(dependingRule);
							ruleDependency.setSourceElement(specialAssignmentStatement);
							context.setAssets(ruleDependency, currentRule);

							currentRule.getResolvedRuleDependencies().add(ruleDependency); //resolve the dependency
						}
					}
					BagType bag = context.getEolFactory().createBagType();
					bag.setContentType(context.getEolFactory().createAnyType());
					rhs.setResolvedType(bag);
					context.setAssets(bag, rhs);


//					TransformationRule dependingRule = leContext.getTraceUnitContainerWhichTransforms(ecoreType, false).getTransformationRule(); //get the depending rule from the context
//					if (dependingRule == null) { //if depending rule is null, return null
//						context.getLogBook().addError(specialAssignmentStatement, "No applicable transformation rule is found");
//						return null;
//					}
//					TransformationRule currentRule = leContext.getCurrentRule(); //get the current rul
//					if (currentRule != null) { //if the current rule is not null
//						RuleDependency ruleDependency = leContext.getEtlFactory().createRuleDependency();
//						ruleDependency.setDependingRule(dependingRule);
//						ruleDependency.setSourceElement(specialAssignmentStatement);
//						context.setAssets(ruleDependency, currentRule);
//
//						currentRule.getResolvedRuleDependencies().add(ruleDependency); //resolve the dependency
//					}
//					if (dependingRule.getTargets().size() > 0) { //if the depending rule has targets 
//						FormalParameterExpression primaryTarget = dependingRule.getTargets().get(0); //get the first target
//						ModelElementType primaryTargetType = (ModelElementType) primaryTarget.getResolvedType();
//						if (primaryTargetType != null) { //if the first target is not null
//							if (primaryTargetType.getEcoreType() != null) {
//								BagType bag = context.getEolFactory().createBagType();
//								bag.setContentType(EcoreUtil.copy(primaryTargetType));
//								
//								rhs.setResolvedType(bag);
//								context.setAssets(bag, rhs);
//							}
//							else {
//								context.getLogBook().addError(primaryTarget, "type not resolved properly");
//							}
//						}
//					}
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
