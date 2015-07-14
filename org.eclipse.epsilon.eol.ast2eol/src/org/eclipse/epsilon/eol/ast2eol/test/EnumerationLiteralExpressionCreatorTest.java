package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EnumerationLiteralExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class EnumerationLiteralExpressionCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("var a = A!B#C; ");
		
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		EOLProgram program = (EOLProgram) eolElement;
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		
		assertEquals(assignmentStatement.getRhs().getClass(), EnumerationLiteralExpressionImpl.class);
		
		EnumerationLiteralExpression enumerationLiteralExpression = (EnumerationLiteralExpression) assignmentStatement.getRhs();
		
		assertEquals(enumerationLiteralExpression.getModel().getName(), "A");
		assertEquals(enumerationLiteralExpression.getEnumeration().getName(), "B");
		assertEquals(enumerationLiteralExpression.getLiteral().getName(), "C");
	}
	
	@Test
	public void test2() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("var a = B#C; ");
		
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		EOLProgram program = (EOLProgram) eolElement;
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		
		assertEquals(assignmentStatement.getRhs().getClass(), EnumerationLiteralExpressionImpl.class);
		
		EnumerationLiteralExpression enumerationLiteralExpression = (EnumerationLiteralExpression) assignmentStatement.getRhs();
		
		assertEquals(enumerationLiteralExpression.getModel(), null);
		assertEquals(enumerationLiteralExpression.getEnumeration().getName(), "B");
		assertEquals(enumerationLiteralExpression.getLiteral().getName(), "C");
	}
	
	

}
