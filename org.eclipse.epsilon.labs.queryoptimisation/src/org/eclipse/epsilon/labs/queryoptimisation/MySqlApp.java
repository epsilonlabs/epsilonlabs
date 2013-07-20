package org.eclipse.epsilon.labs.queryoptimisation;

import java.io.File;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.jdbc.JdbcModel;
import org.eclipse.epsilon.emc.mysql.MySqlModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class MySqlApp {
	public static void main(String[] args) throws Exception {
		
		MySqlModel model = new MySqlModel();
		model.setServer("localhost");
		model.setDatabase("employees");
		model.setUsername("root");
		model.setPassword("compassyork");
		model.setPort(3306);
		model.setName("DB");
		model.load();
		
		EolModule module = new EolModule();
		module.parse(new File("resources/test.eol"));
		
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem);
			}
			return;
		}
		
		module.getContext().getModelRepository().addModel(model);
		
		long now = System.currentTimeMillis();
		
		try {
			module.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.err.println(System.currentTimeMillis() - now);

	}
}
