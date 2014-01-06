/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.BooleanExpression#isVal <em>Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getBooleanExpression()
 * @model
 * @generated
 */
public interface BooleanExpression extends PrimitiveExpression {
	/**
	 * Returns the value of the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Val</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Val</em>' attribute.
	 * @see #setVal(boolean)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getBooleanExpression_Val()
	 * @model
	 * @generated
	 */
	boolean isVal();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.BooleanExpression#isVal <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Val</em>' attribute.
	 * @see #isVal()
	 * @generated
	 */
	void setVal(boolean value);

} // BooleanExpression
