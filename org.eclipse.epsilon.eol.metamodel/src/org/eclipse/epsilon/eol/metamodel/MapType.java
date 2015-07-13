/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.MapType#getKeyType <em>Key Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.MapType#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getMapType()
 * @model
 * @generated
 */
public interface MapType extends AnyType {
	/**
	 * Returns the value of the '<em><b>Key Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Type</em>' reference.
	 * @see #setKeyType(AnyType)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getMapType_KeyType()
	 * @model
	 * @generated
	 */
	AnyType getKeyType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.MapType#getKeyType <em>Key Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Type</em>' reference.
	 * @see #getKeyType()
	 * @generated
	 */
	void setKeyType(AnyType value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' reference.
	 * @see #setValueType(AnyType)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getMapType_ValueType()
	 * @model
	 * @generated
	 */
	AnyType getValueType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.MapType#getValueType <em>Value Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' reference.
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(AnyType value);

} // MapType
