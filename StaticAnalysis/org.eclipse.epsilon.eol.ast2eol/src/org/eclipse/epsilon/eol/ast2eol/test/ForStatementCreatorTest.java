package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.ExpRange;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.SequenceExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExpRangeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExpressionOrStatementBlockImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ForStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.MethodCallExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.SequenceExpressionImpl;
import org.junit.Test;

public class ForStatementCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("for(a in Sequence{1..100})" +
				"	a.println();");
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), ForStatementImpl.class);
		
		ForStatement forStatement = (ForStatement) program.getBlock().getStatements().get(0);
		assertEquals(forStatement.getBody().getClass(), ExpressionOrStatementBlockImpl.class);
		ExpressionOrStatementBlock expressionOrStatementBlock = forStatement.getBody();
		
		assertTrue(expressionOrStatementBlock.getBlock() == null);
		assertTrue(expressionOrStatementBlock.getExpression() != null);
		
		Expression expression = expressionOrStatementBlock.getExpression();
		
		assertEquals(expression.getClass(), MethodCallExpressionImpl.class);
		
		MethodCallExpression methodCallExpression = (MethodCallExpression) expression;
		
		assertEquals(methodCallExpression.getTarget().getClass(), NameExpressionImpl.class);
		assertEquals(methodCallExpression.getMethod().getName(), "println");
		assertEquals(methodCallExpression.getArguments().size(), 0);
		
		assertEquals(forStatement.getIterator().getName().getName(), "a");
		assertEquals(forStatement.getIterated().getClass(), SequenceExpressionImpl.class);
		
		SequenceExpression sequenceExpression = (SequenceExpression) forStatement.getIterated();
		assertEquals(sequenceExpression.getParameterList().getClass(), ExpRangeImpl.class);
		ExpRange expRange = (ExpRange) sequenceExpression.getParameterList();
		assertEquals(expRange.getStart().getClass(), IntegerExpressionImpl.class);
		assertEquals(expRange.getEnd().getClass(), IntegerExpressionImpl.class);
		
	}

}
