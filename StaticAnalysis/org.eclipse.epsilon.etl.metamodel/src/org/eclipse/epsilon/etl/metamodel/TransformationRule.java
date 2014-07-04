/**
 */
package org.eclipse.epsilon.etl.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getAnnotationBlock <em>Annotation Block</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getResolvedParentRules <em>Resolved Parent Rules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getResolvedRuleDependencies <em>Resolved Rule Dependencies</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getGuard <em>Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule()
 * @model
 * @generated
 */
public interface TransformationRule extends EtlElement {
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
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(FormalParameterExpression)
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FormalParameterExpression getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(FormalParameterExpression value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.FormalParameterExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' containment reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_Targets()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormalParameterExpression> getTargets();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_Body()
	 * @model containment="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * Returns the value of the '<em><b>Annotation Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Block</em>' containment reference.
	 * @see #setAnnotationBlock(AnnotationBlock)
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_AnnotationBlock()
	 * @model containment="true"
	 * @generated
	 */
	AnnotationBlock getAnnotationBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getAnnotationBlock <em>Annotation Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Block</em>' containment reference.
	 * @see #getAnnotationBlock()
	 * @generated
	 */
	void setAnnotationBlock(AnnotationBlock value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.NameExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_Extends()
	 * @model containment="true"
	 * @generated
	 */
	EList<NameExpression> getExtends();

	/**
	 * Returns the value of the '<em><b>Resolved Parent Rules</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.etl.metamodel.TransformationRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Parent Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Parent Rules</em>' reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_ResolvedParentRules()
	 * @model
	 * @generated
	 */
	EList<TransformationRule> getResolvedParentRules();

	/**
	 * Returns the value of the '<em><b>Resolved Rule Dependencies</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.etl.metamodel.RuleDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Rule Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Rule Dependencies</em>' reference list.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_ResolvedRuleDependencies()
	 * @model
	 * @generated
	 */
	EList<RuleDependency> getResolvedRuleDependencies();

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Guard)
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#getTransformationRule_Guard()
	 * @model containment="true"
	 * @generated
	 */
	Guard getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Guard value);

} // TransformationRule
