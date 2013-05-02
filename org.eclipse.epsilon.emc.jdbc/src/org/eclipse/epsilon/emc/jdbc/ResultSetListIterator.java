package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetListIterator extends ImmutableListIterator<Result> {
	
	protected ResultSet rs = null;
	protected JdbcModel model = null;
	protected Table table = null;
	
	public ResultSetListIterator(ResultSet rs, JdbcModel model, Table table) {
		this.rs = rs;
		this.model = model;
		this.table = table;
	}
	
	@Override
	public boolean hasNext() {
		try {
			return !rs.isLast();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Result next() {
		try {
			rs.next();
			return new Result(rs, rs.getRow(), model, table);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean hasPrevious() {
		try {
			return !rs.isFirst();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int nextIndex() {
		try {
			return rs.getRow() + 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Result previous() {
		try {
			rs.previous();
			return new Result(rs, rs.getRow(), model, table);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int previousIndex() {
		try {
			return rs.getRow() - 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
