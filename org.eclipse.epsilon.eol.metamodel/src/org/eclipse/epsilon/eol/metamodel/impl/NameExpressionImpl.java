/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.NameExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl#getResolvedContents <em>Resolved Contents</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl#isIsType <em>Is Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameExpressionImpl extends ExpressionImpl implements NameExpression {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResolvedContents() <em>Resolved Contents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedContents()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> resolvedContents;

	/**
	 * The default value of the '{@link #isIsType() <em>Is Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsType() <em>Is Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsType()
	 * @generated
	 * @ordered
	 */
	protected boolean isType = IS_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.NAME_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NAME_EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getResolvedContents() {
		if (resolvedContents == null) {
			resolvedContents = new EDataTypeUniqueEList<Object>(Object.class, this, EolPackage.NAME_EXPRESSION__RESOLVED_CONTENTS);
		}
		return resolvedContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsType() {
		return isType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsType(boolean newIsType) {
		boolean oldIsType = isType;
		isType = newIsType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NAME_EXPRESSION__IS_TYPE, oldIsType, isType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EolPackage.NAME_EXPRESSION__NAME:
				return getName();
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENTS:
				return getResolvedContents();
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				return isIsType();
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
			case EolPackage.NAME_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENTS:
				getResolvedContents().clear();
				getResolvedContents().addAll((Collection<? extends Object>)newValue);
				return;
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				setIsType((Boolean)newValue);
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
			case EolPackage.NAME_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENTS:
				getResolvedContents().clear();
				return;
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				setIsType(IS_TYPE_EDEFAULT);
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
			case EolPackage.NAME_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENTS:
				return resolvedContents != null && !resolvedContents.isEmpty();
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				return isType != IS_TYPE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", resolvedContents: ");
		result.append(resolvedContents);
		result.append(", isType: ");
		result.append(isType);
		result.append(')');
		return result.toString();
	}

} //NameExpressionImpl
