/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.Expression#getResolvedType <em>Resolved Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends DomElement {
	/**
	 * Returns the value of the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Type</em>' containment reference.
	 * @see #setResolvedType(Type)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getExpression_ResolvedType()
	 * @model containment="true"
	 * @generated
	 */
	Type getResolvedType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.Expression#getResolvedType <em>Resolved Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Type</em>' containment reference.
	 * @see #getResolvedType()
	 * @generated
	 */
	void setResolvedType(Type value);

} // Expression
