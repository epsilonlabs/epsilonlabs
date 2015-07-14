package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.BagType;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.NewExpression;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.BagTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NewExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class BagTypeCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("var a = new Bag(Integer);");
		
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
		EOLProgram program = (EOLProgram) eolElement;
		
		Statement statement = program.getBlock().getStatements().get(0);
		
		assertEquals(statement.getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) statement;
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		assertEquals(assignmentStatement.getRhs().getClass(), NewExpressionImpl.class);
		
		NewExpression newExpression = (NewExpression) assignmentStatement.getRhs();
		
		assertEquals(newExpression.getResolvedType().getClass(), BagTypeImpl.class);
		BagType bagType = (BagType) newExpression.getResolvedType();
		assertEquals(bagType.getContentType().getClass(), IntegerTypeImpl.class);
	}

}
