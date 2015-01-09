package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.ExecutableAnnotation;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EnumerationLiteralExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NotEqualsOperatorExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class ExecutableAnnotationCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("$pre self <> null \n" +
				"operation foo() {} ");
		
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition operationDefinition = program.getOperations().get(0);
		
		assertTrue(operationDefinition.getAnnotationBlock() != null);
		
		AnnotationBlock annotationBlock = operationDefinition.getAnnotationBlock();
		
		assertEquals(annotationBlock.getSimpleAnnotations().size(), 0);
		assertEquals(annotationBlock.getExecutableAnnotations().size(), 1);
		
		ExecutableAnnotation executableAnnotation = annotationBlock.getExecutableAnnotations().get(0);
		
		assertEquals(executableAnnotation.getName().getName(), "pre");
		assertEquals(executableAnnotation.getExpression().getClass(), NotEqualsOperatorExpressionImpl.class);
		
		NotEqualsOperatorExpression notEqualsOperatorExpression = (NotEqualsOperatorExpression) executableAnnotation.getExpression();
		
		assertEquals(notEqualsOperatorExpression.getLhs().getClass(), NameExpressionImpl.class);
		assertEquals(notEqualsOperatorExpression.getRhs().getClass(), NameExpressionImpl.class);
	}

}
