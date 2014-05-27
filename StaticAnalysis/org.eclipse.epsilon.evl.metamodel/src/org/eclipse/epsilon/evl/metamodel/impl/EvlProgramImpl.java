/**
 */
package org.eclipse.epsilon.evl.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.metamodel.impl.EolLibraryModuleImpl;

import org.eclipse.epsilon.evl.metamodel.Context;
import org.eclipse.epsilon.evl.metamodel.EvlPackage;
import org.eclipse.epsilon.evl.metamodel.EvlProgram;
import org.eclipse.epsilon.evl.metamodel.PostBlock;
import org.eclipse.epsilon.evl.metamodel.PreBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.impl.EvlProgramImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.impl.EvlProgramImpl#getPreBlocks <em>Pre Blocks</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.impl.EvlProgramImpl#getPostBlocks <em>Post Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvlProgramImpl extends EolLibraryModuleImpl implements EvlProgram {
	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> contexts;

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
	protected EvlProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvlPackage.Literals.EVL_PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentEList<Context>(Context.class, this, EvlPackage.EVL_PROGRAM__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PreBlock> getPreBlocks() {
		if (preBlocks == null) {
			preBlocks = new EObjectContainmentEList<PreBlock>(PreBlock.class, this, EvlPackage.EVL_PROGRAM__PRE_BLOCKS);
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
			postBlocks = new EObjectContainmentEList<PostBlock>(PostBlock.class, this, EvlPackage.EVL_PROGRAM__POST_BLOCKS);
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
			case EvlPackage.EVL_PROGRAM__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
			case EvlPackage.EVL_PROGRAM__PRE_BLOCKS:
				return ((InternalEList<?>)getPreBlocks()).basicRemove(otherEnd, msgs);
			case EvlPackage.EVL_PROGRAM__POST_BLOCKS:
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
			case EvlPackage.EVL_PROGRAM__CONTEXTS:
				return getContexts();
			case EvlPackage.EVL_PROGRAM__PRE_BLOCKS:
				return getPreBlocks();
			case EvlPackage.EVL_PROGRAM__POST_BLOCKS:
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
			case EvlPackage.EVL_PROGRAM__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends Context>)newValue);
				return;
			case EvlPackage.EVL_PROGRAM__PRE_BLOCKS:
				getPreBlocks().clear();
				getPreBlocks().addAll((Collection<? extends PreBlock>)newValue);
				return;
			case EvlPackage.EVL_PROGRAM__POST_BLOCKS:
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
			case EvlPackage.EVL_PROGRAM__CONTEXTS:
				getContexts().clear();
				return;
			case EvlPackage.EVL_PROGRAM__PRE_BLOCKS:
				getPreBlocks().clear();
				return;
			case EvlPackage.EVL_PROGRAM__POST_BLOCKS:
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
			case EvlPackage.EVL_PROGRAM__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case EvlPackage.EVL_PROGRAM__PRE_BLOCKS:
				return preBlocks != null && !preBlocks.isEmpty();
			case EvlPackage.EVL_PROGRAM__POST_BLOCKS:
				return postBlocks != null && !postBlocks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EvlProgramImpl
