package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.NewExpression;
import org.eclipse.epsilon.eol.metamodel.SequenceType;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NewExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.SequenceTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class NewExpressionCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("var a = new Sequence(Integer);");
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
		EOLProgram program = (EOLProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) assignmentStatement.getLhs();
		assertEquals(variableDeclarationExpression.getName().getName(), "a");
		
		assertEquals(assignmentStatement.getRhs().getClass(), NewExpressionImpl.class);
		NewExpression newExpression = (NewExpression) assignmentStatement.getRhs();
		
		
		assertEquals(newExpression.getResolvedType().getClass(), SequenceTypeImpl.class);
		SequenceType sequenceType = (SequenceType) newExpression.getResolvedType();
		assertEquals(sequenceType.getContentType().getClass(), IntegerTypeImpl.class);
	}

}
