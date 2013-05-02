package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ResultSetList extends ImmutableList<Result>{

	protected ResultSet rs = null;
	protected JdbcModel model = null;
	protected Table table = null;
	protected int size = -1;
	
	public ResultSetList(ResultSet rs, JdbcModel model, Table table) {
		this.rs = rs;
		this.model = model;
		this.table = table;
	}
	
	@Override
	public boolean contains(Object o) {
		return (o instanceof Result && ((Result) o).getResultSet() == rs);
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
	public Iterator<Result> iterator() {
		return listIterator();
	}

	@Override
	public int size() {
		//if (size == -1) {
			try {
				int row = rs.getRow();
				rs.last();
				size = rs.getRow();
				if (row != 0) rs.absolute(row);
			}
			catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		//}
		return size;
	}

	@Override
	public Object[] toArray() {
		Iterator<Result> iterator = iterator();
		int size = size();
		Object[] array = new Object[size];
		for (int i=0;i<size;i++) {
			array[i] = iterator.next();
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}


	@Override
	public Result get(int index) {
		//try {
			return new Result(rs, index+1, model, table);
		//} catch (SQLException e) {
		//	throw new RuntimeException(e);
		//}
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
		return new ResultSetListIterator(rs, model, table);
	}

	@Override
	public ListIterator<Result> listIterator(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Result> subList(int arg0, int arg1) {
		throw new UnsupportedOperationException();
	}
		
}
