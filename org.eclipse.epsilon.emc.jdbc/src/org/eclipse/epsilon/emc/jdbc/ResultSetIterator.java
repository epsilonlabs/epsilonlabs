package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class ResultSetIterator implements Iterator<Object> {
	
	protected ResultSet rs = null;
	
	public ResultSetIterator(ResultSet rs) {
		this.rs = rs;
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
