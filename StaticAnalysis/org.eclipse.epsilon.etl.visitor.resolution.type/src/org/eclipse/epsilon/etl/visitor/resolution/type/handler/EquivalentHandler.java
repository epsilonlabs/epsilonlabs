package org.eclipse.epsilon.etl.visitor.resolution.type.handler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.BagType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler.AnyOperationDefinitionHandler;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.visitor.resolution.type.context.EtlTypeResolutionContext;

public class EquivalentHandler extends AnyOperationDefinitionHandler{

	public EquivalentHandler(EtlTypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		
		return name.equals("equivalent");
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);

		Expression target = featureCallExpression.getTarget();
		EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
		
		if (target.getResolvedType() instanceof ModelElementType) {
			ModelElementType targetType = (ModelElementType) target.getResolvedType(); //get the target typ
			if (targetType != null) { //if target type is not null
				EClass ecoreType = (EClass) targetType.getEcoreType(); //get the ecore type from the target type
				TransformationRule dependingRule = leContext.getTraceUnitContainerWhichTransforms(ecoreType, false).getTransformationRule(); //get the depending rule from the context
				if (dependingRule == null) { //if depending rule is null, return null
					context.getLogBook().addError(featureCallExpression, "No applicable transformation rule is found");
					return null;
				}
				TransformationRule currentRule = leContext.getCurrentRule(); //get the current rul
				if (currentRule != null) { //if the current rule is not null
					currentRule.getDependingRules().add(dependingRule); //resolve the dependency
				}
				if (dependingRule.getTargets().size() > 0) { //if the depending rule has targets 
					FormalParameterExpression primaryTarget = dependingRule.getTargets().get(0); //get the first target
					ModelElementType primaryTargetType = (ModelElementType) primaryTarget.getResolvedType();
					if (primaryTargetType != null) { //if the first target is not null
						if (primaryTargetType.getEcoreType() != null) {
							result.setReturnType(EcoreUtil.copy(primaryTargetType));
						}
						else {
							context.getLogBook().addError(primaryTarget, "type not resolved properly");
						}
					}
				}
			}

		}
		else if (target.getResolvedType() instanceof CollectionType) {
			CollectionType targetType = (CollectionType) target.getResolvedType();
			ModelElementType targetContentType = (ModelElementType) targetType.getContentType();
			if (targetContentType != null) {
				EClass ecoreType = (EClass) targetContentType.getEcoreType();
				TransformationRule dependingRule = leContext.getTraceUnitContainerWhichTransforms(ecoreType, false).getTransformationRule(); //get the depending rule from the context
				if (dependingRule == null) { //if depending rule is null, return null
					context.getLogBook().addError(featureCallExpression, "No applicable transformation rule is found");
					return null;
				}
				TransformationRule currentRule = leContext.getCurrentRule(); //get the current rul
				if (currentRule != null) { //if the current rule is not null
					currentRule.getDependingRules().add(dependingRule); //resolve the dependency
				}
				if (dependingRule.getTargets().size() > 0) { //if the depending rule has targets 
					FormalParameterExpression primaryTarget = dependingRule.getTargets().get(0); //get the first target
					ModelElementType primaryTargetType = (ModelElementType) primaryTarget.getResolvedType();
					if (primaryTargetType != null) { //if the first target is not null
						if (primaryTargetType.getEcoreType() != null) {
							BagType bag = context.getEolFactory().createBagType();
							bag.setContentType(EcoreUtil.copy(primaryTargetType));
							
							result.setReturnType(bag);
							context.setAssets(bag, result);
						}
						else {
							context.getLogBook().addError(primaryTarget, "type not resolved properly");
						}
					}
				}
			}
			else {
				context.getLogBook().addError(targetType, "type not resolved properly");
			}
		}
		else {
			context.getLogBook().addError(target, "operaiton equivalents() can only be used on model elements"); 
		}
		return result;
	}

}
