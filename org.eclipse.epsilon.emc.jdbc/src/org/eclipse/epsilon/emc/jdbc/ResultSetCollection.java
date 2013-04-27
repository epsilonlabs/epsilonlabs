package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class ResultSetCollection extends ImmutableCollection<Object>{

	protected ResultSet rs = null;
	protected JdbcModel model = null;
	protected String table = null;
	
	public ResultSetCollection(ResultSet rs, JdbcModel model, String table) {
		this.rs = rs;
		this.model = model;
		this.table = table;
	}
	
	@Override
	public boolean contains(Object o) {
		return o == rs;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return c.size() == 1 && c.iterator().next() == rs;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<Object> iterator() {
		return new ResultSetIterator(rs, model, table);
	}

	@Override
	public int size() {
		try {
			return rs.getFetchSize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}
		
}
