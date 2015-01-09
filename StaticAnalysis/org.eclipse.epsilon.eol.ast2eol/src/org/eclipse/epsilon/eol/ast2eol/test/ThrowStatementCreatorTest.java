package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.ReturnStatement;
import org.eclipse.epsilon.eol.metamodel.ThrowStatement;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ReturnStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ThrowStatementImpl;
import org.junit.Test;

public class ThrowStatementCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("throw 1;");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().size(), 1);
		assertEquals(program.getBlock().getStatements().get(0).getClass(), ThrowStatementImpl.class);
		ThrowStatement throwStatement = (ThrowStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(throwStatement.getThrown().getClass(), IntegerExpressionImpl.class);
		IntegerExpression thrown = (IntegerExpression) throwStatement.getThrown();
		
		assertEquals(thrown.getVal(), 1);
	}

}
