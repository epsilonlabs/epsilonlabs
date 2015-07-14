package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.DeleteStatement;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.impl.DeleteStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.junit.Test;

public class DeleteStatementCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("delete a; ");
		
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		EOLProgram program = (EOLProgram) eolElement;
		assertEquals(program.getBlock().getStatements().get(0).getClass(), DeleteStatementImpl.class);
		
		DeleteStatement deleteStatement = (DeleteStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(deleteStatement.getExpression().getClass(), NameExpressionImpl.class);
		
		NameExpression nameExpression = (NameExpression) deleteStatement.getExpression();
		
		assertEquals(nameExpression.getName(), "a");
	}

}
