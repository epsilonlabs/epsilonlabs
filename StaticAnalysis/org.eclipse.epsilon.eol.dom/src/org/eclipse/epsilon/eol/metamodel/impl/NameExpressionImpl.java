/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.eol.BooleanExpression;
import org.eclipse.epsilon.eol.eol.EolPackage;
import org.eclipse.epsilon.eol.eol.NameExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl#getIsType <em>Is Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NameExpressionImpl#getResolvedContent <em>Resolved Content</em>}</li>
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
	 * The cached value of the '{@link #getIsType() <em>Is Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsType()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression isType;

	/**
	 * The default value of the '{@link #getResolvedContent() <em>Resolved Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedContent()
	 * @generated
	 * @ordered
	 */
	protected static final Object RESOLVED_CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResolvedContent() <em>Resolved Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedContent()
	 * @generated
	 * @ordered
	 */
	protected Object resolvedContent = RESOLVED_CONTENT_EDEFAULT;

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
	public BooleanExpression getIsType() {
		return isType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsType(BooleanExpression newIsType, NotificationChain msgs) {
		BooleanExpression oldIsType = isType;
		isType = newIsType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.NAME_EXPRESSION__IS_TYPE, oldIsType, newIsType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsType(BooleanExpression newIsType) {
		if (newIsType != isType) {
			NotificationChain msgs = null;
			if (isType != null)
				msgs = ((InternalEObject)isType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.NAME_EXPRESSION__IS_TYPE, null, msgs);
			if (newIsType != null)
				msgs = ((InternalEObject)newIsType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.NAME_EXPRESSION__IS_TYPE, null, msgs);
			msgs = basicSetIsType(newIsType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NAME_EXPRESSION__IS_TYPE, newIsType, newIsType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getResolvedContent() {
		return resolvedContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedContent(Object newResolvedContent) {
		Object oldResolvedContent = resolvedContent;
		resolvedContent = newResolvedContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NAME_EXPRESSION__RESOLVED_CONTENT, oldResolvedContent, resolvedContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				return basicSetIsType(null, msgs);
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
			case EolPackage.NAME_EXPRESSION__NAME:
				return getName();
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				return getIsType();
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENT:
				return getResolvedContent();
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
			case EolPackage.NAME_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				setIsType((BooleanExpression)newValue);
				return;
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENT:
				setResolvedContent(newValue);
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
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				setIsType((BooleanExpression)null);
				return;
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENT:
				setResolvedContent(RESOLVED_CONTENT_EDEFAULT);
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
			case EolPackage.NAME_EXPRESSION__IS_TYPE:
				return isType != null;
			case EolPackage.NAME_EXPRESSION__RESOLVED_CONTENT:
				return RESOLVED_CONTENT_EDEFAULT == null ? resolvedContent != null : !RESOLVED_CONTENT_EDEFAULT.equals(resolvedContent);
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
		result.append(", resolvedContent: ");
		result.append(resolvedContent);
		result.append(')');
		return result.toString();
	}

} //NameExpressionImpl
