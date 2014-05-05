/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ReturnStatement#getReturned <em>Returned</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getReturnStatement()
 * @model
 * @generated
 */
public interface ReturnStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Returned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returned</em>' containment reference.
	 * @see #setReturned(Expression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getReturnStatement_Returned()
	 * @model containment="true"
	 * @generated
	 */
	Expression getReturned();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ReturnStatement#getReturned <em>Returned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returned</em>' containment reference.
	 * @see #getReturned()
	 * @generated
	 */
	void setReturned(Expression value);

} // ReturnStatement
