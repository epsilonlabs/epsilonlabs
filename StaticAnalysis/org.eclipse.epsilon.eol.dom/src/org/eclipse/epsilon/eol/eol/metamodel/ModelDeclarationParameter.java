/**
 */
package org.eclipse.epsilon.eol.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Declaration Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationParameter#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationParameter()
 * @model
 * @generated
 */
public interface ModelDeclarationParameter extends EolElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(NameExpression)
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationParameter_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationParameter#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(StringExpression)
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationParameter_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StringExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationParameter#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(StringExpression value);

} // ModelDeclarationParameter
