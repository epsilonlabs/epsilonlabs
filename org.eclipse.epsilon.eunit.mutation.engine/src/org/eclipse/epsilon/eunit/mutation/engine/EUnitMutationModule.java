package org.eclipse.epsilon.eunit.mutation.engine;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eunit.EUnitModule;

public class EUnitMutationModule {

	public static void main(String[] args) throws Exception {
		Mutant original = getOriginal();
		double killCount = 0.0;
		
		for (Mutant mutant : getMutants()) {
			if (original.different(mutant)) {
				System.out.println("Killed " + mutant.getIdentifier());
				killCount++;
			} else {
				System.out.println("Failed to kill " + mutant.getIdentifier());
			}
		}
		
		System.out.println("Mutation score: " + killCount / getMutants().size());
	}
	
	private static Mutant getOriginal() throws Exception {
		return new Mutant(parseModule(
			"operation Integer inc() {"  + '\n' +
			"  return self + 1;"  + '\n' +
			"}"), "original");
	}
	
	private static List<Mutant> getMutants() throws Exception {
		final LinkedList<Mutant> mutants = new LinkedList<Mutant>();
		mutants.add(new Mutant(parseModule( "operation Integer inc() {"  + '\n' +
			"  return self - 1;"  + '\n' +
			"}"), "Replace + with -"));
		mutants.add(new Mutant(parseModule( "operation Integer inc() {"  + '\n' +
				"  return 1 + self;"  + '\n' +
				"}"), "Reorder arguments"));
		return mutants;
	}
	
	private static EUnitModule parseModule(String programUnderTest) throws Exception {
		String tests = "@test" + '\n' + 
			"operation incZero() {"  + '\n' +
			"  assertEquals(1, 0.inc());"  + '\n' +
			"}" + '\n' +
			"@test" + '\n' + 
			"operation incPositive() {"  + '\n' +
			"  assertEquals(43, 42.inc());"  + '\n' +
			"}" + '\n' +
			programUnderTest;
		
		EUnitModule module = new EUnitModule();
		module.setReportDirectory(null); // prevent attempts to write results out to XML
		module.parse(tests);
		
		if (!module.getParseProblems().isEmpty()) {
			for (ParseProblem p : module.getParseProblems()) {
				System.out.println(p);
			}
		}
		
		module.execute();
		
		return module;
	}
	

}
