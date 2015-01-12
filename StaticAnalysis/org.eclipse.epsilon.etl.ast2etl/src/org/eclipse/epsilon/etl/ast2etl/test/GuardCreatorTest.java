package org.eclipse.epsilon.etl.ast2etl.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.NotOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ModelElementTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.PropertyCallExpressionImpl;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl;
import org.junit.Test;

public class GuardCreatorTest {

	@Test
	public void test() {
		EolElement element = AST2EtlElementProducer.parseAST("rule A2D \n" +
				"transform a: Source!A\n" +
				"to e: Target!E {\n" +
				"	guard: a <> null \n" +
				"	e.f = a.b.equivalents();\n" +
				"}");
		
		assertEquals(element.getClass(), EtlProgramImpl.class);
		
		EtlProgram etlProgram = (EtlProgram) element;
		assertEquals(etlProgram.getImports().size(), 0);
		assertEquals(etlProgram.getModelDeclarations().size(), 0);
		assertEquals(etlProgram.getPreBlocks().size(), 0);
		assertEquals(etlProgram.getPostBlocks().size(), 0);
		assertEquals(etlProgram.getTransformationRules().size(), 1);
		assertEquals(etlProgram.getOperations().size(), 0);
		
		TransformationRule rule1 = etlProgram.getTransformationRules().get(0);
		assertEquals(rule1.getName().getName(), "A2D");
		assertEquals(rule1.getSource().getName().getName(), "a");
		assertEquals(rule1.getSource().getResolvedType().getClass(), ModelElementTypeImpl.class);
		ModelElementType source1Type = (ModelElementType) rule1.getSource().getResolvedType();
		assertEquals(source1Type.getModelName(), "Source");
		assertEquals(source1Type.getElementName(), "A");
		
		assertEquals(rule1.getTargets().size(), 1);
		FormalParameterExpression rule1target = rule1.getTargets().get(0);
		assertEquals(rule1target.getName().getName(), "e");
		assertEquals(rule1target.getResolvedType().getClass(), ModelElementTypeImpl.class);
		ModelElementType rule1targetType = (ModelElementType) rule1target.getResolvedType();
		assertEquals(rule1targetType.getModelName(), "Target");
		assertEquals(rule1targetType.getElementName(), "E");
		
		Guard guard = rule1.getGuard();
		assertEquals(guard.getCondition().getBlock(), null);
		NotEqualsOperatorExpression notEqualsOperatorExpression = (NotEqualsOperatorExpression) guard.getCondition().getExpression();
		NameExpression conditionLhs = (NameExpression) notEqualsOperatorExpression.getLhs();
		assertEquals(conditionLhs.getName(), "a");
		NameExpression conditionRhs = (NameExpression) notEqualsOperatorExpression.getRhs();
		assertEquals(conditionRhs.getName(), "null");
		
		assertEquals(rule1.getBody().getStatements().size(), 1);
		Statement statement1 = rule1.getBody().getStatements().get(0);
		assertEquals(statement1.getClass(), AssignmentStatementImpl.class);
		AssignmentStatement assignmentStatement = (AssignmentStatement) statement1;
		assertEquals(assignmentStatement.getLhs().getClass(), PropertyCallExpressionImpl.class);
		PropertyCallExpression lhs = (PropertyCallExpression) assignmentStatement.getLhs();
		assertEquals(lhs.getTarget().getClass(), NameExpressionImpl.class);
		NameExpression target = (NameExpression) lhs.getTarget();
		assertEquals(target.getName(), "e");
		NameExpression property = lhs.getProperty();
		assertEquals(property.getName(), "f");
		
		MethodCallExpression rhs = (MethodCallExpression) assignmentStatement.getRhs();
		PropertyCallExpression rhsTarget = (PropertyCallExpression) rhs.getTarget();
		NameExpression rhsTargetTarget = (NameExpression) rhsTarget.getTarget();
		assertEquals(rhsTargetTarget.getName(), "a");
		assertEquals(rhsTarget.getProperty().getName(), "b");
		assertEquals(rhs.getMethod().getName(), "equivalents");
			
	}

}
