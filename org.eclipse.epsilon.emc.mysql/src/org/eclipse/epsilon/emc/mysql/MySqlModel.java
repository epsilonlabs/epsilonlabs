package org.eclipse.epsilon.emc.mysql;

import org.eclipse.epsilon.emc.jdbc.JdbcModel;
import org.eclipse.epsilon.eol.EolModule;

public class MySqlModel extends JdbcModel {

	public static void main(String[] args) throws Exception {
		MySqlModel model = new MySqlModel();
		model.setServer("localhost");
		model.setDatabase("employees");
		model.setUsername("root");
		model.setPassword("compassyork");
		model.setPort(3306);
		model.setName("M");
		model.load();
		
		EolModule module = new EolModule();
		
		//module.parse("M.find(h:help_topic|h.help_category_id > 12 /*and h.name.startsWith('join')*/);");
		//module.parse("help_topic.all.first().isTypeOf(help_topic).println();");
		//module.parse("for (t in help_topic.all) { (t.help_category_id + 1).println(); }");
		
		//module.parse("var x : new person2; x.name='Mary';");
		// Add support for dates
		module.parse("transaction {for (p in Person.all) { p.name = 'foo2' + loopCount; } 'foo'.moo();}");
		
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}

	@Override
	protected String getDriverClass() {
		return "com.mysql.jdbc.Driver";
	}

	@Override
	protected String getJdbcUrl() {
		return "jdbc:mysql://" + server + ":" + port + "/" + database;
	}

}
