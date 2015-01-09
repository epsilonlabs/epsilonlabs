package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.junit.Test;

public class AnnotationBlockCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("@colour red \n" +
				"operation foo() {}");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition op = program.getOperations().get(0);
		
		assertFalse(op.getAnnotationBlock() == null);
		
	}

}
