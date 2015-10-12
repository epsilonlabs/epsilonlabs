/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.IMetamodel;
import org.eclipse.epsilon.eol.metamodel.IModel;
import org.eclipse.epsilon.eol.metamodel.ModelType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelTypeImpl#getResolvedIModel <em>Resolved IModel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelTypeImpl extends AnyTypeImpl implements ModelType {
	/**
	 * The cached value of the '{@link #getResolvedIModel() <em>Resolved IModel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedIModel()
	 * @generated
	 * @ordered
	 */
	protected IMetamodel resolvedIModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.MODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMetamodel getResolvedIModel() {
		if (resolvedIModel != null && resolvedIModel.eIsProxy()) {
			InternalEObject oldResolvedIModel = (InternalEObject)resolvedIModel;
			resolvedIModel = (IMetamodel)eResolveProxy(oldResolvedIModel);
			if (resolvedIModel != oldResolvedIModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.MODEL_TYPE__RESOLVED_IMODEL, oldResolvedIModel, resolvedIModel));
			}
		}
		return resolvedIModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMetamodel basicGetResolvedIModel() {
		return resolvedIModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedIModel(IMetamodel newResolvedIModel) {
		IMetamodel oldResolvedIModel = resolvedIModel;
		resolvedIModel = newResolvedIModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_TYPE__RESOLVED_IMODEL, oldResolvedIModel, resolvedIModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EolPackage.MODEL_TYPE__RESOLVED_IMODEL:
				if (resolve) return getResolvedIModel();
				return basicGetResolvedIModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EolPackage.MODEL_TYPE__RESOLVED_IMODEL:
				setResolvedIModel((IMetamodel)newValue);
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
			case EolPackage.MODEL_TYPE__RESOLVED_IMODEL:
				setResolvedIModel((IMetamodel)null);
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
			case EolPackage.MODEL_TYPE__RESOLVED_IMODEL:
				return resolvedIModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelTypeImpl
