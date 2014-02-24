/**
 */
package org.eclipse.epsilon.eol.dom.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.dom.EolPackage;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.ModelElementType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl#getEcoreType <em>Ecore Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl#getResolvedModelDeclaration <em>Resolved Model Declaration</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl#getElementName <em>Element Name</em>}</li>
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
	 * The cached value of the '{@link #getResolvedModelDeclaration() <em>Resolved Model Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedModelDeclaration()
	 * @generated
	 * @ordered
	 */
	protected ModelDeclarationStatement resolvedModelDeclaration;

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
	public ModelDeclarationStatement getResolvedModelDeclaration() {
		if (resolvedModelDeclaration != null && resolvedModelDeclaration.eIsProxy()) {
			InternalEObject oldResolvedModelDeclaration = (InternalEObject)resolvedModelDeclaration;
			resolvedModelDeclaration = (ModelDeclarationStatement)eResolveProxy(oldResolvedModelDeclaration);
			if (resolvedModelDeclaration != oldResolvedModelDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION, oldResolvedModelDeclaration, resolvedModelDeclaration));
			}
		}
		return resolvedModelDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclarationStatement basicGetResolvedModelDeclaration() {
		return resolvedModelDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedModelDeclaration(ModelDeclarationStatement newResolvedModelDeclaration) {
		ModelDeclarationStatement oldResolvedModelDeclaration = resolvedModelDeclaration;
		resolvedModelDeclaration = newResolvedModelDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION, oldResolvedModelDeclaration, resolvedModelDeclaration));
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
				if (resolve) return getResolvedModelDeclaration();
				return basicGetResolvedModelDeclaration();
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EolPackage.MODEL_ELEMENT_TYPE__ECORE_TYPE:
				setEcoreType((EClassifier)newValue);
				return;
			case EolPackage.MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION:
				setResolvedModelDeclaration((ModelDeclarationStatement)newValue);
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
				setResolvedModelDeclaration((ModelDeclarationStatement)null);
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
				return resolvedModelDeclaration != null;
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
