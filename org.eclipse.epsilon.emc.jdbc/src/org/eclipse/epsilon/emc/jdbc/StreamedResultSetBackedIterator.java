package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;

public abstract class StreamedResultSetBackedIterator<T> extends ResultSetBackedIterator<T> {

	protected T next = null;
	protected boolean nextConsumed = true;

	public StreamedResultSetBackedIterator(ResultSet rs, JdbcModel model, Table table) {
		super(rs, model, table);
	}

	@Override
	public boolean hasNext() {
		// When in streaming mode rs.hasNext() doesn't work
		// so we need to peek ahead
		if (nextConsumed) {
			try {
				boolean hasNext = rs.next();
				if (hasNext) next = getValueAtCurrentIndex();
				return hasNext;
			}
			catch (Exception ex) {
				return false;
			}
		}
		return (next != null);
	}
	
	@Override
	public T next() {
		nextConsumed = true;
		return (T) next;
	}

}
