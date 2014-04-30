/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.MethodCallExpression#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.MethodCallExpression#getMethod <em>Method</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.MethodCallExpression#getResolvedMethods <em>Resolved Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getMethodCallExpression()
 * @model
 * @generated
 */
public interface MethodCallExpression extends FeatureCallExpression {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getMethodCallExpression_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArguments();

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
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getMethodCallExpression_Method()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.MethodCallExpression#getMethod <em>Method</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' containment reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Resolved Methods</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Methods</em>' reference list.
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getMethodCallExpression_ResolvedMethods()
	 * @model
	 * @generated
	 */
	EList<EObject> getResolvedMethods();

} // MethodCallExpression
