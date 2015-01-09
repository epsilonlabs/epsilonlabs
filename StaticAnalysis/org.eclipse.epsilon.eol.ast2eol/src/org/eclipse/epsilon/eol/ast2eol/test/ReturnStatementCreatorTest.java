package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.ReturnStatement;
import org.eclipse.epsilon.eol.metamodel.impl.AnyTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.FormalParameterExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.ReturnStatementImpl;
import org.junit.Test;

public class ReturnStatementCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("operation foo(bar:Integer) { return; }");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition op = program.getOperations().get(0);
		
		assertEquals(op.getParameters().size(), 1);
		assertEquals(op.getParameters().get(0).getClass(), FormalParameterExpressionImpl.class);
		
		FormalParameterExpression formalParameterExpression = op.getParameters().get(0);
		
		assertEquals(formalParameterExpression.getName().getName(), "bar");
		assertEquals(formalParameterExpression.getResolvedType().getClass(), IntegerTypeImpl.class);
		
		assertEquals(op.getContextType().getClass(), AnyTypeImpl.class);
		assertEquals(op.getReturnType().getClass(), AnyTypeImpl.class);
		
		Block block = op.getBody();
		assertEquals(block.getStatements().size(), 1);
		assertEquals(block.getStatements().get(0).getClass(), ReturnStatementImpl.class);
		ReturnStatement returnStatement = (ReturnStatement) block.getStatements().get(0);
		assertEquals(returnStatement.getReturned(), null);
	}
	
	@Test
	public void test1() {
		EolElement eolElement = AST2EolElementProducer.parseAST("operation foo(bar:Integer) { return 1; }");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getOperations().size(), 1);
		
		OperationDefinition op = program.getOperations().get(0);
		
		assertEquals(op.getParameters().size(), 1);
		assertEquals(op.getParameters().get(0).getClass(), FormalParameterExpressionImpl.class);
		
		FormalParameterExpression formalParameterExpression = op.getParameters().get(0);
		
		assertEquals(formalParameterExpression.getName().getName(), "bar");
		assertEquals(formalParameterExpression.getResolvedType().getClass(), IntegerTypeImpl.class);
		
		assertEquals(op.getContextType().getClass(), AnyTypeImpl.class);
		assertEquals(op.getReturnType().getClass(), AnyTypeImpl.class);
		
		Block block = op.getBody();
		assertEquals(block.getStatements().size(), 1);
		assertEquals(block.getStatements().get(0).getClass(), ReturnStatementImpl.class);
		ReturnStatement returnStatement = (ReturnStatement) block.getStatements().get(0);
		assertEquals(returnStatement.getReturned().getClass(), IntegerExpressionImpl.class);
		IntegerExpression integerExpression = (IntegerExpression) returnStatement.getReturned();
		assertEquals(integerExpression.getVal(), 1);
	}
	
	@Test
	public void test2() {
		EolElement eolElement = AST2EolElementProducer.parseAST("return;");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().size(), 1);
		assertEquals(program.getBlock().getStatements().get(0).getClass(), ReturnStatementImpl.class);
		ReturnStatement returnStatement = (ReturnStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(returnStatement.getReturned(), null);
	}

}
