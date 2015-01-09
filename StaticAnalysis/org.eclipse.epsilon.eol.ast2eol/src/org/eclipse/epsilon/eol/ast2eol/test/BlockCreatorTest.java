package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.impl.AbortStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.junit.Test;

public class BlockCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("");
		
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		EolProgram program = (EolProgram) eolElement;
		assertTrue(program.getBlock() != null);
	}

}
