/**
 */
package org.eclipse.epsilon.eol.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.PropertyCallExpression#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.PropertyCallExpression#getExtended <em>Extended</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getPropertyCallExpression()
 * @model
 * @generated
 */
public interface PropertyCallExpression extends FeatureCallExpression {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference.
	 * @see #setProperty(NameExpression)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getPropertyCallExpression_Property()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.PropertyCallExpression#getProperty <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' containment reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Extended</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended</em>' containment reference.
	 * @see #setExtended(BooleanExpression)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getPropertyCallExpression_Extended()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanExpression getExtended();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.PropertyCallExpression#getExtended <em>Extended</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended</em>' containment reference.
	 * @see #getExtended()
	 * @generated
	 */
	void setExtended(BooleanExpression value);

} // PropertyCallExpression
