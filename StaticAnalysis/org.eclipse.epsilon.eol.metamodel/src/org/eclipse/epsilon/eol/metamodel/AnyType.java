/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Any Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.AnyType#getDynamicType <em>Dynamic Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.AnyType#isDeclared <em>Declared</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getAnyType()
 * @model
 * @generated
 */
public interface AnyType extends Type {
	/**
	 * Returns the value of the '<em><b>Dynamic Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Type</em>' containment reference.
	 * @see #setDynamicType(Type)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getAnyType_DynamicType()
	 * @model containment="true"
	 * @generated
	 */
	Type getDynamicType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.AnyType#getDynamicType <em>Dynamic Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Type</em>' containment reference.
	 * @see #getDynamicType()
	 * @generated
	 */
	void setDynamicType(Type value);

	/**
	 * Returns the value of the '<em><b>Declared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared</em>' attribute.
	 * @see #setDeclared(boolean)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getAnyType_Declared()
	 * @model
	 * @generated
	 */
	boolean isDeclared();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.AnyType#isDeclared <em>Declared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared</em>' attribute.
	 * @see #isDeclared()
	 * @generated
	 */
	void setDeclared(boolean value);

} // AnyType
