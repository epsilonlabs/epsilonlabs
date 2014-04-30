/**
 */
package org.eclipse.epsilon.eol.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getImportedModules <em>Imported Modules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getBlock <em>Block</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getModelDeclarations <em>Model Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EolElement {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Imported Modules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.Program}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Modules</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram_ImportedModules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Program> getImportedModules();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.OperationDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationDefinition> getOperations();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram_Block()
	 * @model containment="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

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
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.eol.metamodel.Program#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Model Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Declarations</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.metamodel.EolPackage#getProgram_ModelDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelDeclarationStatement> getModelDeclarations();

} // Program
