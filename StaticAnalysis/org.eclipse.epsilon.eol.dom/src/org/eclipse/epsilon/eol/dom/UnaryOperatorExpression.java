/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Operator Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.UnaryOperatorExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getUnaryOperatorExpression()
 * @model abstract="true"
 * @generated
 */
public interface UnaryOperatorExpression extends OperatorExpression {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Expression)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getUnaryOperatorExpression_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.UnaryOperatorExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

} // UnaryOperatorExpression
