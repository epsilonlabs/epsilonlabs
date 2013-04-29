package org.eclipse.epsilon.emc.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolMap;

public abstract class JdbcModel extends Model implements ISearchableModel {
	
	public static final String PROPERTY_SERVER = "server";
	public static final String PROPERTY_PORT = "port";
	public static final String PROPERTY_DATABASE = "database";
	public static final String PROPERTY_USERNAME = "username";
	public static final String PROPERTY_PASSWORD = "password";
	public static final String PROPERTY_READONLY = "readonly";
	
	protected String server;
	protected int port;
	protected String database;
	protected String username;
	protected String password;
	protected Connection connection;
	protected List<String> tables = new ArrayList<String>();
	protected ResultPropertyGetter propertyGetter = new ResultPropertyGetter();
	protected ResultPropertySetter propertySetter = new ResultPropertySetter(this);
	protected boolean readOnly = true;
	
	protected abstract Driver createDriver() throws SQLException;
	protected abstract String getJdbcUrl();
	
	public void print(ResultSet rs) throws Exception {
		while (rs.next()) {
			System.err.println(rs.getString(3));
		}
	}
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		this.database = properties.getProperty(PROPERTY_DATABASE);
		this.server = properties.getProperty(PROPERTY_SERVER, this.server);
		this.port = properties.getIntegerProperty(PROPERTY_PORT, this.port);
		this.username = properties.getProperty(PROPERTY_USERNAME);
		this.password = properties.getProperty(PROPERTY_PASSWORD);
		this.readOnly = properties.getBooleanProperty(PROPERTY_READONLY, this.readOnly);
		load();
	}
	
	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return createInstance(type, Collections.emptyList());
	}
	
	protected int getResultSetType() {
		if (!isReadOnly()) {
			return ResultSet.CONCUR_UPDATABLE;
		}
		else {
			return ResultSet.CONCUR_READ_ONLY;
		}
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {

		try {
			
			// Create a Statement for scrollable ResultSet
			Statement sta = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, getResultSetType());

			// Catch the ResultSet object
			ResultSet res = sta.executeQuery("SELECT * FROM " + type
					+ " WHERE 1=2");

			// Move the cursor to the insert row
			res.moveToInsertRow();

			if (parameters.iterator().hasNext()) {
				EolMap values = (EolMap) parameters.iterator().next();
				for (Object key : values.keySet()) {
					res.updateObject(key + "", values.get(key));
				}
			}

			// Store the insert into database
			res.insertRow();
			res.next();
			
			return new Result(res, res.getRow(), this, type);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	@Override
	public void load() throws EolModelLoadingException {
		try {
			Driver driver = createDriver();
			Properties properties = new Properties();
			properties.put("user", username);
			properties.put("password", password);
			connection = driver.connect(getJdbcUrl(), properties);
	        
	        // Cache table names
	        ResultSet rs = connection.getMetaData().getTables(null, null, null, new String[]{});
			while (rs.next()) {
				tables.add(rs.getString(3));
			}
			
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
	}
	
	@Override
	public boolean hasType(String type) {
		return tables.contains(type);
	}
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		try {
			PreparedStatement statement = 
					connection.prepareStatement("select * from " + type, 
							  ResultSet.TYPE_SCROLL_INSENSITIVE, 
							  getResultSetType());
			
			return new ResultSetCollection(statement.executeQuery(), this, type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<?> allContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOfType(Object instance, String metaClass)
			throws EolModelElementTypeNotFoundException {
		return metaClass.equals(getTypeNameOf(instance));
	}
	
	@Override
	public boolean isOfKind(Object instance, String metaClass)
			throws EolModelElementTypeNotFoundException {
		return isOfType(instance, metaClass);
	}
	
	@Override
	public String getTypeNameOf(Object instance) {
		return ((Result) instance).getTable();
	}
	
	@Override
	public Collection<?> find(Variable iterator, AST ast, IEolContext context)
			throws EolRuntimeException {
		
		String sql = "select * from " + iterator.getType().getName() + 
				" where " + ast2sql(iterator, ast, context);
		
		try {
			return new ResultSetCollection(connection.prepareStatement(sql).executeQuery(), this, iterator.getType().getName());
		} catch (SQLException e) {
			throw new EolInternalException(e);
		}
	}
	
	public String ast2sql(Variable iterator, AST ast, IEolContext context) throws EolRuntimeException {
		if (ast.getType() == EolParser.OPERATOR) {
			return "(" + ast2sql(iterator, ast.getFirstChild(), context)
					+ ast.getText() + 
					ast2sql(iterator, ast.getFirstChild().getNextSibling(), context) + ")";
		}
		else if (ast.getType() == EolParser.POINT && ast.getFirstChild().getText().equals(iterator.getName())) {
			return ast.getFirstChild().getNextSibling().getText();
		}
		else {
			Object result = context.getExecutorFactory().executeAST(ast, context);
			if (result instanceof String) {
				return "\"" + result + "\"";
			}
			else {
				return result + "";
			}
		}
	}
	
	@Override
	public Object getElementById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getElementId(Object instance) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return propertySetter;
	}
	
	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}
	
	@Override
	public boolean owns(Object instance) {
		return instance instanceof Result && 
			((Result) instance).getModel() == this;
	}
	
	@Override
	public IModelTransactionSupport getTransactionSupport() {
		return new IModelTransactionSupport() {
			
			@Override
			public void startTransaction() {
				try {
					connection.setAutoCommit(false);
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
			
			@Override
			public void commitTransaction() {
				try {
					connection.commit();
					connection.setAutoCommit(true);
				}
				catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
			
			@Override
			public void rollbackTransaction() {
				try {
					connection.rollback();
					connection.setAutoCommit(true);
				}
				catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
			
		};
	}
	
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
	public boolean isReadOnly() {
		return readOnly;
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
	
	@Override
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		
	}
	
	@Override
	public boolean isInstantiable(String type) {
		return !readOnly;
	}
	
	@Override
	public boolean store(String location) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean store() {
		throw new UnsupportedOperationException();
	}
	
}
