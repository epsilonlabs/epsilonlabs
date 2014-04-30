/**
 */
package org.eclipse.epsilon.eol.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FOL Method Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.FOLMethodCallExpression#getIterators <em>Iterators</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.FOLMethodCallExpression#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.FOLMethodCallExpression#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getFOLMethodCallExpression()
 * @model
 * @generated
 */
public interface FOLMethodCallExpression extends FeatureCallExpression {
	/**
	 * Returns the value of the '<em><b>Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.FormalParameterExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterators</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getFOLMethodCallExpression_Iterators()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<FormalParameterExpression> getIterators();

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getFOLMethodCallExpression_Conditions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getConditions();

	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference.
	 * @see #setMethod(NameExpression)
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getFOLMethodCallExpression_Method()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.FOLMethodCallExpression#getMethod <em>Method</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' containment reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(NameExpression value);

} // FOLMethodCallExpression
