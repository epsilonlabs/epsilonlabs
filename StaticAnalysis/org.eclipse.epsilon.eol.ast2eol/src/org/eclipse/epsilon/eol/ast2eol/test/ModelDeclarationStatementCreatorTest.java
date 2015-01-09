package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.junit.Test;

public class ModelDeclarationStatementCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("model Core alias a, b driver EMF {nsuri = \"org.amma.dsl.jdt.core\"};");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		assertEquals(program.getBlock().getStatements().size(), 0);
		
		assertEquals(program.getModelDeclarations().size(), 1);
		
		ModelDeclarationStatement modelDeclarationStatement = program.getModelDeclarations().get(0);
		assertEquals(modelDeclarationStatement.getName().getName().getName(), "Core");
		assertEquals(modelDeclarationStatement.getAlias().size(), 2);
		VariableDeclarationExpression alias1 = modelDeclarationStatement.getAlias().get(0);
		assertEquals(alias1.getName().getName(), "a");
		VariableDeclarationExpression alias2 = modelDeclarationStatement.getAlias().get(1);
		assertEquals(alias2.getName().getName(), "b");
		
		assertEquals(modelDeclarationStatement.getDriver().getName().getName(), "EMF");
		assertEquals(modelDeclarationStatement.getParameters().size(), 1);

		ModelDeclarationParameter parameter = modelDeclarationStatement.getParameters().get(0);
		assertEquals(parameter.getName().getName(), "nsuri");
		assertEquals(parameter.getValue().getVal(), "org.amma.dsl.jdt.core");
	}

}
