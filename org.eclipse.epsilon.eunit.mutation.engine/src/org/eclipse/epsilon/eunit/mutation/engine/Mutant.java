package org.eclipse.epsilon.eunit.mutation.engine;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eunit.EUnitModule;
import org.eclipse.epsilon.eunit.EUnitTest;

public class Mutant {

	private final List<EUnitTest> tests;
	private final String identifier;
	
	public Mutant(EUnitModule module, String identifier) throws EolRuntimeException {
		this.tests = module.getSuiteRoot().collectLeafTests(module.getSelectedOperations(), null);
		this.identifier = identifier;
	}

	public Iterable<EUnitTest> getTests() {
		return tests;
	}

	public String getIdentifier() {
		return identifier;
	}

	public boolean different(Mutant mutant) {
		for (EUnitTest test : getTests()) {
			for (EUnitTest test2 : mutant.getTests()) {
				if (test.getCaseName().equals(test2.getCaseName()) &&
					test.getResult() != test2.getResult()) {
					return true;
				}
			}
		}
		
		return false;
	}
}
