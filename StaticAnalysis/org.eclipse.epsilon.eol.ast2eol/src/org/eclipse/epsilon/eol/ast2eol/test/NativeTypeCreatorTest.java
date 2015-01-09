package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.NativeType;
import org.eclipse.epsilon.eol.metamodel.NewExpression;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NativeTypeImpl;
import org.eclipse.epsilon.eol.metamodel.impl.NewExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.StringExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class NativeTypeCreatorTest {

	@Test
	public void test() {
		EolElement eolElement = AST2EolElementProducer.parseAST("var a = new Native(\"java.lang.String\");");
		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getBlock().getStatements().get(0).getClass(), AssignmentStatementImpl.class);
		
		AssignmentStatement assignmentStatement = (AssignmentStatement) program.getBlock().getStatements().get(0);
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) assignmentStatement.getLhs();
		assertEquals(variableDeclarationExpression.getName().getName(), "a");
		
		assertEquals(assignmentStatement.getRhs().getClass(), NewExpressionImpl.class);
		NewExpression newExpression = (NewExpression) assignmentStatement.getRhs();
		
		
		assertEquals(newExpression.getResolvedType().getClass(), NativeTypeImpl.class);
		//assertEquals(newExpression.getParameters().size(), 1);
		//assertEquals(newExpression.getParameters().get(0).getClass(), StringExpressionImpl.class);
		//StringExpression stringExpression = (StringExpression) newExpression.getParameters().get(0);
		//assertEquals(stringExpression.getVal(), "java.lang.String");
		
		NativeType nativeType = (NativeType) newExpression.getResolvedType();
		
		assertEquals(nativeType.getNativeExpression().getVal(), "java.lang.String");
	}

}
