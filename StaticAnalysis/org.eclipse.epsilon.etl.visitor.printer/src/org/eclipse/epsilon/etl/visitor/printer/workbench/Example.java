package org.eclipse.epsilon.etl.visitor.printer.workbench;

import java.io.File;
import java.net.URL;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;
import org.eclipse.epsilon.etl.visitor.printer.impl.EtlPrinter;

public class Example {

	public static void main(String[] args) {
		new Example().run();
	}
	public void run()
	{
		URL url = getClass().getResource("OO2DB.etl");
		System.out.println(url.toString());
		EtlModule etlModule = new EtlModule();
		try {
			etlModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		AST ast = etlModule.getAst();
		
		System.out.println(ast.toStringTree());
		
		Ast2EtlContext context = new Ast2EtlContext();
		EolElement dom = context.getEtlElementCreatorFactory().createDomElement(etlModule.getAst(), null, context);
		
		System.err.println(context.getEtlElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");

		EtlPrinter printer = new EtlPrinter();
		printer.run(dom);
		System.out.println(printer.getPrintedProgram());
				
	}

}
