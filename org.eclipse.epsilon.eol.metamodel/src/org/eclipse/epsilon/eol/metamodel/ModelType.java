/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelType#getResolvedIModel <em>Resolved IModel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelType()
 * @model
 * @generated
 */
public interface ModelType extends AnyType {
	/**
	 * Returns the value of the '<em><b>Resolved IModel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved IModel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved IModel</em>' reference.
	 * @see #setResolvedIModel(IModel)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelType_ResolvedIModel()
	 * @model required="true"
	 * @generated
	 */
	IModel getResolvedIModel();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ModelType#getResolvedIModel <em>Resolved IModel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved IModel</em>' reference.
	 * @see #getResolvedIModel()
	 * @generated
	 */
	void setResolvedIModel(IModel value);

} // ModelType
