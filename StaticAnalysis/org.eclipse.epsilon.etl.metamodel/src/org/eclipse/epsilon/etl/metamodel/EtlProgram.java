/**
 */
package org.eclipse.epsilon.etl.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.epsilon.eol.metamodel.EolLibraryModule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
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
public interface EtlProgram extends EolLibraryModule {
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
