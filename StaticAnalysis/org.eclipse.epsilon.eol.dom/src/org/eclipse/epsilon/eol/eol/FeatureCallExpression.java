/**
 */
package org.eclipse.epsilon.eol.eol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.FeatureCallExpression#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.FeatureCallExpression#getIsArrow <em>Is Arrow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getFeatureCallExpression()
 * @model abstract="true"
 * @generated
 */
public interface FeatureCallExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getFeatureCallExpression_Target()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.FeatureCallExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Is Arrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Arrow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Arrow</em>' containment reference.
	 * @see #setIsArrow(BooleanExpression)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getFeatureCallExpression_IsArrow()
	 * @model containment="true"
	 * @generated
	 */
	BooleanExpression getIsArrow();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.FeatureCallExpression#getIsArrow <em>Is Arrow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Arrow</em>' containment reference.
	 * @see #getIsArrow()
	 * @generated
	 */
	void setIsArrow(BooleanExpression value);

} // FeatureCallExpression
