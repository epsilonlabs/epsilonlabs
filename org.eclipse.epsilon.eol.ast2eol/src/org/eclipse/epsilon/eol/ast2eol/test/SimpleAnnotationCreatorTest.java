package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotationStatement;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.junit.Test;

public class SimpleAnnotationCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("@colour red\n" +
				"operation foo() {}");
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
		EOLProgram program = (EOLProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition op = program.getOperations().get(0);
		
		assertEquals(op.getAnnotationBlock().getStatements().size(), 1);
		SimpleAnnotationStatement simpleAnnotation = (SimpleAnnotationStatement) op.getAnnotationBlock().getStatements().get(0);
		
		assertEquals(simpleAnnotation.getName().getName(), "colour");
		assertEquals(simpleAnnotation.getValues().get(0).getValue(), "red");
	}

}
