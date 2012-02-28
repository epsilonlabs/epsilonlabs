package org.eclipse.epsilon.coverage.test.unit;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.coverage.CoverageExecutionListener;
import org.eclipse.epsilon.coverage.strategies.rule.EtlRuleCoverageStrategy;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.etl.EtlModule;
import org.junit.Test;

public class ETLCoverageTest extends AbstractTest {

	@Test
	public void testRuleCoverage() throws Exception {
		// The module to execute
		EtlModule module = new EtlModule();
		
		// Create our coverage strategies and listener
		CoverageExecutionListener listener = new CoverageExecutionListener();
		listener.addCoverageStrategy(new EtlRuleCoverageStrategy());
		
		// Whack in the listener
		module.getContext().getExecutorFactory().addExecutionListener(listener);
		
		// Register MMs
		EmfUtil.register(URI.createFileURI("models/OO2DB/OO.ecore"), EPackage.Registry.INSTANCE);
		EmfUtil.register(URI.createFileURI("models/OO2DB/DB.ecore"), EPackage.Registry.INSTANCE);
		EmfUtil.register(URI.createFileURI("models/OO2DB/TM.ecore"), EPackage.Registry.INSTANCE);
		EmfUtil.register(URI.createFileURI("models/OO2DB/SimpleTrace.ecore"), EPackage.Registry.INSTANCE);
		
		// Load models
		module.getContext().getModelRepository().addModel(loadModel("OO", "models/OO2DB/OOInstance.model", "OO", true, false));
		module.getContext().getModelRepository().addModel(loadModel("DB", "models/OO2DB/DBInstance.model", "DB", false, false));
		module.getContext().getModelRepository().addModel(loadModel("OO2DB", "models/OO2DB/OO2DB.model", "TM", true, false));
		module.getContext().getModelRepository().addModel(loadModel("Trace", "models/Trace.model", "SimpleTrace", false, false));
		
		// Parse
		if (!module.parse(new File("models/OO2DB/OO2DB.etl"))){
			System.err.println("Unabled to parse");
			System.err.println(module.getParseProblems());
			return;
		}
		
		// GO!
		module.execute();
		
		// Print analysis
		System.out.println(listener.getCoverageModel().getStrategies().get(0).getPoints());
	}
}
