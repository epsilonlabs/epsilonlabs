package org.eclipse.epsilon.emc.metaedit;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;

import com.metacase.API.MEOop;
import com.metacase.API.METype;
import com.metacase.API.MetaEditAPIPortType;

public class MetaEditModel extends Model {

	protected MEOop model = null;
	protected MetaEditAPIPortType port = null;
	
	public static void main(String[] args) throws Exception {

		MetaEditModel m = new MetaEditModel();
		m.setName("F");
		m.load();
		
		EolModule module = new EolModule();
		module.parse("Button.all.collect(b|b.`Name [Watch]`).println();");
		//module.parse("context Action { constraint SomeName { check: self.name <> '' message: ''} } ")
		//module.parse("for (t in F!Transition.all) { (t.source.name + ' -> ' + t.target.name).println(); }");
		//module.parse(new File(MetaEditModel.class.getResource("test.eol").toURI()));
		module.getContext().getModelRepository().addModel(m);
		module.execute();
	}

	@Override
	public void load() throws EolModelLoadingException {
		com.metacase.API.MetaEditAPI meServer = null;
		com.metacase.API.METype graphType = new com.metacase.API.METype();
		com.metacase.API.MEOop[] graphs = null;

		try {
			meServer = new com.metacase.API.MetaEditAPILocator();
			port = meServer.getMetaEditAPIPort();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.exit(1);
		}
		graphType.setName("WatchApplication");
		try {
			graphs = port.allGoodInstances(graphType);
			model = graphs[0];
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.exit(1);
		}
		
		allContents();
		
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected ArrayList<MEOop> objects = null;
	protected ArrayList<MEOop> relationships = null;
	
	@Override
	public Collection<MEOop> allContents() {
		
		try {
			if (objects == null) {
				objects = new ArrayList<MEOop>();
				for (MEOop o : port.objectSet(model)) {
					objects.add(o);
				}
				relationships = new ArrayList<MEOop>();
				for (MEOop o : port.relationshipSet(model)) {
					relationships.add(o);
				}
			}
		}
		catch (Exception ex) {ex.printStackTrace();}
		
		return objects;
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
	
		ArrayList<MEOop> allOfKind = new ArrayList<MEOop>();
		
		try {
			for (MEOop o : objects) {
				if (type.equals(port.typeName(port.type(o)))) {
					allOfKind.add(o);
				}
				if (allOfKind.isEmpty()) {
					for (MEOop r : relationships) {
						if (port.typeName(port.type(r)).equals(type)) {
							allOfKind.add(r);
						}
					}
				}
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return allOfKind;
	}

	@Override
	public Object getTypeOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean owns(Object instance) {
		return objects.contains(instance) || relationships.contains(instance);
	}

	@Override
	public boolean isInstantiable(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		// TODO Auto-generated method stub
		return false;
	}

	protected ArrayList<String> types = null;
	
	@Override
	public boolean hasType(String type) {
		try {
			METype objectType = new METype("OPRRObj");
			METype returnedType = port.subTypeNamed(objectType, type);
			if (objectType.getName().equals(returnedType.getName())) {
				METype relationshipType = new METype("Relationship");
				returnedType = port.subTypeNamed(objectType, type);
				return !relationshipType.getName().equals(returnedType.getName());
			}
			else {
				return true;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean store(String location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isObject(MEOop o) {
		for (MEOop candidate : objects) {
			if (candidate.getAreaID() == o.getAreaID() && 
					candidate.getObjectID() == o.getObjectID()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isRelationship(MEOop b) {
		for (MEOop candidate : relationships) {
			if (candidate.getAreaID() == b.getAreaID() && 
					candidate.getObjectID() == b.getObjectID()) {
				return true;
			}
		}
		return false;
	}
	
	protected MetaEditPropertyGetter propertyGetter = new MetaEditPropertyGetter();

	@Override
	public IPropertyGetter getPropertyGetter() {
		propertyGetter.setModel(this);
		propertyGetter.setPort(port);
		return propertyGetter;
	}

	protected IPropertySetter propertySetter = new MetaEditPropertySetter();

	@Override
	public IPropertySetter getPropertySetter() {
		return propertySetter;
	}

}
