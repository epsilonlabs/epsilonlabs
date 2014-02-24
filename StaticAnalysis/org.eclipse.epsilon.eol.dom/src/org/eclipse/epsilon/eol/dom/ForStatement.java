/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterated <em>Iterated</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference.
	 * @see #setIterator(FormalParameterExpression)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getForStatement_Iterator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FormalParameterExpression getIterator();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(FormalParameterExpression value);

	/**
	 * Returns the value of the '<em><b>Iterated</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterated</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterated</em>' containment reference.
	 * @see #setIterated(Expression)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getForStatement_Iterated()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getIterated();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterated <em>Iterated</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterated</em>' containment reference.
	 * @see #getIterated()
	 * @generated
	 */
	void setIterated(Expression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getForStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

} // ForStatement
