package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Result {
	
	protected ResultSet resultSet;
	protected int row;
	protected JdbcModel model;
	protected Table table;
	
	public Result(ResultSet rs, int row, JdbcModel model, Table table) {
		this.resultSet = rs;
		this.row = row;
		this.model = model;
		this.table = table;
	}
	
	public int getRow() {
		return row;
	}
	
	protected Object getValue(String name) throws SQLException {
		//int oldRow = resultSet.getRow();
		resultSet.absolute(row);
		Object result = resultSet.getObject(name);
		//if (oldRow > 0) resultSet.absolute(oldRow);
		return result;
	}
	
	protected void setValue(String name, Object value) throws SQLException {
		//int oldRow = resultSet.getRow();
		resultSet.absolute(row);
		resultSet.updateObject(name, value);
		resultSet.updateRow();
		//if (oldRow > 0) resultSet.absolute(oldRow);	
	}
	
	public JdbcModel getModel() {
		return model;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public Table getTable() {
		return table;
	}
	
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
}
