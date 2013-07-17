package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IModelElement;

public class ResultSetList extends TableViewList<Result> implements IModelElement {

	protected int size = -1;
	protected ResultSet resultSet = null;

	public ResultSetList(JdbcModel model, Table table, String condition, List<Object> parameters, boolean streamed) {
		super(model, table, condition, parameters, streamed);
	}
	
	@Override
	public String getSelection() {
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
	public int size() {
		
		if (size == -1) {
			if (streamed) {
				size = (int) (long) new StreamedPrimitiveValuesListSqlOperation<Long>("count", getSelection(), condition, parameters, model, table).getValue();
			}
			else {
				try {
					ResultSet rs = getResultSet();
					int row = rs.getRow();
					rs.last();
					size = rs.getRow();
					if (row != 0) rs.absolute(row);
				}
				catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}
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

	@Override
	public IModel getOwningModel() {
		return model;
	}
	
}
