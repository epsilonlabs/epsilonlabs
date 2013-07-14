package org.eclipse.epsilon.emc.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ResultSetList extends TableViewList<Result> {

	protected int size = -1;
	protected ResultSet resultSet = null;

	public ResultSetList(JdbcModel model, Table table, String condition, List<Object> parameters, boolean streamed) {
		super(model, table, condition, parameters, streamed);
	}
	
	@Override
	protected String getSelection() {
		return "*";
	}
	
	@Override
	public boolean contains(Object o) {
		return (o instanceof Result && ((Result) o).getResultSet() == getResultSet());
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) return false;
		}
		return c.size() > 0;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		
		if (size != -1) return size;
		
		try {
			if (condition != null && table != null) {
				String sql = "select count(*) from " + table.getName();
				if (condition.trim().length() > 0) {
					sql += " where " + condition;
				}
				PreparedStatement statement = model.prepareStatement(
					sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				
				if (parameters != null) {
					model.setParameters(statement, parameters);
				}
				
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
				size = resultSet.getInt(1);
			}
			else {
					ResultSet rs = getResultSet();
					int row = rs.getRow();
					rs.last();
					size = rs.getRow();
					if (row != 0) rs.absolute(row);
				}
			}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return size;
	}

	@Override
	public Result get(int index) {
		return new Result(getResultSet(), index+1, model, table, streamed);
	}

	@Override
	public int indexOf(Object o) {
		return ((Result) o).getRow();
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexOf(o);
	}

	@Override
	public ListIterator<Result> listIterator() {
		if (streamed) {
			return new StreamedResultSetListIterator(getResultSet(), model, table);
		}
		else {
			return new ResultSetListIterator(getResultSet(), model, table);
		}
	}
	
	public ResultSetList fetch() {
		ResultSetList fetched = new ResultSetList(model, table, condition, parameters, false);
		return fetched;
	}
	
	public ResultSetList stream() {
		ResultSetList streamed = new ResultSetList(model, table, condition, parameters, true);
		return streamed;		
	}
	
}
