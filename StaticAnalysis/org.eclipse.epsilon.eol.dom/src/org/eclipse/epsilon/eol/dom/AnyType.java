/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Any Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.AnyType#getTempType <em>Temp Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getAnyType()
 * @model
 * @generated
 */
public interface AnyType extends Type {
	/**
	 * Returns the value of the '<em><b>Temp Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Type</em>' containment reference.
	 * @see #setTempType(Type)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getAnyType_TempType()
	 * @model containment="true"
	 * @generated
	 */
	Type getTempType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.AnyType#getTempType <em>Temp Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Type</em>' containment reference.
	 * @see #getTempType()
	 * @generated
	 */
	void setTempType(Type value);

} // AnyType
