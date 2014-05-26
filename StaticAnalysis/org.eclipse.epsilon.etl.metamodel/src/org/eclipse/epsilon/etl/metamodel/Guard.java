/**
 */
package org.eclipse.epsilon.etl.metamodel;

import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.Guard#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends EtlElement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ExpressionOrStatementBlock)
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getGuard_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionOrStatementBlock getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.Guard#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ExpressionOrStatementBlock value);

} // Guard
