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

import org.eclipse.epsilon.eol.eol.BooleanExpression;
import org.eclipse.epsilon.eol.eol.EolPackage;
import org.eclipse.epsilon.eol.eol.Expression;
import org.eclipse.epsilon.eol.eol.NameExpression;
import org.eclipse.epsilon.eol.eol.VariableDeclarationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl#getCreate <em>Create</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.VariableDeclarationExpressionImpl#getLastDefinitionPoint <em>Last Definition Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationExpressionImpl extends ExpressionImpl implements VariableDeclarationExpression {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected NameExpression name;

	/**
	 * The cached value of the '{@link #getCreate() <em>Create</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreate()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression create;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> parameters;

	/**
	 * The default value of the '{@link #getLastDefinitionPoint() <em>Last Definition Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastDefinitionPoint()
	 * @generated
	 * @ordered
	 */
	protected static final Object LAST_DEFINITION_POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastDefinitionPoint() <em>Last Definition Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastDefinitionPoint()
	 * @generated
	 * @ordered
	 */
	protected Object lastDefinitionPoint = LAST_DEFINITION_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.VARIABLE_DECLARATION_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(NameExpression newName, NotificationChain msgs) {
		NameExpression oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(NameExpression newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getCreate() {
		return create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreate(BooleanExpression newCreate, NotificationChain msgs) {
		BooleanExpression oldCreate = create;
		create = newCreate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE, oldCreate, newCreate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreate(BooleanExpression newCreate) {
		if (newCreate != create) {
			NotificationChain msgs = null;
			if (create != null)
				msgs = ((InternalEObject)create).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE, null, msgs);
			if (newCreate != null)
				msgs = ((InternalEObject)newCreate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE, null, msgs);
			msgs = basicSetCreate(newCreate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE, newCreate, newCreate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Expression>(Expression.class, this, EolPackage.VARIABLE_DECLARATION_EXPRESSION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLastDefinitionPoint() {
		return lastDefinitionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastDefinitionPoint(Object newLastDefinitionPoint) {
		Object oldLastDefinitionPoint = lastDefinitionPoint;
		lastDefinitionPoint = newLastDefinitionPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT, oldLastDefinitionPoint, lastDefinitionPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME:
				return basicSetName(null, msgs);
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE:
				return basicSetCreate(null, msgs);
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME:
				return getName();
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE:
				return getCreate();
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__PARAMETERS:
				return getParameters();
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT:
				return getLastDefinitionPoint();
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
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME:
				setName((NameExpression)newValue);
				return;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE:
				setCreate((BooleanExpression)newValue);
				return;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Expression>)newValue);
				return;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT:
				setLastDefinitionPoint(newValue);
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
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME:
				setName((NameExpression)null);
				return;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE:
				setCreate((BooleanExpression)null);
				return;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__PARAMETERS:
				getParameters().clear();
				return;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT:
				setLastDefinitionPoint(LAST_DEFINITION_POINT_EDEFAULT);
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
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__NAME:
				return name != null;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__CREATE:
				return create != null;
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT:
				return LAST_DEFINITION_POINT_EDEFAULT == null ? lastDefinitionPoint != null : !LAST_DEFINITION_POINT_EDEFAULT.equals(lastDefinitionPoint);
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
		result.append(" (lastDefinitionPoint: ");
		result.append(lastDefinitionPoint);
		result.append(')');
		return result.toString();
	}

} //VariableDeclarationExpressionImpl
