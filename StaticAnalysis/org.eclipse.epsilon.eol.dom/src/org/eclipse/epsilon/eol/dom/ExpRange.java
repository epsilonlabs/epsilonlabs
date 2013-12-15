/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exp Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ExpRange#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ExpRange#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getExpRange()
 * @model
 * @generated
 */
public interface ExpRange extends CollectionInitValue {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(Expression)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getExpRange_Start()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ExpRange#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Expression value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' containment reference.
	 * @see #setEnd(Expression)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getExpRange_End()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ExpRange#getEnd <em>End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' containment reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Expression value);

} // ExpRange
