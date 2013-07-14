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
	
	protected abstract String getSelection();
	
	protected ResultSet getResultSet() {
		if (resultSet == null) {
			try {
				String sql = "select " + getSelection() + " from " + table.getName();
				if (condition != null && condition.trim().length() > 0) {
					sql += " where " + condition;
				}
				
				int options = ResultSet.TYPE_SCROLL_INSENSITIVE;
				int resultSetType = model.getResultSetType();
				
				if (streamed) {
					options = ResultSet.TYPE_FORWARD_ONLY;
					resultSetType = ResultSet.CONCUR_READ_ONLY;
				}
				
				PreparedStatement preparedStatement = model.prepareStatement(sql, options, resultSetType);
				
				if (streamed) {
					preparedStatement.setFetchSize(Integer.MIN_VALUE);
				}
				else {
					preparedStatement.setFetchSize(Integer.MAX_VALUE);
				}
				
				if (parameters != null) {
					model.setParameters(preparedStatement, parameters);
				}
				
				resultSet = preparedStatement.executeQuery();
			}
			catch (Exception ex) { throw new RuntimeException(ex); } 
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
