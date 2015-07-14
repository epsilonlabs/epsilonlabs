package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.metamodel.ExpressionRange;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.SequenceExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExpressionOrStatementBlockImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExpressionRangeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ForStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.MethodCallExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.SequenceExpressionImpl;
import org.junit.Test;

public class ForStatementCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("for(a in Sequence{1..100})" +
				"	a.println();");
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
		EOLProgram program = (EOLProgram) eolElement;
		
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
		assertEquals(forStatement.getCondition().getClass(), SequenceExpressionImpl.class);
		
		SequenceExpression sequenceExpression = (SequenceExpression) forStatement.getCondition();
		assertEquals(sequenceExpression.getParameterList().getClass(), ExpressionRangeImpl.class);
		ExpressionRange expRange = (ExpressionRange) sequenceExpression.getParameterList();
		assertEquals(expRange.getStart().getClass(), IntegerExpressionImpl.class);
		assertEquals(expRange.getEnd().getClass(), IntegerExpressionImpl.class);
		
	}

}
