/**
 */
package org.eclipse.epsilon.etl.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;

import org.eclipse.epsilon.etl.metamodel.EtlPackage;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getTransformationRules <em>Transformation Rules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getPreBlocks <em>Pre Blocks</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl#getPostBlocks <em>Post Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EtlProgramImpl extends EtlElementImpl implements EtlProgram {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationDefinition> operations;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected NameExpression name;

	/**
	 * The cached value of the '{@link #getModelDeclarations() <em>Model Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclarationStatement> modelDeclarations;

	/**
	 * The cached value of the '{@link #getTransformationRules() <em>Transformation Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationRules()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationRule> transformationRules;

	/**
	 * The cached value of the '{@link #getPreBlocks() <em>Pre Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<PreBlock> preBlocks;

	/**
	 * The cached value of the '{@link #getPostBlocks() <em>Post Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<PostBlock> postBlocks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EtlProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtlPackage.Literals.ETL_PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, EtlPackage.ETL_PROGRAM__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationDefinition> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<OperationDefinition>(OperationDefinition.class, this, EtlPackage.ETL_PROGRAM__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(NameExpression newName, NotificationChain msgs) {
		NameExpression oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtlPackage.ETL_PROGRAM__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(NameExpression newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtlPackage.ETL_PROGRAM__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtlPackage.ETL_PROGRAM__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtlPackage.ETL_PROGRAM__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclarationStatement> getModelDeclarations() {
		if (modelDeclarations == null) {
			modelDeclarations = new EObjectContainmentEList<ModelDeclarationStatement>(ModelDeclarationStatement.class, this, EtlPackage.ETL_PROGRAM__MODEL_DECLARATIONS);
		}
		return modelDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransformationRule> getTransformationRules() {
		if (transformationRules == null) {
			transformationRules = new EObjectContainmentEList<TransformationRule>(TransformationRule.class, this, EtlPackage.ETL_PROGRAM__TRANSFORMATION_RULES);
		}
		return transformationRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PreBlock> getPreBlocks() {
		if (preBlocks == null) {
			preBlocks = new EObjectContainmentEList<PreBlock>(PreBlock.class, this, EtlPackage.ETL_PROGRAM__PRE_BLOCKS);
		}
		return preBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PostBlock> getPostBlocks() {
		if (postBlocks == null) {
			postBlocks = new EObjectContainmentEList<PostBlock>(PostBlock.class, this, EtlPackage.ETL_PROGRAM__POST_BLOCKS);
		}
		return postBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtlPackage.ETL_PROGRAM__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case EtlPackage.ETL_PROGRAM__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case EtlPackage.ETL_PROGRAM__NAME:
				return basicSetName(null, msgs);
			case EtlPackage.ETL_PROGRAM__MODEL_DECLARATIONS:
				return ((InternalEList<?>)getModelDeclarations()).basicRemove(otherEnd, msgs);
			case EtlPackage.ETL_PROGRAM__TRANSFORMATION_RULES:
				return ((InternalEList<?>)getTransformationRules()).basicRemove(otherEnd, msgs);
			case EtlPackage.ETL_PROGRAM__PRE_BLOCKS:
				return ((InternalEList<?>)getPreBlocks()).basicRemove(otherEnd, msgs);
			case EtlPackage.ETL_PROGRAM__POST_BLOCKS:
				return ((InternalEList<?>)getPostBlocks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EtlPackage.ETL_PROGRAM__IMPORTS:
				return getImports();
			case EtlPackage.ETL_PROGRAM__OPERATIONS:
				return getOperations();
			case EtlPackage.ETL_PROGRAM__NAME:
				return getName();
			case EtlPackage.ETL_PROGRAM__MODEL_DECLARATIONS:
				return getModelDeclarations();
			case EtlPackage.ETL_PROGRAM__TRANSFORMATION_RULES:
				return getTransformationRules();
			case EtlPackage.ETL_PROGRAM__PRE_BLOCKS:
				return getPreBlocks();
			case EtlPackage.ETL_PROGRAM__POST_BLOCKS:
				return getPostBlocks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EtlPackage.ETL_PROGRAM__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case EtlPackage.ETL_PROGRAM__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationDefinition>)newValue);
				return;
			case EtlPackage.ETL_PROGRAM__NAME:
				setName((NameExpression)newValue);
				return;
			case EtlPackage.ETL_PROGRAM__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				getModelDeclarations().addAll((Collection<? extends ModelDeclarationStatement>)newValue);
				return;
			case EtlPackage.ETL_PROGRAM__TRANSFORMATION_RULES:
				getTransformationRules().clear();
				getTransformationRules().addAll((Collection<? extends TransformationRule>)newValue);
				return;
			case EtlPackage.ETL_PROGRAM__PRE_BLOCKS:
				getPreBlocks().clear();
				getPreBlocks().addAll((Collection<? extends PreBlock>)newValue);
				return;
			case EtlPackage.ETL_PROGRAM__POST_BLOCKS:
				getPostBlocks().clear();
				getPostBlocks().addAll((Collection<? extends PostBlock>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EtlPackage.ETL_PROGRAM__IMPORTS:
				getImports().clear();
				return;
			case EtlPackage.ETL_PROGRAM__OPERATIONS:
				getOperations().clear();
				return;
			case EtlPackage.ETL_PROGRAM__NAME:
				setName((NameExpression)null);
				return;
			case EtlPackage.ETL_PROGRAM__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				return;
			case EtlPackage.ETL_PROGRAM__TRANSFORMATION_RULES:
				getTransformationRules().clear();
				return;
			case EtlPackage.ETL_PROGRAM__PRE_BLOCKS:
				getPreBlocks().clear();
				return;
			case EtlPackage.ETL_PROGRAM__POST_BLOCKS:
				getPostBlocks().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EtlPackage.ETL_PROGRAM__IMPORTS:
				return imports != null && !imports.isEmpty();
			case EtlPackage.ETL_PROGRAM__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case EtlPackage.ETL_PROGRAM__NAME:
				return name != null;
			case EtlPackage.ETL_PROGRAM__MODEL_DECLARATIONS:
				return modelDeclarations != null && !modelDeclarations.isEmpty();
			case EtlPackage.ETL_PROGRAM__TRANSFORMATION_RULES:
				return transformationRules != null && !transformationRules.isEmpty();
			case EtlPackage.ETL_PROGRAM__PRE_BLOCKS:
				return preBlocks != null && !preBlocks.isEmpty();
			case EtlPackage.ETL_PROGRAM__POST_BLOCKS:
				return postBlocks != null && !postBlocks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EtlProgramImpl
