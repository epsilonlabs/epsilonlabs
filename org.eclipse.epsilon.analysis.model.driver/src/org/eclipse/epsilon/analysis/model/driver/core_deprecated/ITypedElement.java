package org.eclipse.epsilon.analysis.model.driver.core_deprecated;

public abstract class ITypedElement extends INamedElement{

	protected boolean ordered;
	protected boolean unique;
	protected int lowerBound;
	protected int upperBound;
	protected boolean many;
	protected boolean required;
	
	protected IClassifier iType;
	
	public ITypedElement(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public IClassifier getiType() {
		return iType;
	}
	
	public void setiType(IClassifier iType) {
		this.iType = iType;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public boolean isMany() {
		return many;
	}

	public void setMany(boolean many) {
		this.many = many;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	

}
