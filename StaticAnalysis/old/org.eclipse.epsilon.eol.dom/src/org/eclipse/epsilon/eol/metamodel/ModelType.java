/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelType#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelType#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelType()
 * @model
 * @generated
 */
public interface ModelType extends Type {
	/**
	 * Returns the value of the '<em><b>Model Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Name</em>' containment reference.
	 * @see #setModelName(NameExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelType_ModelName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getModelName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ModelType#getModelName <em>Model Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Name</em>' containment reference.
	 * @see #getModelName()
	 * @generated
	 */
	void setModelName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelType_Model()
	 * @model required="true"
	 * @generated
	 */
	EList<ModelDeclarationStatement> getModel();

} // ModelType
