/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.metamodel.CollectionExpression;
import org.eclipse.epsilon.eol.metamodel.CollectionInitValue;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.LiteralExpression;
import org.eclipse.epsilon.eol.metamodel.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.CollectionExpressionImpl#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.CollectionExpressionImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.CollectionExpressionImpl#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CollectionExpressionImpl extends LiteralExpressionImpl implements CollectionExpression {
	/**
	 * The cached value of the '{@link #getParameterList() <em>Parameter List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterList()
	 * @generated
	 * @ordered
	 */
	protected CollectionInitValue parameterList;

	/**
	 * The cached value of the '{@link #getContentType() <em>Content Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected Type contentType;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<LiteralExpression> contents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.COLLECTION_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionInitValue getParameterList() {
		return parameterList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterList(CollectionInitValue newParameterList, NotificationChain msgs) {
		CollectionInitValue oldParameterList = parameterList;
		parameterList = newParameterList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST, oldParameterList, newParameterList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterList(CollectionInitValue newParameterList) {
		if (newParameterList != parameterList) {
			NotificationChain msgs = null;
			if (parameterList != null)
				msgs = ((InternalEObject)parameterList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST, null, msgs);
			if (newParameterList != null)
				msgs = ((InternalEObject)newParameterList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST, null, msgs);
			msgs = basicSetParameterList(newParameterList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST, newParameterList, newParameterList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getContentType() {
		return contentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContentType(Type newContentType, NotificationChain msgs) {
		Type oldContentType = contentType;
		contentType = newContentType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE, oldContentType, newContentType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentType(Type newContentType) {
		if (newContentType != contentType) {
			NotificationChain msgs = null;
			if (contentType != null)
				msgs = ((InternalEObject)contentType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE, null, msgs);
			if (newContentType != null)
				msgs = ((InternalEObject)newContentType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE, null, msgs);
			msgs = basicSetContentType(newContentType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE, newContentType, newContentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LiteralExpression> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<LiteralExpression>(LiteralExpression.class, this, EolPackage.COLLECTION_EXPRESSION__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST:
				return basicSetParameterList(null, msgs);
			case EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE:
				return basicSetContentType(null, msgs);
			case EolPackage.COLLECTION_EXPRESSION__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
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
			case EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST:
				return getParameterList();
			case EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE:
				return getContentType();
			case EolPackage.COLLECTION_EXPRESSION__CONTENTS:
				return getContents();
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
			case EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST:
				setParameterList((CollectionInitValue)newValue);
				return;
			case EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE:
				setContentType((Type)newValue);
				return;
			case EolPackage.COLLECTION_EXPRESSION__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends LiteralExpression>)newValue);
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
			case EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST:
				setParameterList((CollectionInitValue)null);
				return;
			case EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE:
				setContentType((Type)null);
				return;
			case EolPackage.COLLECTION_EXPRESSION__CONTENTS:
				getContents().clear();
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
			case EolPackage.COLLECTION_EXPRESSION__PARAMETER_LIST:
				return parameterList != null;
			case EolPackage.COLLECTION_EXPRESSION__CONTENT_TYPE:
				return contentType != null;
			case EolPackage.COLLECTION_EXPRESSION__CONTENTS:
				return contents != null && !contents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CollectionExpressionImpl
