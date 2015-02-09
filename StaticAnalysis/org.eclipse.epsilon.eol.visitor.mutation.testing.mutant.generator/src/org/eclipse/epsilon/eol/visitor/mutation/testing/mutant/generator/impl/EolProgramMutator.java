package org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.impl;

import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.context.MutantGeneratorContext;

public class EolProgramMutator extends EolProgramVisitor<MutantGeneratorContext, Object>{

	@Override
	public Object visit(EolProgram eolProgram, MutantGeneratorContext context,
			EolVisitorController<MutantGeneratorContext, Object> controller) {
		controller.visitContents(eolProgram, context);
		return null;
	}

}
