/**
 */
package org.eclipse.epsilon.eol.eol.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getEReference0 <em>EReference0</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement()
 * @model
 * @generated
 */
public interface ModelDeclarationStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPackage> getPackages();

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
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.NameExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement_Alias()
	 * @model containment="true"
	 * @generated
	 */
	EList<NameExpression> getAlias();

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
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement_Driver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getDriver();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getDriver <em>Driver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' containment reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelDeclarationParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(ModelDeclarationStatement)
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getModelDeclarationStatement_EReference0()
	 * @model
	 * @generated
	 */
	ModelDeclarationStatement getEReference0();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(ModelDeclarationStatement value);

} // ModelDeclarationStatement
