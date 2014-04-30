/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.CollectionExpression#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.CollectionExpression#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.CollectionExpression#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getCollectionExpression()
 * @model abstract="true"
 * @generated
 */
public interface CollectionExpression extends LiteralExpression {
	/**
	 * Returns the value of the '<em><b>Parameter List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter List</em>' containment reference.
	 * @see #setParameterList(CollectionInitValue)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getCollectionExpression_ParameterList()
	 * @model containment="true"
	 * @generated
	 */
	CollectionInitValue getParameterList();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.CollectionExpression#getParameterList <em>Parameter List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter List</em>' containment reference.
	 * @see #getParameterList()
	 * @generated
	 */
	void setParameterList(CollectionInitValue value);

	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' containment reference.
	 * @see #setContentType(Type)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getCollectionExpression_ContentType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getContentType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.CollectionExpression#getContentType <em>Content Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' containment reference.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(Type value);

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.LiteralExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getCollectionExpression_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<LiteralExpression> getContents();

} // CollectionExpression
