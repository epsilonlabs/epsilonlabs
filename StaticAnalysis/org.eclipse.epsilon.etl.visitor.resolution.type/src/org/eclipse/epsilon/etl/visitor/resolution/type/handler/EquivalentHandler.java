package org.eclipse.epsilon.etl.visitor.resolution.type.handler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.BagType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler.AnyOperationDefinitionHandler;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.etl.metamodel.RuleDependency;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.visitor.resolution.type.context.EtlTypeResolutionContext;
import org.eclipse.epsilon.etl.visitor.resolution.type.context.TraceUnitContainer;

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
		
		//get the standard library operation definition contianer (quite a long name i know...)
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = null;
		
		if (argTypes.size() == 0) {
			//get the operation by name and arg types
			result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		}
		
		else {
			//get the operation by name and arg types
			result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), new ArrayList<Type>());
		}
		
		ArrayList<StringExpression> parameters = new ArrayList<StringExpression>();
		
		MethodCallExpression mce = (MethodCallExpression) featureCallExpression;
		for(Expression expr: mce.getArguments())
		{
			if (expr.getResolvedType() instanceof StringType) {
				if (expr instanceof StringExpression) {
					parameters.add((StringExpression) expr);
				}
				else {
					context.getLogBook().addWarning(expr, "use of String expression is recommended");
				}
			}
			else {
				context.getLogBook().addError(expr, "This expression should be of type String");
			}
		}

		//get the target of the feature call expression
		Expression target = featureCallExpression.getTarget();
		
		//cast the context to be the etl type resolution context
		EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
		
		//if the target has a resolved type
		if (target.getResolvedType() != null) {
			//if target type is model element type
			if (target.getResolvedType() instanceof ModelElementType) {
				//get the target type
				ModelElementType targetType = (ModelElementType) target.getResolvedType();

				//get the ecore type from the target type
				EClass ecoreType = (EClass) targetType.getEcoreType(); 
				ArrayList<TraceUnitContainer> containers = null;
				if (parameters.size() == 0) {
					containers = leContext.getTraceUnitContainersWhichTransforms(ecoreType);
				}
				else {
					containers = leContext.getTraceUnitContainersWhichTransforms(ecoreType, parameters);
				}
				//get the containers
				//ArrayList<TraceUnitContainer> containers = leContext.getTraceUnitContainersForEquivalent(ecoreType);
				//if there are no containers found, report error
				if (containers.size() == 0) {
					context.getLogBook().addError(featureCallExpression, "No applicable transformation rule is found");
					return null;
				}
				//if there are contianers
				else {
					//iterate
					for(TraceUnitContainer tuc : containers)
					{
						//get the depending rule 
						TransformationRule dependingRule = tuc.getTransformationRule();
						//get the current rule
						TransformationRule currentRule = leContext.getCurrentRule();
						//if the current rule is not null
						if (currentRule != null) {
							//create rule dependency and attach the leads
							RuleDependency ruleDependency = leContext.getEtlFactory().createRuleDependency();
							ruleDependency.setDependingRule(dependingRule);
							ruleDependency.setSourceElement(featureCallExpression);
							context.setAssets(ruleDependency, currentRule);

							//resolve the dependency
							currentRule.getResolvedRuleDependencies().add(ruleDependency); 
						}
					}
					
					//get the first rule
					TransformationRule firstRule = containers.get(0).getTransformationRule();
					
					//if the depending rule has targets
					if (firstRule.getTargets().size() > 0) {
						//get the first target
						FormalParameterExpression primaryTarget = firstRule.getTargets().get(0); 
						//get the type fot he primary target
						ModelElementType primaryTargetType = (ModelElementType) primaryTarget.getResolvedType();
						//if the first target is not null
						if (primaryTargetType != null) {
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
			//else if target type is a collection type
			else if (target.getResolvedType() instanceof CollectionType) {
				//get the target type
				CollectionType targetType = (CollectionType) target.getResolvedType();
				
				if (targetType.getContentType() != null) {
					//get the target content type
					ModelElementType targetContentType = (ModelElementType) targetType.getContentType();
					
					//get the target ecore type
					EClass ecoreType = (EClass) targetContentType.getEcoreType();
					
					//get the containers with the ecore
					ArrayList<TraceUnitContainer> containers = null;
					
					if (parameters.size() == 0) {
						containers = leContext.getTraceUnitContainersWhichTransforms(ecoreType);

					}
					else {
						containers = leContext.getTraceUnitContainersWhichTransforms(ecoreType, parameters);
					}

					
					//if no containers, report error
					if (containers.size() == 0) {
						context.getLogBook().addError(featureCallExpression, "No applicable transformation rule is found");
						return null;
					}

					//iterate TUCs, TUC rules
					for(TraceUnitContainer tuc : containers)
					{
						//get the depending rule from the context
						TransformationRule dependingRule = tuc.getTransformationRule();
						//get the current rule
						TransformationRule currentRule = leContext.getCurrentRule();
						//if the current rule is not null
						if (currentRule != null) { 
							//create rule dependency and attach the leads
							RuleDependency ruleDependency = leContext.getEtlFactory().createRuleDependency();
							ruleDependency.setDependingRule(dependingRule);
							ruleDependency.setSourceElement(featureCallExpression);
							context.setAssets(ruleDependency, currentRule);
							
							//resolve the dependency
							currentRule.getResolvedRuleDependencies().add(ruleDependency); 
						}
					}
					//create a bag type and assign it to the result
					BagType bag = context.getEolFactory().createBagType();
					bag.setContentType(context.getEolFactory().createAnyType());
					result.setReturnType(bag);
					context.setAssets(bag, result);
				
				}
				else {
					context.getLogBook().addError(targetType, "type not resolved properly");
				}
			}
			else {
				context.getLogBook().addError(target, "operaiton equivalents() can only be used on model elements and collections"); 
			}
			supressErrorForAssignment(featureCallExpression);
			return result;
		}
		else {
			return null;
		}
	}
	
	public void supressErrorForAssignment(FeatureCallExpression featureCallExpression)
	{
		EolElement container = featureCallExpression;
		Expression rhs = null;
		while(container != null)
		{
			if (container.getContainer() instanceof AssignmentStatement) {
				rhs = (Expression) container;
				EtlTypeResolutionContext leContext = (EtlTypeResolutionContext) context;
				leContext.addSupression(rhs);
//				ArrayList<log.Error> errors = context.getLogBook().getErrors();
//				for(log.Error error: errors)
//				{
//					if (error.getDomElement().equals(rhs)) {
//						errors.remove(error);
//					}
//				}
//				context.getLogBook().addWarning(rhs, "potential type mismatch");
				break;
			}
			container = container.getContainer();
		}
	}
	
}
