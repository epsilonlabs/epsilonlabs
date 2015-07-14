package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.FormalParameterExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerTypeImpl;
import org.junit.Test;

public class FormalParameterExpressionCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("operation foo(bar:Integer) {}");
		
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
		EOLProgram program = (EOLProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition op = program.getOperations().get(0);
		
		assertEquals(op.getParameters().size(), 1);
		assertEquals(op.getParameters().get(0).getClass(), FormalParameterExpressionImpl.class);
		
		FormalParameterExpression formalParameterExpression = op.getParameters().get(0);
		
		assertEquals(formalParameterExpression.getName().getName(), "bar");
		assertEquals(formalParameterExpression.getResolvedType().getClass(), IntegerTypeImpl.class);
		
	}

}
