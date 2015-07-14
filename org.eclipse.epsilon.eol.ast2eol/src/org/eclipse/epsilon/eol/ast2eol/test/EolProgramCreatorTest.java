package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.junit.Test;

public class EolProgramCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("");
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
	}

}
