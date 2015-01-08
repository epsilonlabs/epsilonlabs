/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NativeExpression#getNativeExpr <em>Native Expr</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NativeExpression#getIsType <em>Is Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNativeExpression()
 * @model
 * @generated
 */
public interface NativeExpression extends LiteralExpression {
	/**
	 * Returns the value of the '<em><b>Native Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Expr</em>' containment reference.
	 * @see #setNativeExpr(StringExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNativeExpression_NativeExpr()
	 * @model containment="true"
	 * @generated
	 */
	StringExpression getNativeExpr();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.NativeExpression#getNativeExpr <em>Native Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Expr</em>' containment reference.
	 * @see #getNativeExpr()
	 * @generated
	 */
	void setNativeExpr(StringExpression value);

	/**
	 * Returns the value of the '<em><b>Is Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Type</em>' containment reference.
	 * @see #setIsType(BooleanExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNativeExpression_IsType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanExpression getIsType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.NativeExpression#getIsType <em>Is Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Type</em>' containment reference.
	 * @see #getIsType()
	 * @generated
	 */
	void setIsType(BooleanExpression value);

} // NativeExpression
