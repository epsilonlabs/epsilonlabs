/**
 */
package org.eclipse.epsilon.evl.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.metamodel.NameExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Invariant#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Invariant#getFix <em>Fix</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Invariant#getCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Invariant#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getInvariant()
 * @model abstract="true"
 * @generated
 */
public interface Invariant extends GuardedElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(NameExpression)
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getInvariant_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.evl.metamodel.Invariant#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Fix</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.evl.metamodel.Fix}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fix</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fix</em>' containment reference list.
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getInvariant_Fix()
	 * @model containment="true"
	 * @generated
	 */
	EList<Fix> getFix();

	/**
	 * Returns the value of the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' containment reference.
	 * @see #setCheck(ExpressionOrStatementBlock)
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getInvariant_Check()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionOrStatementBlock getCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.evl.metamodel.Invariant#getCheck <em>Check</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' containment reference.
	 * @see #getCheck()
	 * @generated
	 */
	void setCheck(ExpressionOrStatementBlock value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' containment reference.
	 * @see #setMessage(ExpressionOrStatementBlock)
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getInvariant_Message()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionOrStatementBlock getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.evl.metamodel.Invariant#getMessage <em>Message</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' containment reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(ExpressionOrStatementBlock value);

} // Invariant
