package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.impl.BreakAllStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.junit.Test;

public class BreakAllStatementCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("breakAll; ");
		
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		EOLProgram program = (EOLProgram) eolElement;
		assertEquals(program.getBlock().getStatements().get(0).getClass(), BreakAllStatementImpl.class);
		
	}

}
