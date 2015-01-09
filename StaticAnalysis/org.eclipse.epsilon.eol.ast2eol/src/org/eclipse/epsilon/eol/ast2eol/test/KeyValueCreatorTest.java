package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.KeyValue;
import org.eclipse.epsilon.eol.metamodel.MapExpression;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.MapExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.StringExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class KeyValueCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a = Map{'k1' = 1, 'k2' = 2};");
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().size(), 1);
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression lhs = (VariableDeclarationExpression) assignmentStatement.getLhs();
		assertEquals(lhs.getName().getName(), "a");
		
		assertEquals(assignmentStatement.getRhs().getClass(), MapExpressionImpl.class);
		
		MapExpression mapExpression = (MapExpression) assignmentStatement.getRhs();
		
		assertEquals(mapExpression.getKeyValues().size(), 2);
		
		KeyValue keyValue1 = mapExpression.getKeyValues().get(0);
		assertEquals(keyValue1.getKey().getClass(), StringExpressionImpl.class);
		StringExpression key1 = (StringExpression) keyValue1.getKey();
		assertEquals(key1.getVal(), "k1");
		assertEquals(keyValue1.getValue().getClass(), IntegerExpressionImpl.class);
		IntegerExpression value1 = (IntegerExpression) keyValue1.getValue();
		assertEquals(value1.getVal(), 1);
		
		KeyValue keyValue2 = mapExpression.getKeyValues().get(1);
		assertEquals(keyValue2.getKey().getClass(), StringExpressionImpl.class);
		StringExpression key2 = (StringExpression) keyValue2.getKey();
		assertEquals(key2.getVal(), "k2");
		assertEquals(keyValue2.getValue().getClass(), IntegerExpressionImpl.class);
		IntegerExpression value2 = (IntegerExpression) keyValue2.getValue();
		assertEquals(value2.getVal(), 2);
	}

}
