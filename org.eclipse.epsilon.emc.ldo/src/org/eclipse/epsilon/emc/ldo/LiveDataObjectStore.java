package org.eclipse.epsilon.emc.ldo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;

public class LiveDataObjectStore extends Model /* implements ISearchableModel */ {
	
	protected Connection connection = null;
	protected List<EPackage> ePackages = new ArrayList<EPackage>();
	protected String filename = null;
	
	public void addEPackage(EPackage ePackage) {
		this.ePackages.add(ePackage);
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	protected Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.h2.Driver");
				connection = DriverManager.
					getConnection("jdbc:h2:" + filename + ";PAGE_STORE=TRUE", "sa","");
				connection.setReadOnly(true);
			}
			catch (Exception ex) {
				// Do nothing for now
				return null;
			}
		}
		return connection;
	}
	
	protected LiveDataObject getLiveDataObject(int objectId, int classId) throws Exception {
		return getLiveDataObject(objectId, getClassName(classId));
	}
	
	protected HashMap<Integer, String> classNameCache = new HashMap<Integer, String>();
	protected String getClassName(int classId) throws Exception {
		
		String className = classNameCache.get(classId);
		if (className != null) return className;
		
		PreparedStatement getEClassKeyStatement = getConnection().prepareStatement("select name from Class where classId = ?");
		getEClassKeyStatement.setInt(1, classId);
		ResultSet rs = getEClassKeyStatement.executeQuery();
		rs.next();
		className = rs.getString(1);
		classNameCache.put(classId, className);
		return className;
	}
	
	protected HashMap<String, Integer> featureIdCache = new HashMap<String, Integer>();
	protected int getFeatureId(String name) throws Exception {
		if (featureIdCache.isEmpty()) {
			PreparedStatement statement = getConnection().prepareStatement("select * from Feature");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				featureIdCache.put(rs.getString(2), rs.getInt(1));
			}
		}
		return featureIdCache.get(name);
	}

	protected LiveDataObject getLiveDataObject(int objectId, String eClass) throws Exception {
		LiveDataObject ldo = new LiveDataObject();
		ldo.setId(objectId);
		ldo.setEClass(classForName(eClass));
		ldo.setStore(this);
		return ldo;
	}
	
	protected LiveDataObject getLiveDataObject(int objectId) throws Exception {
		
		PreparedStatement st = 
			getConnection().prepareStatement("select * from Object where objectId = ?");
		st.setInt(1, objectId);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			LiveDataObject ldo = createLiveDataObject(rs, null);
			return ldo;
		}
		else {
			return null;
		}
	}
	
	protected LiveDataObject createLiveDataObject(ResultSet rs, EClass eClass) throws Exception {
		
		int objectId = rs.getInt(1);
		LiveDataObject ldo = new LiveDataObject();
		ldo.setId(objectId);
		if (eClass == null) {
			eClass = classForName(getClassName(rs.getInt(2)));
		}
		ldo.setEClass(eClass);
		ldo.setStore(this);
		
		return ldo;
	}
	
	protected PreparedStatement getAllOfTypePreparedStatement = null;
	
	public List<LiveDataObject> getAllOfType(String type) {
		
		try {
//			Profiler.INSTANCE.start("cfn");
			EClass eClass = classForName(type);
//			Profiler.INSTANCE.stop();
			
			if (eClass == null) throw new Exception("No such type: " + type);
			
			ArrayList<LiveDataObject> result = new ArrayList<LiveDataObject>();
//			Profiler.INSTANCE.start("ps");
			
			if (getAllOfTypePreparedStatement == null) {
				getAllOfTypePreparedStatement = 
					getConnection().prepareStatement("select Object.objectId, Class.name from Object inner join Class on Object.classId = Class.classId where Class.name = ?");
			}
			
			getAllOfTypePreparedStatement.setString(1, type);
//			Profiler.INSTANCE.stop();
//			Profiler.INSTANCE.start("query");
			
			//System.err.println("Executing query...");
			ResultSet rs = getAllOfTypePreparedStatement.executeQuery();
			//System.err.println("Done...");
//			Profiler.INSTANCE.stop();
//			Profiler.INSTANCE.start("objects");
			while (rs.next()) {
				// result.add(createLiveDataObject(rs, eClass));
				result.add(getLiveDataObject(rs.getInt(1), rs.getString(2)));
			}
//			Profiler.INSTANCE.stop();
			
//			System.err.println("cfn :" + Profiler.INSTANCE.getTotalTime("cfn", true));
//			System.err.println("ps :" + Profiler.INSTANCE.getTotalTime("ps", true));
//			System.err.println("query :" + Profiler.INSTANCE.getTotalTime("query", true));
//			System.err.println("objects :" + Profiler.INSTANCE.getTotalTime("objects", true));
//			
			return result;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}
	
	protected HashMap<String, EClass> cachedEClasses = new HashMap<String, EClass>();
	
	protected EClass classForName(String className) throws EolModelElementTypeNotFoundException {
		
		EClass cached = cachedEClasses.get(className);
		if (cached != null) return cached;
		
		for (EPackage ePackage : ePackages) {
			for (EClassifier eClassifier : EmfUtil.getAllEClassifiers(ePackage)) {
				if (eClassifier.getName().equals(className)) {
					cached = (EClass) eClassifier;
					cachedEClasses.put(className, cached);
					return cached;
				}
			}
		}
		throw new EolModelElementTypeNotFoundException(this.getName(), className);
	}

	protected int getClassId(String eClass) throws Exception {
		int classId = 0;
		PreparedStatement getEClassKeyStatement = getConnection().prepareStatement("select classId from Class where name = ?");
		getEClassKeyStatement.setString(1, eClass);
		ResultSet rs = getEClassKeyStatement.executeQuery();
		if (rs.next()) {
			classId = rs.getInt(1);
		}
		else {
			PreparedStatement insertEClassStatement = getConnection().prepareStatement("insert into Class (name) values (?)", Statement.RETURN_GENERATED_KEYS);
			insertEClassStatement.setString(1, eClass);
			insertEClassStatement.executeUpdate();
			rs = insertEClassStatement.getGeneratedKeys();
			rs.next();
			classId = rs.getInt(1);
		}
		return classId;
	}
	
	@Override
	public Collection<?> allContents() {
		try {
			ArrayList<LiveDataObject> result = new ArrayList<LiveDataObject>();
			PreparedStatement st = getConnection().prepareStatement("select * from Object");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				result.add(createLiveDataObject(rs, null));
			}
			return result;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		throw new EolNotInstantiableModelElementTypeException(this.name, type);
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		throw new EolRuntimeException("Model " + this.name + " is read-only");
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Object getElementById(String id) {
		try {
			return getLiveDataObject(Integer.parseInt(id));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getElementId(Object instance) {
		if (instance instanceof LiveDataObject) {
			return ((LiveDataObject) instance).getId() + "";
		}
		return null;
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		if (instance instanceof LiveDataObject) {
			return ((LiveDataObject) instance).getEClass().getName();
		}
		return null;
	}

	@Override
	public Object getTypeOf(Object instance) {
		if (instance instanceof LiveDataObject) {
			return ((LiveDataObject) instance).getEClass();
		}
		return null;
	}

	@Override
	public boolean hasType(String type) {
		try {
			classForName(type);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		return instance instanceof LiveDataObject;
	}

	@Override
	public void load() throws EolModelLoadingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean owns(Object instance) {
		if (instance instanceof LiveDataObject) {
			return ((LiveDataObject) instance).getStore() == this;
		}
		return false;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// Do nothing
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}
	
	protected LiveDataObjectPropertyGetter getter = new LiveDataObjectPropertyGetter();
	protected LiveDataObjectPropertySetter setter = new LiveDataObjectPropertySetter();
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return getter;
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return setter;
	}
	/*
	@Override
	public Collection find(EolModelElementType type, String property,
			Object value) throws EolRuntimeException {
		
		EClass eClass = classForName(type.getName());
		try {
			int classId = getClassId(eClass.getName());
			return null;
		}
		catch (Exception ex) {
			throw new EolInternalException(ex);
		}
	}

	@Override
	public Object findOne(EolModelElementType type, String property,
			Object value) throws EolRuntimeException {
		// TODO Auto-generated method stub
		return null;
	} */
}
