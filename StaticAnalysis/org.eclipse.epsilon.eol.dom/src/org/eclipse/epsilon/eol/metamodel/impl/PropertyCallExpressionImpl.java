/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.eol.EolPackage;

import org.eclipse.epsilon.eol.metamodel.BooleanExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.PropertyCallExpressionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.PropertyCallExpressionImpl#getExtended <em>Extended</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyCallExpressionImpl extends FeatureCallExpressionImpl implements PropertyCallExpression {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected NameExpression property;

	/**
	 * The cached value of the '{@link #getExtended() <em>Extended</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtended()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression extended;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyCallExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.PROPERTY_CALL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(NameExpression newProperty, NotificationChain msgs) {
		NameExpression oldProperty = property;
		property = newProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY, oldProperty, newProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(NameExpression newProperty) {
		if (newProperty != property) {
			NotificationChain msgs = null;
			if (property != null)
				msgs = ((InternalEObject)property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY, null, msgs);
			if (newProperty != null)
				msgs = ((InternalEObject)newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY, null, msgs);
			msgs = basicSetProperty(newProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY, newProperty, newProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getExtended() {
		return extended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtended(BooleanExpression newExtended, NotificationChain msgs) {
		BooleanExpression oldExtended = extended;
		extended = newExtended;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED, oldExtended, newExtended);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtended(BooleanExpression newExtended) {
		if (newExtended != extended) {
			NotificationChain msgs = null;
			if (extended != null)
				msgs = ((InternalEObject)extended).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED, null, msgs);
			if (newExtended != null)
				msgs = ((InternalEObject)newExtended).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED, null, msgs);
			msgs = basicSetExtended(newExtended, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED, newExtended, newExtended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY:
				return basicSetProperty(null, msgs);
			case EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED:
				return basicSetExtended(null, msgs);
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
			case EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY:
				return getProperty();
			case EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED:
				return getExtended();
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
			case EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY:
				setProperty((NameExpression)newValue);
				return;
			case EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED:
				setExtended((BooleanExpression)newValue);
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
			case EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY:
				setProperty((NameExpression)null);
				return;
			case EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED:
				setExtended((BooleanExpression)null);
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
			case EolPackage.PROPERTY_CALL_EXPRESSION__PROPERTY:
				return property != null;
			case EolPackage.PROPERTY_CALL_EXPRESSION__EXTENDED:
				return extended != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyCallExpressionImpl
