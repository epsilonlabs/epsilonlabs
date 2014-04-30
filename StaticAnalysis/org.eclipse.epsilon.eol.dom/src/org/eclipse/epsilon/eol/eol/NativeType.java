/**
 */
package org.eclipse.epsilon.eol.eol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.NativeType#getNativeExpression <em>Native Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getNativeType()
 * @model
 * @generated
 */
public interface NativeType extends Type {
	/**
	 * Returns the value of the '<em><b>Native Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Expression</em>' containment reference.
	 * @see #setNativeExpression(StringExpression)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getNativeType_NativeExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StringExpression getNativeExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.NativeType#getNativeExpression <em>Native Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Expression</em>' containment reference.
	 * @see #getNativeExpression()
	 * @generated
	 */
	void setNativeExpression(StringExpression value);

} // NativeType
