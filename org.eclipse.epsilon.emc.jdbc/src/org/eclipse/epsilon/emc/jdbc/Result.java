package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Result {
	
	protected ResultSet resultSet;
	protected int row;
	protected JdbcModel model;
	protected String table;
	
	public Result(ResultSet rs, int row, JdbcModel model, String table) {
		this.resultSet = rs;
		this.row = row;
		this.model = model;
		this.table = table;
	}
	
	public int getRow() {
		return row;
	}
	
	protected Object getCell(String name) throws SQLException {
		int oldRow = resultSet.getRow();
		resultSet.absolute(row);
		Object result = resultSet.getObject(name);
		if (oldRow > 0) resultSet.absolute(oldRow);
		return result;
	}
	
	public JdbcModel getModel() {
		return model;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public String getTable() {
		return table;
	}
	
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
}
