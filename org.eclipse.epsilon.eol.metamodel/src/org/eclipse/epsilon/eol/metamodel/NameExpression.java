/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NameExpression#getResolvedContents <em>Resolved Contents</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.NameExpression#isIsType <em>Is Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNameExpression()
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
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNameExpression_Name()
	 * @model required="true"
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
	 * Returns the value of the '<em><b>Resolved Contents</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Contents</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Contents</em>' attribute list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNameExpression_ResolvedContents()
	 * @model
	 * @generated
	 */
	EList<Object> getResolvedContents();

	/**
	 * Returns the value of the '<em><b>Is Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Type</em>' attribute.
	 * @see #setIsType(boolean)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getNameExpression_IsType()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.NameExpression#isIsType <em>Is Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Type</em>' attribute.
	 * @see #isIsType()
	 * @generated
	 */
	void setIsType(boolean value);

} // NameExpression
