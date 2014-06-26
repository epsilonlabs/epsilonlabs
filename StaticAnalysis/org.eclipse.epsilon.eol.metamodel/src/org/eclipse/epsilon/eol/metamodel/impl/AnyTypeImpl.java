/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.AnyTypeImpl#getDynamicType <em>Dynamic Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.AnyTypeImpl#isDeclared <em>Declared</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnyTypeImpl extends TypeImpl implements AnyType {
	/**
	 * The cached value of the '{@link #getDynamicType() <em>Dynamic Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicType()
	 * @generated
	 * @ordered
	 */
	protected Type dynamicType;

	/**
	 * The default value of the '{@link #isDeclared() <em>Declared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclared()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECLARED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeclared() <em>Declared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclared()
	 * @generated
	 * @ordered
	 */
	protected boolean declared = DECLARED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.ANY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getDynamicType() {
		return dynamicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicType(Type newDynamicType, NotificationChain msgs) {
		Type oldDynamicType = dynamicType;
		dynamicType = newDynamicType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.ANY_TYPE__DYNAMIC_TYPE, oldDynamicType, newDynamicType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicType(Type newDynamicType) {
		if (newDynamicType != dynamicType) {
			NotificationChain msgs = null;
			if (dynamicType != null)
				msgs = ((InternalEObject)dynamicType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.ANY_TYPE__DYNAMIC_TYPE, null, msgs);
			if (newDynamicType != null)
				msgs = ((InternalEObject)newDynamicType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.ANY_TYPE__DYNAMIC_TYPE, null, msgs);
			msgs = basicSetDynamicType(newDynamicType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.ANY_TYPE__DYNAMIC_TYPE, newDynamicType, newDynamicType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeclared() {
		return declared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclared(boolean newDeclared) {
		boolean oldDeclared = declared;
		declared = newDeclared;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.ANY_TYPE__DECLARED, oldDeclared, declared));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.ANY_TYPE__DYNAMIC_TYPE:
				return basicSetDynamicType(null, msgs);
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
			case EolPackage.ANY_TYPE__DYNAMIC_TYPE:
				return getDynamicType();
			case EolPackage.ANY_TYPE__DECLARED:
				return isDeclared();
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
			case EolPackage.ANY_TYPE__DYNAMIC_TYPE:
				setDynamicType((Type)newValue);
				return;
			case EolPackage.ANY_TYPE__DECLARED:
				setDeclared((Boolean)newValue);
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
			case EolPackage.ANY_TYPE__DYNAMIC_TYPE:
				setDynamicType((Type)null);
				return;
			case EolPackage.ANY_TYPE__DECLARED:
				setDeclared(DECLARED_EDEFAULT);
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
			case EolPackage.ANY_TYPE__DYNAMIC_TYPE:
				return dynamicType != null;
			case EolPackage.ANY_TYPE__DECLARED:
				return declared != DECLARED_EDEFAULT;
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
		result.append(" (declared: ");
		result.append(declared);
		result.append(')');
		return result.toString();
	}

} //AnyTypeImpl
