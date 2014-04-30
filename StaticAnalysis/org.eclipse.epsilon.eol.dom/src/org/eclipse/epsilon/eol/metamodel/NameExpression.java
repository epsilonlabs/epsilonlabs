/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getIsType <em>Is Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getResolvedContent <em>Resolved Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getNameExpression()
 * @model
 * @generated
 */
public interface NameExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getNameExpression_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Type</em>' containment reference.
	 * @see #setIsType(BooleanExpression)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getNameExpression_IsType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanExpression getIsType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getIsType <em>Is Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Type</em>' containment reference.
	 * @see #getIsType()
	 * @generated
	 */
	void setIsType(BooleanExpression value);

	/**
	 * Returns the value of the '<em><b>Resolved Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Content</em>' attribute.
	 * @see #setResolvedContent(Object)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getNameExpression_ResolvedContent()
	 * @model required="true" transient="true"
	 * @generated
	 */
	Object getResolvedContent();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getResolvedContent <em>Resolved Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Content</em>' attribute.
	 * @see #getResolvedContent()
	 * @generated
	 */
	void setResolvedContent(Object value);

} // NameExpression
