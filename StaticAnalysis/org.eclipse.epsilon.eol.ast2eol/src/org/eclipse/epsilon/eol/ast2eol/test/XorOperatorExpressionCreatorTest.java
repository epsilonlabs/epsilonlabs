package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.BooleanExpression;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OrOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.XorOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.BooleanExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.OrOperatorExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.XorOperatorExpressionImpl;
import org.junit.Test;

public class XorOperatorExpressionCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a = true; \n" +
				"var b = false; \n" +
				"var c = a xor b;");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement1 = (AssignmentStatement) program.getBlock().getStatements().get(0);
		assertEquals(assignmentStatement1.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression1 = (VariableDeclarationExpression) assignmentStatement1.getLhs();
		assertEquals(variableDeclarationExpression1.getName().getName(), "a");
		assertEquals(assignmentStatement1.getRhs().getClass(), BooleanExpressionImpl.class);
		BooleanExpression booleanExpression1 = (BooleanExpression) assignmentStatement1.getRhs();
		assertEquals(booleanExpression1.isVal(), true);
		
		AssignmentStatement assignmentStatement2 = (AssignmentStatement) program.getBlock().getStatements().get(1);
		assertEquals(assignmentStatement2.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression2 = (VariableDeclarationExpression) assignmentStatement2.getLhs();
		assertEquals(variableDeclarationExpression2.getName().getName(), "b");
		assertEquals(assignmentStatement2.getRhs().getClass(), BooleanExpressionImpl.class);
		BooleanExpression booleanExpression2 = (BooleanExpression) assignmentStatement2.getRhs();
		assertEquals(booleanExpression2.isVal(), false);
		
		AssignmentStatement assignmentStatement3 = (AssignmentStatement) program.getBlock().getStatements().get(2);
		assertEquals(assignmentStatement3.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression3 = (VariableDeclarationExpression) assignmentStatement3.getLhs();
		assertEquals(variableDeclarationExpression3.getName().getName(), "c");
		assertEquals(assignmentStatement3.getRhs().getClass(), XorOperatorExpressionImpl.class);
		XorOperatorExpression xorOperatorExpression = (XorOperatorExpression) assignmentStatement3.getRhs();
		assertEquals(xorOperatorExpression.getLhs().getClass(), NameExpressionImpl.class);
		NameExpression nameExpression = (NameExpression) xorOperatorExpression.getLhs();
		assertEquals(nameExpression.getName(), "a");
		assertEquals(xorOperatorExpression.getRhs().getClass(), NameExpressionImpl.class);
		NameExpression nameExpression2 = (NameExpression) xorOperatorExpression.getRhs();
		assertEquals(nameExpression2.getName(), "b");
	}

}
