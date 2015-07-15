package org.eclipse.epsilon.analysis.model.driver.core;

import java.util.ArrayList;
import java.util.List;


public class IClass extends IClassifier{

	protected boolean _abstract;
	protected boolean _interface;
	
	protected List<IClassifier> iSuperTypes = new ArrayList<IClassifier>();
	protected List<IClassifier> iAllSuperTypes = new ArrayList<IClassifier>();
	
	protected List<IOperation> iOperations = new ArrayList<IOperation>();
	
	protected List<IStructuralFeature> iStructuralFeatures = new ArrayList<IStructuralFeature>();
	protected List<IStructuralFeature> iAllStructuralFeatures = new ArrayList<IStructuralFeature>();
	
	protected List<IReference> iReferences = new ArrayList<IReference>();
	protected List<IAttribute> iAttributes = new ArrayList<IAttribute>();
	
	public IClass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean is_abstract() {
		return _abstract;
	}
	
	public void set_abstract(boolean _abstract) {
		this._abstract = _abstract;
	}
	
	public boolean is_interface() {
		return _interface;
	}
	
	public void set_interface(boolean _interface) {
		this._interface = _interface;
	}

}
