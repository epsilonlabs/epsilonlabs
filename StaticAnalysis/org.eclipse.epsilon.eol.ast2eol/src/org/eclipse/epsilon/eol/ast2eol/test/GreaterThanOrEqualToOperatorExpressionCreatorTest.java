package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.GreaterThanOperatorExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.GreaterThanOrEqualToOperatorExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class GreaterThanOrEqualToOperatorExpressionCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a = b >= c; ");
		
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		EolProgram program = (EolProgram) eolElement;
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		
		assertEquals(assignmentStatement.getRhs().getClass(), GreaterThanOrEqualToOperatorExpressionImpl.class);
		
		GreaterThanOrEqualToOperatorExpression greaterThanOrEqualToOperatorExpression = (GreaterThanOrEqualToOperatorExpression) assignmentStatement.getRhs();
		
		assertEquals(greaterThanOrEqualToOperatorExpression.getLhs().getClass(), NameExpressionImpl.class);
		NameExpression lhs = (NameExpression) greaterThanOrEqualToOperatorExpression.getLhs();
		assertEquals(lhs.getName(), "b");
		
		assertEquals(greaterThanOrEqualToOperatorExpression.getRhs().getClass(), NameExpressionImpl.class);
		NameExpression rhs = (NameExpression) greaterThanOrEqualToOperatorExpression.getRhs();
		assertEquals(rhs.getName(), "c");
	}

}
