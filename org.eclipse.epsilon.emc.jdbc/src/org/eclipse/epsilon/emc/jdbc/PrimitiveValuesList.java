package org.eclipse.epsilon.emc.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PrimitiveValuesList extends TableViewList<Object>{
	
	protected List<Object> values = null;
	protected String feature = null;
	protected boolean distinct = false;
	
	public PrimitiveValuesList(JdbcModel model, Table table, String feature, String condition, List<Object> parameters, boolean distinct) {
		super(model, table, condition, parameters);
		this.feature = feature;
		this.distinct = distinct;
	}
	
	public PrimitiveValuesList asSet() {
		if (this.distinct) return this;
		else return new PrimitiveValuesList(model, table, feature, condition, values, true);
	}
	
	@Override
	protected String getSelection() {
		String selection = " " + feature + " ";
		if (distinct) { selection = " distinct" + selection; }
		return selection;
	}
	
	public List<Object> getValues() {
		if (values == null) {
			ListIterator<Object> listIterator = listIterator();
			values = new ArrayList<Object>();
			while (listIterator.hasNext()) {
				values.add(listIterator.next());
			}
		}
		return values;
	}
	
	@Override
	public boolean contains(Object o) {
		return getValues().contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return getValues().containsAll(c);
	}

	@Override
	public Object get(int index) {
		return getValues().get(index);
	}

	@Override
	public int indexOf(Object o) {
		return getValues().indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return getValues().isEmpty();
	}

	@Override
	public Iterator<Object> iterator() {
		return listIterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return getValues().lastIndexOf(o);
	}

	@Override
	public ListIterator<Object> listIterator() {
		if (values == null) {
			return new PrimitiveValuesListIterator(getResultSet(), null, null);
		}
		else {
			return values.listIterator();
		}
	}

	@Override
	public int size() {
		return getValues().size();
	}


}
