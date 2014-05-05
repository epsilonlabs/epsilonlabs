/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throw Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ThrowStatement#getThrown <em>Thrown</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getThrowStatement()
 * @model
 * @generated
 */
public interface ThrowStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Thrown</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thrown</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thrown</em>' containment reference.
	 * @see #setThrown(Expression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getThrowStatement_Thrown()
	 * @model containment="true"
	 * @generated
	 */
	Expression getThrown();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ThrowStatement#getThrown <em>Thrown</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thrown</em>' containment reference.
	 * @see #getThrown()
	 * @generated
	 */
	void setThrown(Expression value);

} // ThrowStatement
