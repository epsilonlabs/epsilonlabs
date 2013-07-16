package org.eclipse.epsilon.emc.jdbc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IModelElement;

public class PrimitiveValuesList extends TableViewList<Object> implements IModelElement {
	
	protected List<Object> values = null;
	protected String feature = null;
	protected boolean distinct = false;
	
	public PrimitiveValuesList(JdbcModel model, Table table, String feature, String condition, List<Object> parameters, boolean distinct, boolean streamed) {
		super(model, table, condition, parameters, streamed);
		this.feature = feature;
		this.distinct = distinct;
	}
	
	public PrimitiveValuesList asSet() {
		if (this.distinct) return this;
		else return new PrimitiveValuesList(model, table, feature, condition, parameters, true, streamed);
	}
	
	@Override
	public String getSelection() {
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
		return size() == 0;
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
			if (isStreamed()) {
				return new StreamedPrimitiveValuesListIterator(getResultSet(), model, table);
			}
			else {
				return new PrimitiveValuesListIterator(getResultSet(), model, table);
			}
		}
		else {
			return values.listIterator();
		}
	}

	@Override
	public int size() {
		if (streamed) {
			long count = new StreamedPrimitiveValuesListSqlOperation<Long>("count", getSelection(), condition, parameters, model, table).getValue();
			return (int) count;
		}
		else {
			return getValues().size();
		}
	}

	public PrimitiveValuesList fetch() {
		PrimitiveValuesList fetched = new PrimitiveValuesList(model, table, feature, condition, parameters, distinct, false);
		return fetched;
	}
	
	public PrimitiveValuesList stream() {
		PrimitiveValuesList streamed = new PrimitiveValuesList(model, table, feature, condition, parameters, distinct, true);
		return streamed;		
	}

	@Override
	public IModel getOwningModel() {
		return model;
	}

}
