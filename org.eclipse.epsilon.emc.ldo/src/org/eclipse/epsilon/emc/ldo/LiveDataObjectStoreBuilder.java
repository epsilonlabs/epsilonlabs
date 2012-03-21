package org.eclipse.epsilon.emc.ldo;

import java.io.File;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.h2.tools.RunScript;
import org.h2.tools.Script;

public class LiveDataObjectStoreBuilder extends LiveDataObjectStore {
	
	protected String filename = null;
	protected Connection connection = null;
	
	public LiveDataObjectStoreBuilder(String filename) {
		this.filename = filename;
	}
	
	protected boolean needsNewConnection() {
		try {
			return (connection == null || connection.isClosed());
		} catch (SQLException e) {
			return true;
		}	
	}
	
	public void dispose() {
		if (!needsNewConnection()) {
			try {
				//getConnection().prepareStatement("shutdown compact").executeUpdate();
				//System.err.println("executing");
//				//RunScript.execute(getConnection(), new StringReader("shutdown compact"));
//			    String file = filename + "/text.sql";
//			    String url = "jdbc:h2:" + filename + ";PAGE_STORE=TRUE";
//			    Script.execute(url, "sa", "", file);
//			    File dbfile = new File(filename + ".h2.db");
//			    if (dbfile.exists()) dbfile.delete();
//			    File tracefile = new File(filename + ".trace.db");
//			    if (tracefile.exists()) tracefile.delete();
//			    
//			    RunScript.execute(url, "sa", "", file, null, false);
				getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected Connection getConnection() {
		if (needsNewConnection()) {
			try {
				Class.forName("org.h2.Driver");
				connection = DriverManager.
					getConnection("jdbc:h2:" + filename + ";PAGE_STORE=TRUE", "sa","");
			}
			catch (Exception ex) {
				// Do nothing for now
				return null;
			}
		}
		return connection;
	}
	
	public void initialize(boolean createIndices) throws SQLException, ClassNotFoundException {
		
		Statement st = getConnection().createStatement();
		st.executeUpdate("drop table if exists Object");
		st.executeUpdate("drop table if exists Class");
		st.executeUpdate("drop table if exists Feature");
		st.executeUpdate("drop table if exists FeatureValueCount");
		st.executeUpdate("drop table if exists AttributeValue");
		st.executeUpdate("drop table if exists ReferenceValue");
		
		// Removed foreign keys because the database is immutable and is correct
		// by construction (hopefully) and so they just delay insertion.
		
//		st.executeUpdate("create table Class (classId INT AUTO_INCREMENT, name NVARCHAR(255))");
//		st.executeUpdate("create table Object (objectId INT AUTO_INCREMENT, classId INT)");
//		st.executeUpdate("create table Attribute (attributeId INT AUTO_INCREMENT, name NVARCHAR(255))");
//		st.executeUpdate("create table AttributeValue (objectId INT, attributeId INT, value CLOB, " +
//						 "foreign key (attributeId) references Attribute(attributeId))");
//		st.executeUpdate("create table Reference (referenceId INT AUTO_INCREMENT, name NVARCHAR(255))");
//		st.executeUpdate("create table ReferenceValue (objectId INT, referenceId INT, value INT, valueClassId INT, " +
//						 "foreign key (referenceId) references Reference(referenceId), " +
//						 "foreign key (valueClassId) references Class(classId))");
//		
		st.executeUpdate("create table Class (classId INT AUTO_INCREMENT, name NVARCHAR(255))");
		st.executeUpdate("create table Object (objectId INT AUTO_INCREMENT, classId INT)");
		st.executeUpdate("create table Feature (featureId INT AUTO_INCREMENT, name NVARCHAR(255))");
		st.executeUpdate("create table AttributeValue (objectId INT, attributeId INT, value CLOB)");
		st.executeUpdate("create table ReferenceValue (objectId INT, referenceId INT, value INT, valueClassId INT)");
		
		// FeatureValueCount is used to find the exact number of referenced elements and use limit = ?
		// Improves performance a lot (~50% in preliminary tests)
		st.executeUpdate("create table FeatureValueCount (objectId INT, featureId INT, valueCount INT)");
		
		if (createIndices) {
			//st.executeUpdate("create index featureName on Feature(name)");
			//st.executeUpdate("create index className on Class(name)");
			//st.executeUpdate("create index attributeValueIndex on AttributeValue(objectId, attributeId)");
			//st.executeUpdate("create index referenceValueIndex on ReferenceValue(objectId, referenceId)");
			st.executeUpdate("create index featureValueCountIndex on FeatureValueCount(objectId, featureId)");
			
		}
		
		connection.commit();
	}
	
	
	
	protected int addObject(String eClass) throws Exception {
		
		int classId = getClassId(eClass);
		
		PreparedStatement st = 
			getConnection().prepareStatement("insert into Object (classId) values (?) ", Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, classId);
		st.executeUpdate();
		ResultSet rs = st.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);
	}
	
	protected void addAttributeValue(int objectId, String attribute, String value) throws Exception {
		PreparedStatement st = 
			getConnection().prepareStatement("insert into AttributeValue values (?,?,?) ");
		st.setInt(1, objectId);
		st.setInt(2, getFeatureId(attribute, true));
		st.setString(3, value);
		st.executeUpdate();		
	}

	protected void addReferenceValue(int objectId, String reference, int value, String valueClass) throws Exception {
		
		PreparedStatement st = 
			getConnection().prepareStatement("insert into ReferenceValue values (?,?,?,?) ");
		st.setInt(1, objectId);
		st.setInt(2, getFeatureId(reference, true));
		st.setInt(3, value);
		st.setInt(4, getClassId(valueClass));
		st.executeUpdate();		
	}
	
	protected void addFeatureValueCount(int objectId, String reference, int valueCount) throws Exception {
		
		PreparedStatement st = 
			getConnection().prepareStatement("insert into FeatureValueCount values (?,?,?) ");
		st.setInt(1, objectId);
		st.setInt(2, getFeatureId(reference, true));
		st.setInt(3, valueCount);
		st.executeUpdate();		
	}

	protected void addAttributeValueCount(int objectId, String reference, int valueCount) throws Exception {
	
	PreparedStatement st = 
		getConnection().prepareStatement("insert into ReferenceValueCount values (?,?,?) ");
	st.setInt(1, objectId);
	st.setInt(2, getFeatureId(reference, true));
	st.setInt(3, valueCount);
	st.executeUpdate();		
}


	protected int getFeatureId(String name, boolean insertIfNotExists) throws Exception {
		Integer featureId = featureIdCache.get(name);
		if (featureId != null) return featureId;
		
		PreparedStatement getFeatureIdStatement = getConnection().prepareStatement("select featureId from Feature where name = ?");
		getFeatureIdStatement.setString(1, name);
		ResultSet rs = getFeatureIdStatement.executeQuery();
		if (rs.next()) {
			featureId = rs.getInt(1);
		}
		else {
			if (insertIfNotExists) {
				PreparedStatement insertFeatureStatement = getConnection().prepareStatement("insert into Feature (name) values (?)", Statement.RETURN_GENERATED_KEYS);
				insertFeatureStatement.setString(1, name);
				insertFeatureStatement.executeUpdate();
				rs = insertFeatureStatement.getGeneratedKeys();
				rs.next();
				featureId = rs.getInt(1);
			}
			else {
				featureId = -1;
			}
		}
		featureIdCache.put(name, featureId);
		return featureId;
	}
	
	protected HashSet<EReference> storedEReferences = new HashSet<EReference>();
	
	public void add(EObject root, boolean storeDerived) throws Exception {
		
		List<EObject> eObjects = EObjectUtil.asList(root);
		HashMap<EObject, Integer> eObjectIds = new HashMap<EObject, Integer>();
		
		for (EObject eObject : eObjects) {
			eObjectIds.put(eObject, addObject(eObject.eClass().getName()));
		}
		
		for (EObject eObject : eObjects) {
			
			int objectId = eObjectIds.get(eObject);
			
			for (EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
				
				if (eAttribute.isDerived() && !storeDerived) continue;
				
				if (!eAttribute.isMany()) {
					Object value = eObject.eGet(eAttribute);
					if (value != null && !value.equals(eAttribute.getDefaultValue())) {
						addAttributeValue(eObjectIds.get(eObject), eAttribute.getName(), value + "");
						addFeatureValueCount(objectId, eAttribute.getName(), 1);
					}
					else {
						addFeatureValueCount(objectId, eAttribute.getName(), 0);
					}
				}
				else {
					Collection values = (Collection) eObject.eGet(eAttribute);
					addFeatureValueCount(objectId, eAttribute.getName(), values.size());
					
					for (Object value : values) {
						addAttributeValue(objectId, eAttribute.getName(), value + "");						
					}
				}
			}
			
			for (EReference eReference : eObject.eClass().getEAllReferences()) {
				
				if (eReference.isDerived() && !storeDerived) continue;
				
				/*
				if (eReference.getEOpposite() != null && eReference.getEOpposite() != eReference) {
					if (storedEReferences.contains(eReference.getEOpposite())) { continue; }
					else if (!storedEReferences.contains(eReference)) storedEReferences.add(eReference);
				}*/
				
				if (!eReference.isMany()) {
					Object value = eObject.eGet(eReference);
					if (value != null && eObjectIds.containsKey(value)) {
						addReferenceValue(objectId, eReference.getName(), eObjectIds.get(value), ((EObject) value).eClass().getName());
						addFeatureValueCount(objectId, eReference.getName(), 1);
					}
					else {
						addFeatureValueCount(objectId, eReference.getName(), 0);
					}
				}
				else {
					Collection values = (Collection) eObject.eGet(eReference);
					addFeatureValueCount(eObjectIds.get(eObject), eReference.getName(), values.size());
					for (Object value : values) {
						if (value != null && eObjectIds.containsKey(value))
						addReferenceValue(eObjectIds.get(eObject), eReference.getName(), eObjectIds.get(value), ((EObject) value).eClass().getName());						
					}
				}
			}
		}
		
		connection.commit();
		// connection.close();
	}
	
	

}
