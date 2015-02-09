package org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.MinusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PlusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.context.MutantGeneratorContext;

public class PlusOperatorExpressionMutator extends PlusOperatorExpressionVisitor<MutantGeneratorContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			MutantGeneratorContext context,
			EolVisitorController<MutantGeneratorContext, Object> controller) {
		EolElement container = plusOperatorExpression.getContainer();
		EReference ref = plusOperatorExpression.eContainmentFeature();
		if (container != null) {
			MinusOperatorExpression minusOperatorExpression = context.getEolFactory().createMinusOperatorExpression();
			Expression lhsExpression = plusOperatorExpression.getLhs();
			Expression rhsExpression = plusOperatorExpression.getRhs();
			minusOperatorExpression.setLhs(lhsExpression);
			minusOperatorExpression.setRhs(rhsExpression);
			
			minusOperatorExpression.setColumn(plusOperatorExpression.getColumn());
			minusOperatorExpression.setLine(plusOperatorExpression.getLine());
			minusOperatorExpression.setRegion(plusOperatorExpression.getRegion());
			
			container.eSet(ref, minusOperatorExpression);
			minusOperatorExpression.setContainer(container);
		}
		return null;
	}

}
