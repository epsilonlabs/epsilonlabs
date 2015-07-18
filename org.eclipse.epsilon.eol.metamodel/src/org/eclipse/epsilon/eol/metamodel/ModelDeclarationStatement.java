/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getImodel <em>Imodel</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelDeclarationStatement()
 * @model
 * @generated
 */
public interface ModelDeclarationStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(VariableDeclarationExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelDeclarationStatement_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDeclarationExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(VariableDeclarationExpression value);

	/**
	 * Returns the value of the '<em><b>Driver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' containment reference.
	 * @see #setDriver(NameExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelDeclarationStatement_Driver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getDriver();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getDriver <em>Driver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' containment reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelDeclarationStatement_Alias()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclarationExpression> getAlias();

	/**
	 * Returns the value of the '<em><b>Imodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imodel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imodel</em>' containment reference.
	 * @see #setImodel(IModel)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelDeclarationStatement_Imodel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IModel getImodel();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement#getImodel <em>Imodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imodel</em>' containment reference.
	 * @see #getImodel()
	 * @generated
	 */
	void setImodel(IModel value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getModelDeclarationStatement_Parameters()
	 * @model
	 * @generated
	 */
	EList<ModelDeclarationParameter> getParameters();

} // ModelDeclarationStatement
