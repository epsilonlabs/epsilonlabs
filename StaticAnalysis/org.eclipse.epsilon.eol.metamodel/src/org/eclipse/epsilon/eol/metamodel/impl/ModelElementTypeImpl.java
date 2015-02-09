/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelElementTypeImpl#getEcoreType <em>Ecore Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelElementTypeImpl#getResolvedModelDeclaration <em>Resolved Model Declaration</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelElementTypeImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelElementTypeImpl#getElementName <em>Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementTypeImpl extends TypeImpl implements ModelElementType {
	/**
	 * The cached value of the '{@link #getEcoreType() <em>Ecore Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier ecoreType;

	/**
	 * The cached value of the '{@link #getResolvedModelDeclaration() <em>Resolved Model Declaration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedModelDeclaration()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclarationStatement> resolvedModelDeclaration;

	/**
	 * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected String modelName = MODEL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected String elementName = ELEMENT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.MODEL_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getEcoreType() {
		if (ecoreType != null && ecoreType.eIsProxy()) {
			InternalEObject oldEcoreType = (InternalEObject)ecoreType;
			ecoreType = (EClassifier)eResolveProxy(oldEcoreType);
			if (ecoreType != oldEcoreType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE, oldEcoreType, ecoreType));
			}
		}
		return ecoreType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetEcoreType() {
		return ecoreType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreType(EClassifier newEcoreType) {
		EClassifier oldEcoreType = ecoreType;
		ecoreType = newEcoreType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE, oldEcoreType, ecoreType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclarationStatement> getResolvedModelDeclaration() {
		if (resolvedModelDeclaration == null) {
			resolvedModelDeclaration = new EObjectResolvingEList<ModelDeclarationStatement>(ModelDeclarationStatement.class, this, EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION);
		}
		return resolvedModelDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelName(String newModelName) {
		String oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_ELEMENT_TYPE__MODEL_NAME, oldModelName, modelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementName() {
		return elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementName(String newElementName) {
		String oldElementName = elementName;
		elementName = newElementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_ELEMENT_TYPE__ELEMENT_NAME, oldElementName, elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE:
				if (resolve) return getEcoreType();
				return basicGetEcoreType();
			case EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION:
				return getResolvedModelDeclaration();
			case EolPackage.MODEL_ELEMENT_TYPE__MODEL_NAME:
				return getModelName();
			case EolPackage.MODEL_ELEMENT_TYPE__ELEMENT_NAME:
				return getElementName();
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
			case EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE:
				setEcoreType((EClassifier)newValue);
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION:
				getResolvedModelDeclaration().clear();
				getResolvedModelDeclaration().addAll((Collection<? extends ModelDeclarationStatement>)newValue);
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__MODEL_NAME:
				setModelName((String)newValue);
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__ELEMENT_NAME:
				setElementName((String)newValue);
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
			case EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE:
				setEcoreType((EClassifier)null);
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION:
				getResolvedModelDeclaration().clear();
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__MODEL_NAME:
				setModelName(MODEL_NAME_EDEFAULT);
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__ELEMENT_NAME:
				setElementName(ELEMENT_NAME_EDEFAULT);
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
			case EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE:
				return ecoreType != null;
			case EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION:
				return resolvedModelDeclaration != null && !resolvedModelDeclaration.isEmpty();
			case EolPackage.MODEL_ELEMENT_TYPE__MODEL_NAME:
				return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
			case EolPackage.MODEL_ELEMENT_TYPE__ELEMENT_NAME:
				return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelName: ");
		result.append(modelName);
		result.append(", elementName: ");
		result.append(elementName);
		result.append(')');
		return result.toString();
	}

} //ModelElementTypeImpl
