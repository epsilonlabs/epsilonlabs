/**
 */
package org.eclipse.epsilon.eol.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.epsilon.eol.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.eol.metamodel.ModelType;
import org.eclipse.epsilon.eol.eol.metamodel.NameExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ModelTypeImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ModelTypeImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelTypeImpl extends TypeImpl implements ModelType {
	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected NameExpression modelName;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclarationStatement> model;

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
	public NameExpression getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelName(NameExpression newModelName, NotificationChain msgs) {
		NameExpression oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_TYPE__MODEL_NAME, oldModelName, newModelName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelName(NameExpression newModelName) {
		if (newModelName != modelName) {
			NotificationChain msgs = null;
			if (modelName != null)
				msgs = ((InternalEObject)modelName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_TYPE__MODEL_NAME, null, msgs);
			if (newModelName != null)
				msgs = ((InternalEObject)newModelName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_TYPE__MODEL_NAME, null, msgs);
			msgs = basicSetModelName(newModelName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_TYPE__MODEL_NAME, newModelName, newModelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclarationStatement> getModel() {
		if (model == null) {
			model = new EObjectResolvingEList<ModelDeclarationStatement>(ModelDeclarationStatement.class, this, EolPackage.MODEL_TYPE__MODEL);
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.MODEL_TYPE__MODEL_NAME:
				return basicSetModelName(null, msgs);
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
			case EolPackage.MODEL_TYPE__MODEL_NAME:
				return getModelName();
			case EolPackage.MODEL_TYPE__MODEL:
				return getModel();
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
			case EolPackage.MODEL_TYPE__MODEL_NAME:
				setModelName((NameExpression)newValue);
				return;
			case EolPackage.MODEL_TYPE__MODEL:
				getModel().clear();
				getModel().addAll((Collection<? extends ModelDeclarationStatement>)newValue);
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
			case EolPackage.MODEL_TYPE__MODEL_NAME:
				setModelName((NameExpression)null);
				return;
			case EolPackage.MODEL_TYPE__MODEL:
				getModel().clear();
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
			case EolPackage.MODEL_TYPE__MODEL_NAME:
				return modelName != null;
			case EolPackage.MODEL_TYPE__MODEL:
				return model != null && !model.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelTypeImpl
