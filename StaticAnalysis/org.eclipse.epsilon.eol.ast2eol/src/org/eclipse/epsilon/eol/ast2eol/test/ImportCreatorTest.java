package org.eclipse.epsilon.eol.ast2eol.test;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.AssignmentStatementImpl;
import org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl;
import org.eclipse.epsilon.eol.metamodel.impl.IntegerExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.PlusOperatorExpressionImpl;
import org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl;
import org.junit.Test;

public class ImportCreatorTest {

	@Test
	public void test() {
		
		URL url = getClass().getResource("import.eol");
		System.out.println(url.toString());
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Ast2EolContext context = new Ast2EolContext(eolModule);
		
		EolElement eolElement = context.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, context);

		
		assertEquals(eolElement.getClass(), EolProgramImpl.class);
		EolProgram program = (EolProgram) eolElement;
		
		assertEquals(program.getImports().size(), 1);
		
		Import import1 = program.getImports().get(0);
		assertEquals(import1.getImported().getVal(), "test_import.eol");
		
		EolProgram program2 = (EolProgram) import1.getImportedProgram();
		assertEquals(program2.getBlock().getStatements().size(), 1);
		Statement statement = program2.getBlock().getStatements().get(0);
		assertEquals(statement.getClass(), AssignmentStatementImpl.class);
		AssignmentStatement assignmentStatement = (AssignmentStatement) statement;
		
		assertEquals(assignmentStatement.getLhs().getClass(), VariableDeclarationExpressionImpl.class);
		VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) assignmentStatement.getLhs();
		assertEquals(variableDeclarationExpression.getName().getName(), "a");
		
		assertEquals(assignmentStatement.getRhs().getClass(), IntegerExpressionImpl.class);
		IntegerExpressionImpl integerExpressionImpl = (IntegerExpressionImpl) assignmentStatement.getRhs();
		assertEquals(integerExpressionImpl.getVal(), 10);
	}

}
