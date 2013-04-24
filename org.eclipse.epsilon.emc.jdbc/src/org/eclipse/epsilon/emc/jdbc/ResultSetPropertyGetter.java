package org.eclipse.epsilon.emc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class ResultSetPropertyGetter extends AbstractPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		try {
			return ((ResultSet) object).getObject(property);
		} catch (SQLException e) {
			throw new EolInternalException(e);
		}
	}

}
