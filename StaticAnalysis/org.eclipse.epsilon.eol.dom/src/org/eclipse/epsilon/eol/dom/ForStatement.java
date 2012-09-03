/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.dom;

import org.eclipse.emf.common.util.EList;

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
 * @see org.eclipse.epsilon.eol.dom.DomPackage#getForStatement()
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
	 * @see #setIterator(VariableDeclarationExpression)
	 * @see org.eclipse.epsilon.eol.dom.DomPackage#getForStatement_Iterator()
	 * @model containment="true"
	 * @generated
	 */
	VariableDeclarationExpression getIterator();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(VariableDeclarationExpression value);

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
	 * @see org.eclipse.epsilon.eol.dom.DomPackage#getForStatement_Iterated()
	 * @model containment="true"
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
	 * Returns the value of the '<em><b>Body</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.dom.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.dom.DomPackage#getForStatement_Body()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getBody();

} // ForStatement
