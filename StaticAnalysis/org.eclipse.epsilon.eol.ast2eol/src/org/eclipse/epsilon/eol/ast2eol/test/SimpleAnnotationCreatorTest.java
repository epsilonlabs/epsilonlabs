package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.junit.Test;

public class SimpleAnnotationCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("@colour red\n" +
				"operation foo() {}");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition op = program.getOperations().get(0);
		
		assertEquals(op.getAnnotationBlock().getSimpleAnnotations().size(), 1);
		SimpleAnnotation simpleAnnotation = op.getAnnotationBlock().getSimpleAnnotations().get(0);
		
		assertEquals(simpleAnnotation.getName().getName(), "colour");
		assertEquals(simpleAnnotation.getValues().get(0).getVal(), "red");
	}

}
