package org.eclipse.epsilon.coverage.test.unit;

import java.io.File;

import org.eclipse.epsilon.coverage.CoverageExecutionListener;
import org.eclipse.epsilon.coverage.strategies.booleanexp.ConditionCoverageStrategy;
import org.eclipse.epsilon.coverage.strategies.booleanexp.DecisionCoverageStrategy;
import org.eclipse.epsilon.coverage.strategies.rule.EclRuleCoverageStrategy;
import org.eclipse.epsilon.coverage.strategies.statement.EclStatementCoverage;
import org.eclipse.epsilon.ecl.EclModule;
import org.junit.Test;

public class ECLCoverageTest extends AbstractTest {

	@Test
	public void testStatementCoverage() throws Exception {
		// The module to execute
		EclModule module = new EclModule();
		
		// Create our coverage strategies and listener
		CoverageExecutionListener listener = new CoverageExecutionListener();
		listener.addCoverageStrategy(new EclStatementCoverage());
		listener.addCoverageStrategy(new EclRuleCoverageStrategy());
		listener.addCoverageStrategy(new DecisionCoverageStrategy());
		listener.addCoverageStrategy(new ConditionCoverageStrategy());
		
		// Whack in the listener
		module.getContext().getExecutorFactory().addExecutionListener(listener);
		
		// Register MMs
//		EmfUtil.register(URI.createFileURI("models/flowchart/Flowchart.ecore"), EPackage.Registry.INSTANCE);
		
		// Load models
		module.getContext().getModelRepository().addModel(loadModel("Left", "models/flowchart/flowchart.ecore", "http://www.eclipse.org/emf/2002/Ecore", true, false));
		module.getContext().getModelRepository().addModel(loadModel("Right", "models/flowchart/flowchart.ecore", "http://www.eclipse.org/emf/2002/Ecore", true, false));
		
		// Parse
		if (!module.parse(new File("models/ecl/test.ecl"))){
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
