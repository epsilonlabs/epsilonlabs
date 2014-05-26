/**
 */
package org.eclipse.epsilon.etl.metamodel;

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
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getTransformationRules <em>Transformation Rules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getPreBlocks <em>Pre Blocks</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getPostBlocks <em>Post Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram()
 * @model
 * @generated
 */
public interface EtlProgram extends EtlElement {
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
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_Imports()
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
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_Operations()
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
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getName <em>Name</em>}' containment reference.
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
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_ModelDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelDeclarationStatement> getModelDeclarations();

	/**
	 * Returns the value of the '<em><b>Transformation Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.etl.metamodel.TransformationRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Rules</em>' containment reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_TransformationRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationRule> getTransformationRules();

	/**
	 * Returns the value of the '<em><b>Pre Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.etl.metamodel.PreBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Blocks</em>' containment reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_PreBlocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<PreBlock> getPreBlocks();

	/**
	 * Returns the value of the '<em><b>Post Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.etl.metamodel.PostBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Blocks</em>' containment reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getEtlProgram_PostBlocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<PostBlock> getPostBlocks();

} // EtlProgram
