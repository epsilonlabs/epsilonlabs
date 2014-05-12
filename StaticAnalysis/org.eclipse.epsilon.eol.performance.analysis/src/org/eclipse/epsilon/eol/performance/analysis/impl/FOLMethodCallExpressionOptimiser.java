package org.eclipse.epsilon.eol.performance.analysis.impl;

import metamodel.connectivity.emf.EMetaModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.performance.analysis.context.PerformanceAnalysisContext;

public class FOLMethodCallExpressionOptimiser extends FOLMethodCallExpressionVisitor<PerformanceAnalysisContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			PerformanceAnalysisContext context,
			EolVisitorController<PerformanceAnalysisContext, Object> controller) {
		// TODO Auto-generated method stub
		matchSelectPattern(fOLMethodCallExpression, context);
		matchPotentialIndexablePattern(fOLMethodCallExpression, context);
		return null;
	}

	public void matchSelectPattern(FOLMethodCallExpression folMethodCallExpression, PerformanceAnalysisContext context)
	{
		if (folMethodCallExpression.getTarget() instanceof PropertyCallExpression) {
			PropertyCallExpression target = (PropertyCallExpression) folMethodCallExpression.getTarget();
			if (target.getProperty().getName().equals("all")) {
				if (folMethodCallExpression.getMethod().getName().equals("select") || folMethodCallExpression.getMethod().getName().equals("selectOne")) {
					if(folMethodCallExpression.getConditions().size() == 1) //interested in condition number = 1
					{
						Expression expr = folMethodCallExpression.getConditions().get(0);
						if (expr instanceof EqualsOperatorExpression) { //if condition is equals operator
							EqualsOperatorExpression equalsOperatorExpression = (EqualsOperatorExpression) expr;
							if (equalsOperatorExpression.getLhs() instanceof PropertyCallExpression) { //if lhs of equals operator is property call
								PropertyCallExpression lhs = (PropertyCallExpression) equalsOperatorExpression.getLhs();
								if (lhs.getTarget() instanceof NameExpression) { //if the target of the property call is a simple name
									NameExpression nameExpression = (NameExpression) lhs.getTarget();
									FormalParameterExpression iterator = folMethodCallExpression.getIterators().get(0); //there should be only one iterator
									if (nameExpression.getResolvedContent().equals(iterator)) { //if the target is the iterator
										if (equalsOperatorExpression.getRhs() instanceof NameExpression) { //if the rhs of the equals operator is a simple name
											NameExpression rhs = (NameExpression) equalsOperatorExpression.getRhs();
											if (rhs.getResolvedContent() instanceof VariableDeclarationExpression) { //if the simple name points to a variable declaration
												if ((rhs.getResolvedType() instanceof ModelElementType) && (lhs.getResolvedType() instanceof ModelElementType)) { //if both of the lhs and rhs are model element types
													if (lhs.getResolvedType().getClass().equals(rhs.getResolvedType().getClass())) { //if the types are equal which they should be
														ModelElementType modelElementType = (ModelElementType) lhs.getTarget().getResolvedType();
														String modelName = modelElementType.getModelName();
														String elementName = modelElementType.getElementName();
														EMetaModel mm = context.getMetaModel(modelName);
														if (mm != null) {
															EClass eClass = mm.getMetaClass(elementName);
															EReference eReference = mm.getEReference(eClass, lhs.getProperty().getName());
															if (eReference != null) {
																if(!eReference.isMany())
																{
																	if (eReference.getEOpposite() != null) {
																		ModelElementType rhsType = (ModelElementType) rhs.getResolvedType();
																		if(eReference.getEOpposite().getEType().getClass().equals(rhsType.getEcoreType().getClass()))
																		{
																			if (folMethodCallExpression.getMethod().getName().equals("selectOne")) {
																				context.getLogBook().addWarning(folMethodCallExpression, "expression should be read as: " + rhs.getName() + "." + eReference.getEOpposite().getName() + ".first");
																			}
																			if (folMethodCallExpression.getMethod().getName().equals("select")) {
																				context.getLogBook().addWarning(folMethodCallExpression, "expression should be read as: " + rhs.getName() + "." + eReference.getEOpposite().getName());
																			}
																		}
																	}
																}
															}
														}
													}													
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void matchPotentialIndexablePattern(FOLMethodCallExpression folMethodCallExpression, PerformanceAnalysisContext context)
	{
		if (folMethodCallExpression.getTarget() instanceof PropertyCallExpression) {
			PropertyCallExpression target = (PropertyCallExpression) folMethodCallExpression.getTarget();
			if (target.getProperty().getName().equals("all")) {
				if (folMethodCallExpression.getMethod().getName().equals("select")) {
					if(folMethodCallExpression.getConditions().size() == 1) //interested in condition number = 1
					{
						Expression expr = folMethodCallExpression.getConditions().get(0);
						if (expr instanceof EqualsOperatorExpression) { //if condition is equals operator
							EqualsOperatorExpression equalsOperatorExpression = (EqualsOperatorExpression) expr;
							if (equalsOperatorExpression.getLhs() instanceof PropertyCallExpression) { //if lhs of equals operator is property call
 								PropertyCallExpression lhs = (PropertyCallExpression) equalsOperatorExpression.getLhs();
								if (lhs.getTarget() instanceof NameExpression) { //if the target of the property call is a simple name
									NameExpression nameExpression = (NameExpression) lhs.getTarget();
									FormalParameterExpression iterator = folMethodCallExpression.getIterators().get(0); //there should be only one iterator
									if (nameExpression.getResolvedContent().equals(iterator)) { //if the target is the iterator
										if (equalsOperatorExpression.getRhs().getResolvedType() instanceof PrimitiveType) { //if the rhs of the equals operator is a simple name
											//PrimitiveExpression rhs = (PrimitiveExpression) equalsOperatorExpression.getRhs();
											if (inLoop(folMethodCallExpression)) {
												context.getLogBook().addWarning(folMethodCallExpression, "This expression may perform better with an indexing system");
											}
											if (getOperationDefinition(folMethodCallExpression) != null) {
												context.registerOperationWithPerformancePotential(getOperationDefinition(folMethodCallExpression), folMethodCallExpression);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public boolean inLoop(EolElement dom)
	{
		EolElement container = dom.getContainer();
		while(!(container instanceof Program))
		{
			if (container instanceof ForStatement || container instanceof WhileStatement) {
				if (container instanceof ForStatement) {
					if (isContainedBy(dom, ((ForStatement)container).getIterated())) {
						return false;
					}
					else {
						return true;
					}
				}
				else if (container instanceof WhileStatement) {
					if (isContainedBy(dom, ((WhileStatement)container).getCondition())) {
						return false;
					}
					else {
						return true;
					}
				}
			}
			container = container.getContainer();
		}
		return false;
	}
	
	public boolean isContainedBy(EolElement dom, EolElement container)
	{
		EolElement domContainer = dom;
		while(!(domContainer instanceof Program))
		{
			if (domContainer.equals(container)) {
				return true;
			}
			domContainer = domContainer.getContainer();
		}
		return false;
	}
	
	public boolean inOperationDefinition(EolElement dom)
	{
		EolElement container = dom.getContainer();
		while(!(container instanceof Program))
		{
			if (container instanceof OperationDefinition) {
				return true;
			}
			container = container.getContainer();
		}
		return false;
	}
	
	public OperationDefinition getOperationDefinition(EolElement dom)
	{
		EolElement container = dom.getContainer();
		while(!(container instanceof Program))
		{
			if (container instanceof OperationDefinition) {
				return (OperationDefinition) container;
			}
			container = container.getContainer();
		}
		return null;
	}

}
