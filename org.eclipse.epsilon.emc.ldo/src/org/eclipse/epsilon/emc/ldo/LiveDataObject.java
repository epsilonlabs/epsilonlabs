package org.eclipse.epsilon.emc.ldo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;

public class LiveDataObject {
	
	protected int id;
	protected LiveDataObjectStore store;
	protected EClass eClass;

	public LiveDataObject() {
		LiveDataObjectRegistry.INSTANCE.register(this);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public EClass getEClass() {
		return eClass;
	}

	public void setEClass(EClass eClass) {
		this.eClass = eClass;
	}
	
	public LiveDataObjectStore getStore() {
		return store;
	}
	
	public void setStore(LiveDataObjectStore store) {
		this.store = store;
	}
	
	protected int getFeatureValueCount(int featureId) throws Exception {
		if (getFeatureValueCountPreparedStatement == null) {
			getFeatureValueCountPreparedStatement = 
				store.getConnection().prepareStatement
					("select valueCount from FeatureValueCount where objectId = ? and featureId = ? limit 1");	
		}
		
		getFeatureValueCountPreparedStatement.setInt(1, id);
		getFeatureValueCountPreparedStatement.setInt(2, featureId);
		ResultSet rs = getFeatureValueCountPreparedStatement.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	protected final String attributeValueQuery = 
		"select value from AttributeValue " +
		"where objectId = ? and attributeId = ? limit ?";
	protected PreparedStatement getAttributeValuePreparedStatement = null;
	
	protected final String referenceValueQuery = 
		"select value, valueClassId from ReferenceValue " +
		"where ReferenceValue.objectId = ? and ReferenceValue.referenceId = ? limit ?";	
	protected PreparedStatement getReferenceValuePreparedStatement = null;
	
	protected PreparedStatement getFeatureValueCountPreparedStatement = null;
	
	public Object get(String property) throws Exception {
		
		EStructuralFeature sf = eClass.getEStructuralFeature(property); 
		
		if (sf == null) throw new Exception("No such property: " + property);
		
		int featureId = store.getFeatureId(sf.getName());
		
		if (sf instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute) sf;
			
			if (getAttributeValuePreparedStatement == null) {
				getAttributeValuePreparedStatement = 
					store.getConnection().prepareStatement(attributeValueQuery);
			}
			
			getAttributeValuePreparedStatement.setInt(1, id);
			getAttributeValuePreparedStatement.setInt(2, featureId);
			ResultSet rs = null;
			
			if (!eAttribute.isMany()) {
				
				if (getFeatureValueCount(featureId) == 0) { return eAttribute.getDefaultValue();}
				
				getAttributeValuePreparedStatement.setInt(3, 1);
				
				rs = getAttributeValuePreparedStatement.executeQuery();
				if (rs.next()) {
					return cast(rs.getString(1), eAttribute.getEType());
				}
				else {
					return eAttribute.getDefaultValue();
				}
			}
			else {
				Collection values = createCollectionFor(sf);
				
				int valueCount = getFeatureValueCount(featureId);
				if (valueCount == 0) return values;
				else getAttributeValuePreparedStatement.setInt(3, valueCount);
				
				rs = getAttributeValuePreparedStatement.executeQuery();
				
				for (int i = 1; i< valueCount; i ++) { // while rs.next() is a bit slower
					rs.absolute(i);
					values.add(cast(rs.getString(1), eAttribute.getEType()));
				}
				return values;
			}
		}
		else if (sf instanceof EReference) {
			EReference eReference = (EReference) sf;
			
			if (getReferenceValuePreparedStatement == null) {
				getReferenceValuePreparedStatement = 
					store.getConnection().prepareStatement
						(referenceValueQuery);	
			}
			
			getReferenceValuePreparedStatement.setInt(1, id);
			getReferenceValuePreparedStatement.setInt(2, store.getFeatureId(property));
			ResultSet rs = null; 
			
			//TODO: Add support for Settings in the database
			if (!eReference.isMany()) {
				
				if (getFeatureValueCount(featureId) == 0) { return null; }
				
				getReferenceValuePreparedStatement.setInt(3, 1);
				rs = getReferenceValuePreparedStatement.executeQuery();
				
				if (rs.next()) {
					return store.getLiveDataObject(rs.getInt(1), rs.getInt(2));
				}
				else {
					return null;
				}
			}
			else {
				int valueCount = getFeatureValueCount(featureId);
				Collection values = createCollectionFor(sf);
				
				if (valueCount == 0) return values;
				else getReferenceValuePreparedStatement.setInt(3, valueCount);
				
				getReferenceValuePreparedStatement.setInt(3, valueCount);
				rs = getReferenceValuePreparedStatement.executeQuery();
				
				for (int i = 1; i< valueCount; i++) { // for () is faster than while(rs.next())
					rs.absolute(i);
					values.add(store.getLiveDataObject(rs.getInt(1), rs.getInt(2)));
				}
				return values;
			}			
		}
		return null;
	}
	
	protected Collection createCollectionFor(EStructuralFeature sf) {
		if (sf.isOrdered() && sf.isUnique()) return new EolOrderedSet();
		else if (sf.isOrdered()) return new EolSequence();
		else if (sf.isUnique()) return new EolSet();
		else return new EolBag();
	}
	
	protected Object cast(String value, EClassifier eClassifier) {
		
		Class instanceClass = eClassifier.getInstanceClass();
		
		if (instanceClass == Boolean.class) {
			return Boolean.parseBoolean(value);
		}
		else if (instanceClass == Integer.class) {
			return Integer.parseInt(value);
		}
		
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof LiveDataObject) {
			LiveDataObject o = (LiveDataObject) other;
			return this.getId() == o.getId() && 
				this.getStore().equals(o.getStore());
		}
		else {
			return false;
		}
	}
	
}
