package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class ResultSetIterator implements Iterator<Object> {
	
	protected ResultSet rs = null;
	protected JdbcModel model = null;
	protected String table = null;
	
	public ResultSetIterator(ResultSet rs, JdbcModel model, String table) {
		this.rs = rs;
		this.model = model;
		this.table = table;
	}
	
	@Override
	public boolean hasNext() {
		try {
			return !rs.isLast();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object next() {
		try {
			rs.next();
			return new Result(rs, rs.getRow(), model, table);
			//rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
