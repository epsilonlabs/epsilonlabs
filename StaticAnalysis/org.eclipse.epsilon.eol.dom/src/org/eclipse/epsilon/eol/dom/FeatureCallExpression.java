/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression#isArrow <em>Arrow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.DomPackage#getFeatureCallExpression()
 * @model abstract="true"
 * @generated
 */
public interface FeatureCallExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see org.eclipse.epsilon.eol.dom.DomPackage#getFeatureCallExpression_Target()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Arrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow</em>' attribute.
	 * @see #setArrow(boolean)
	 * @see org.eclipse.epsilon.eol.dom.DomPackage#getFeatureCallExpression_Arrow()
	 * @model
	 * @generated
	 */
	boolean isArrow();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression#isArrow <em>Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrow</em>' attribute.
	 * @see #isArrow()
	 * @generated
	 */
	void setArrow(boolean value);

} // FeatureCallExpression
