package org.eclipse.epsilon.emc.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class TableViewList<T> extends ImmutableList<T> {
	
	protected JdbcModel model = null;
	protected Table table = null;
	protected String condition;
	protected List<Object> parameters;
	protected ResultSet resultSet = null;
	protected boolean streamed = false;
	
	public TableViewList(JdbcModel model, Table table, String condition, List<Object> parameters, boolean streamed) {
		super();
		this.model = model;
		this.table = table;
		this.condition = condition;
		this.parameters = parameters;
		this.streamed = streamed;
	}
	
	public abstract String getSelection();
	
	protected ResultSet getResultSet() {
		if (resultSet == null) {
			resultSet = model.getResultSet(getSelection(), condition, parameters, table, streamed);
		}
		return resultSet;
	}
	
	public JdbcModel getModel() {
		return model;
	}
	
	public Table getTable() {
		return table;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public List<Object> getParameters() {
		return parameters;
	}
	
	public boolean isStreamed() {
		return streamed;
	}
	
	public void setStreamed(boolean streamed) {
		this.streamed = streamed;
	}
}
