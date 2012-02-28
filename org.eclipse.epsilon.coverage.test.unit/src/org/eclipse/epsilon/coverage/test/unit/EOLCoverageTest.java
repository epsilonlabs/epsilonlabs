package org.eclipse.epsilon.coverage.test.unit;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.coverage.CoverageExecutionListener;
import org.eclipse.epsilon.coverage.strategies.booleanexp.ConditionCoverageStrategy;
import org.eclipse.epsilon.coverage.strategies.booleanexp.DecisionCoverageStrategy;
import org.eclipse.epsilon.coverage.strategies.statement.EolStatementCoverage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.junit.Test;

public class EOLCoverageTest extends AbstractTest {

	@Test
	public void testStatementCoverage() throws Exception {
		// The module to execute
		EolModule module = new EolModule();
		
		// Create our coverage strategies and listener
		CoverageExecutionListener listener = new CoverageExecutionListener();
		listener.addCoverageStrategy(new EolStatementCoverage());
		
		// Whack in the listener
		module.getContext().getExecutorFactory().addExecutionListener(listener);
		
		// Register MMs
		EmfUtil.register(URI.createFileURI("models/flowchart/Flowchart.ecore"), EPackage.Registry.INSTANCE);
		
		// Load models
		module.getContext().getModelRepository().addModel(loadModel("Hello", "models/flowchart/example.model", "flowchart", true, false));
		
		// Parse
		if (!module.parse(new File("models/flowchart/animateFlowchart.eol"))){
			System.err.println("Unabled to parse");
			System.err.println(module.getParseProblems());
			return;
		}
		
		// GO!
		module.execute();
		
		System.out.println(listener.getCoverageModel().getStrategies().get(0).getPoints());
	}
	
	@Test
	public void testDecisionAndConditionCoverages() throws Exception {
		// The module to execute
		EolModule module = new EolModule();
		
		// Create our coverage strategies and listener
		CoverageExecutionListener listener = new CoverageExecutionListener();
		listener.addCoverageStrategy(new DecisionCoverageStrategy());
		listener.addCoverageStrategy(new ConditionCoverageStrategy());
		
		// Whack in the listener
		module.getContext().getExecutorFactory().addExecutionListener(listener);
		
		// Register MMs
		EmfUtil.register(URI.createFileURI("models/triangle/Triangle.ecore"), EPackage.Registry.INSTANCE);
		
		// Load models
		module.getContext().getModelRepository().addModel(loadModel("tri", "models/triangle/example.model", "triangle", true, false));
		
		// Parse
		if (!module.parse(new File("models/triangle/TriangleClassification.eol"))){
			System.err.println("Unabled to parse");
			System.err.println(module.getParseProblems());
			return;
		}
		
		// GO!
		module.execute();
		
		// Print analysis TODO
		System.out.println(listener.getCoverageModel().getStrategies().get(0).getPoints());
	}

}
