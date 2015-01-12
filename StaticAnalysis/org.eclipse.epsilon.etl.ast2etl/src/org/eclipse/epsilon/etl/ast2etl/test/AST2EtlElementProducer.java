package org.eclipse.epsilon.etl.ast2etl.test;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;

public class AST2EtlElementProducer {

	public static EolElement parseAST(String text)
	{
		EtlModule etlModule = new EtlModule();
		
		try {
			etlModule.parse(text);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Ast2EtlContext context = new Ast2EtlContext(etlModule);
		
		EolElement result = context.getEtlElementCreatorFactory().createDomElement(etlModule.getAst(), null, context);
		return result;
	}
	
}
