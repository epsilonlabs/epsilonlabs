package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.TransactionStatement;
import org.eclipse.epsilon.eol.metamodel.impl.AnyTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.FormalParameterExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.TransactionStatementImpl;
import org.junit.Test;

public class TransactionStatementCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("transaction{}");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().size(), 1);
		assertEquals(program.getBlock().getStatements().get(0).getClass(), TransactionStatementImpl.class);
		
		TransactionStatement transactionStatement = (TransactionStatement) program.getBlock().getStatements().get(0);
		assertEquals(transactionStatement.getBody().getExpression(), null);
	}
		

}
