package org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.impl;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.context.MutantGeneratorContext;
import org.eclipse.epsilon.eol.visitor.printer.impl.EolPrinter;

public class MutantGenerator {

	protected EolVisitorController<MutantGeneratorContext, Object> controller = new EolVisitorController<MutantGeneratorContext, Object>();
	protected MutantGeneratorContext context = new MutantGeneratorContext();
	
	public MutantGenerator()
	{
		controller.addDefaultVisitor(new EolDefaultVisitor<MutantGeneratorContext, Object>());
		controller.addEolProgramVisitor(new EolProgramMutator());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionMutator());
	}
	
	public void run(EolElement eolElement)
	{
		controller.visit(eolElement, context);
	}
	
	
	public static void main(String[] args) {
		MutantGenerator generator = new MutantGenerator();
		
		EolModule eolModule = new EolModule();
		
		try {
			eolModule.parse("var a = 10; \n" +
					"var b = 10;" +
					"var c = a + b;");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Ast2EolContext context = new Ast2EolContext();
		EolElement dom = context.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, context);
		
		System.err.println(context.getEolElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");
		
		generator.run(dom);
		
		EolPrinter printer = new EolPrinter();
		System.out.println(printer.print(dom));
	}
}
