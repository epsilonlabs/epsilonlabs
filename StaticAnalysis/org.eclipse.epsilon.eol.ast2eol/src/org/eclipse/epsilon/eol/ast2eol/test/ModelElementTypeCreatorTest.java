package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.ExpressionStatement;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ExpressionStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ModelElementTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class ModelElementTypeCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a : A!B;");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		assertEquals(program.getBlock().getStatements().size(), 1);
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), ExpressionStatementImpl.class);
		ExpressionStatement expressionStatement = (ExpressionStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(expressionStatement.getExpression().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression =  (VariableDeclarationExpression) expressionStatement.getExpression();
		assertEquals(variableDeclarationExpression.getName().getName(), "a");
		assertEquals(variableDeclarationExpression.getResolvedType().getClass(), ModelElementTypeImpl.class);
		ModelElementType modelElementType = (ModelElementType) variableDeclarationExpression.getResolvedType();
		assertEquals(modelElementType.getModelName(), "A");
		assertEquals(modelElementType.getElementName(), "B");
	}
	
	@Test
	public void test1() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a : B;");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		assertEquals(program.getBlock().getStatements().size(), 1);
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), ExpressionStatementImpl.class);
		ExpressionStatement expressionStatement = (ExpressionStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(expressionStatement.getExpression().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression =  (VariableDeclarationExpression) expressionStatement.getExpression();
		assertEquals(variableDeclarationExpression.getName().getName(), "a");
		assertEquals(variableDeclarationExpression.getResolvedType().getClass(), ModelElementTypeImpl.class);
		ModelElementType modelElementType = (ModelElementType) variableDeclarationExpression.getResolvedType();
		assertEquals(modelElementType.getModelName(), null);
		assertEquals(modelElementType.getElementName(), "B");
	}

}
