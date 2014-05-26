/**
 */
package org.eclipse.epsilon.evl.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.EvlProgram#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.EvlProgram#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.EvlProgram#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.EvlProgram#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.EvlProgram#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getEvlProgram()
 * @model
 * @generated
 */
public interface EvlProgram extends EvlElement {
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
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getEvlProgram_Imports()
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
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getEvlProgram_Operations()
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
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getEvlProgram_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.evl.metamodel.EvlProgram#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

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
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getEvlProgram_ModelDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelDeclarationStatement> getModelDeclarations();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.evl.metamodel.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getEvlProgram_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Context> getContexts();

} // EvlProgram
