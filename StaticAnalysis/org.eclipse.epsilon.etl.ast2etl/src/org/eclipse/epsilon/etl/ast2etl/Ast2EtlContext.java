package org.eclipse.epsilon.etl.ast2etl;

import java.util.HashMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.etl.metamodel.EtlFactory;
import org.eclipse.epsilon.etl.metamodel.EtlPackage;


public class Ast2EtlContext extends Ast2EolContext{

	EtlElementCreatorFactory etlElementCreatorFactory;
	EolFactory eolFactory;
	EtlFactory etlFactory;
	HashMap<EolElement, AST> trace = new HashMap<EolElement, AST>();
	
	public Ast2EtlContext()
	{
		etlElementCreatorFactory = new EtlElementCreatorFactory();
		eolFactory = EolPackage.eINSTANCE.getEolFactory();
		etlFactory = EtlPackage.eINSTANCE.getEtlFactory();
	}
	
	public Ast2EtlContext(EtlElementCreatorFactory eolElementCreatorFactory)
	{
		this.etlElementCreatorFactory = eolElementCreatorFactory;
		eolFactory = EolPackage.eINSTANCE.getEolFactory();
		etlFactory = EtlPackage.eINSTANCE.getEtlFactory();
	}
	
	public EolFactory getEolFactory()
	{
		return eolFactory;
	}
	
	public EtlFactory getEtlFactory() {
		return etlFactory;
	}
	
	public EtlElementCreatorFactory getEtlElementCreatorFactory()
	{
		return etlElementCreatorFactory;
	}
	
	public HashMap<EolElement, AST> getTrace() {
		return trace;
	}
	
	
}
