package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.BooleanExpression;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.ExprList;
import org.eclipse.epsilon.eol.metamodel.ExpressionStatement;
import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.SequenceExpression;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.BooleanExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExprListImpl;
import org.eclipse.epsilon.eol.metamodel.impl.FOLMethodCallExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.MethodCallExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.SequenceExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.StringExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class FOLMethodCallExpressionCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a = Sequence{1,\"hello\",true}; \n" +
		"a.select(v|v.isKindOf(Integer)).println();");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		Statement statement = program.getBlock().getStatements().get(0);
		
		assertEquals(statement.getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) statement;
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		assertEquals(assignmentStatement.getRhs().getClass(), SequenceExpressionImpl.class);
		
		SequenceExpression sequenceExpression = (SequenceExpression) assignmentStatement.getRhs();
		assertEquals(sequenceExpression.getParameterList().getClass(), ExprListImpl.class);
		
		ExprList exprList = (ExprList) sequenceExpression.getParameterList();
		assertEquals(exprList.getExpressions().get(0).getClass(), IntegerExpressionImpl.class);
		IntegerExpression integerExpression = (IntegerExpression) exprList.getExpressions().get(0);
		assertEquals(integerExpression.getVal(), 1);
		
		assertEquals(exprList.getExpressions().get(1).getClass(), StringExpressionImpl.class);
		StringExpression stringExpression = (StringExpression) exprList.getExpressions().get(1);
		assertEquals(stringExpression.getVal(), "hello");
		
		assertEquals(exprList.getExpressions().get(2).getClass(), BooleanExpressionImpl.class);
		BooleanExpression booleanExpression = (BooleanExpression) exprList.getExpressions().get(2);
		assertEquals(booleanExpression.isVal(), true);
		
		
		ExpressionStatement expressionStatement = (ExpressionStatement) program.getBlock().getStatements().get(1);
		
		assertEquals(expressionStatement.getExpression().getClass(), MethodCallExpressionImpl.class);

		MethodCallExpression methodCallExpression = (MethodCallExpression) expressionStatement.getExpression();
		
		assertEquals(methodCallExpression.getTarget().getClass(), FOLMethodCallExpressionImpl.class);
		
		FOLMethodCallExpression folMethodCallExpression = (FOLMethodCallExpression) methodCallExpression.getTarget();
		assertEquals(folMethodCallExpression.getTarget().getClass(), NameExpressionImpl.class);
		NameExpression targetNameExpression = (NameExpression) folMethodCallExpression.getTarget();
		assertEquals(targetNameExpression.getName(), "a");
		
		
		assertEquals(folMethodCallExpression.getMethod().getName(), "select");
		assertEquals(folMethodCallExpression.getIterator().getName().getName(), "v");
		assertEquals(folMethodCallExpression.getCondition().getClass(), MethodCallExpressionImpl.class);
		
		MethodCallExpression condition = (MethodCallExpression) folMethodCallExpression.getCondition();
		assertEquals(condition.getTarget().getClass(), NameExpressionImpl.class);
		assertEquals(condition.getMethod().getName(), "isKindOf");
		assertEquals(condition.getArguments().size(), 1);
		
		assertEquals(methodCallExpression.getMethod().getName(), "println");
	}

}
