package org.eclipse.epsilon.labs.queryoptimisation;

import org.eclipse.epsilon.emc.mysql.MySqlModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.parse.EolParser;

public class MySqlApp {
	public static void main(String[] args) throws Exception {
		
		MySqlModel model = new MySqlModel();
		model.setServer("localhost");
		model.setDatabase("employees");
		model.setUsername("root");
		model.setPassword("compassyork");
		model.setPort(3306);
		model.setName("M");
		model.load();
		
		EolEvaluator e = new EolEvaluator(model);
		
		e.getContext().setExecutorFactory(new ExecutorFactory() {
			@Override
			protected void cacheExecutors() {
				super.cacheExecutors();
				executorCache.put(EolParser.POINT, new OptimisedPointExecutor());
			}
		});
		
		e.execute("M.find(p:Person|p.name = 'p4');");
		
		long now = System.currentTimeMillis();
		//e.execute("M.find(p:Person|p.name = 'p4').size().println();");
		//System.err.println(System.currentTimeMillis() - now);
		//now = System.currentTimeMillis();
		e.execute("Person.all.selectOne(p|p.name = 'p200').name.println();");
		System.err.println(System.currentTimeMillis() - now);

	}
}
