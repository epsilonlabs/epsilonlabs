/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolLibraryModule#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolLibraryModule#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolLibraryModule#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolLibraryModule#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolLibraryModule()
 * @model
 * @generated
 */
public interface EolLibraryModule extends EolElement {
	/**
	 * Returns the value of the '<em><b>Model Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Declarations</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolLibraryModule_ModelDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelDeclarationStatement> getModelDeclarations();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolLibraryModule_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.OperationDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolLibraryModule_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationDefinition> getOperations();

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
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolLibraryModule_Name()
	 * @model containment="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolLibraryModule#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

} // EolLibraryModule
