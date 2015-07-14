package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.ExecutableAnnotationStatement;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NotEqualsOperatorExpressionImpl;
import org.junit.Test;

public class ExecutableAnnotationCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("$pre self <> null \n" +
				"operation foo() {} ");
		
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		EOLProgram program = (EOLProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition operationDefinition = program.getOperations().get(0);
		
		assertTrue(operationDefinition.getAnnotationBlock() != null);
		
		AnnotationBlock annotationBlock = operationDefinition.getAnnotationBlock();
		
		assertEquals(annotationBlock.getStatements().size(), 1);
		
		ExecutableAnnotationStatement executableAnnotation = (ExecutableAnnotationStatement) annotationBlock.getStatements().get(0);
		
		assertEquals(executableAnnotation.getName().getName(), "pre");
		assertEquals(executableAnnotation.getExpression().getClass(), NotEqualsOperatorExpressionImpl.class);
		
		NotEqualsOperatorExpression notEqualsOperatorExpression = (NotEqualsOperatorExpression) executableAnnotation.getExpression();
		
		assertEquals(notEqualsOperatorExpression.getLhs().getClass(), NameExpressionImpl.class);
		assertEquals(notEqualsOperatorExpression.getRhs().getClass(), NameExpressionImpl.class);
	}

}
