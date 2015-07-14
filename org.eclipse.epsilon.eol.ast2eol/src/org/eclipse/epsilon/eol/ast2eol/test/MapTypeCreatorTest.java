package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.ExpressionStatement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EOLProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExpressionStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.MapTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class MapTypeCreatorTest {

	@Test
	public void test() {
		EOLElement eolElement = AST2EolElementProducer.parseAST("var a : Map;");
		assertEquals(eolElement.getClass(), EOLProgramImpl.class);
		
		EOLProgram program = (EOLProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().size(), 1);
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), ExpressionStatementImpl.class);
		
		ExpressionStatement expressionStatement = (ExpressionStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(expressionStatement.getExpression().getClass(), VariableDeclarationExpressionImpl.class);
		
		VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) expressionStatement.getExpression();
		
		assertEquals(variableDeclarationExpression.getName().getName(), "a");
		assertEquals(variableDeclarationExpression.getResolvedType().getClass(), MapTypeImpl.class);
		
	}
}
