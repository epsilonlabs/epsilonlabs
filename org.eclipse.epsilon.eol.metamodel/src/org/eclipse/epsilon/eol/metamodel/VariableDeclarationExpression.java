/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression#isIsCreate <em>Is Create</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getVariableDeclarationExpression()
 * @model
 * @generated
 */
public interface VariableDeclarationExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Is Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Create</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Create</em>' attribute.
	 * @see #setIsCreate(boolean)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getVariableDeclarationExpression_IsCreate()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsCreate();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression#isIsCreate <em>Is Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Create</em>' attribute.
	 * @see #isIsCreate()
	 * @generated
	 */
	void setIsCreate(boolean value);

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
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getVariableDeclarationExpression_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getVariableDeclarationExpression_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getParameters();

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.NameExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getVariableDeclarationExpression_References()
	 * @model
	 * @generated
	 */
	EList<NameExpression> getReferences();

} // VariableDeclarationExpression
