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

} // AnyType
