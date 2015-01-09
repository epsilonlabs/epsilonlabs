package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.junit.Test;

public class ModelDeclarationParameterCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("model Core driver EMF {nsuri = \"org.amma.dsl.jdt.core\"};");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		assertEquals(program.getBlock().getStatements().size(), 0);
		
		assertEquals(program.getModelDeclarations().size(), 1);
		
		ModelDeclarationStatement modelDeclarationStatement = program.getModelDeclarations().get(0);
		assertEquals(modelDeclarationStatement.getName().getName().getName(), "Core");
		assertEquals(modelDeclarationStatement.getAlias().size(), 0);
		assertEquals(modelDeclarationStatement.getDriver().getName().getName(), "EMF");
		assertEquals(modelDeclarationStatement.getParameters().size(), 1);

		ModelDeclarationParameter parameter = modelDeclarationStatement.getParameters().get(0);
		assertEquals(parameter.getName().getName(), "nsuri");
		assertEquals(parameter.getValue().getVal(), "org.amma.dsl.jdt.core");

		/*
		EolElement eolElement = AST2EolElementProducer.parseAST("operation foo(bar:Integer) {}");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;

		assertEquals(program.getBlock().getStatements().size(), 0);
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition operationDefinition = program.getOperations().get(0);
		assertEquals(operationDefinition.getName().getName(), "foo");
		assertEquals(operationDefinition.getContextType().getClass(), AnyTypeImpl.class);
		assertEquals(operationDefinition.getReturnType().getClass(), AnyTypeImpl.class);
		*/
		
	}

}
