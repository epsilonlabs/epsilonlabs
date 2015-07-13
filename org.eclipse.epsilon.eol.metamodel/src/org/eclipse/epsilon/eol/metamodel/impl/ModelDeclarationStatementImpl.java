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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.IModel;
import org.eclipse.epsilon.eol.metamodel.KeyValueExpression;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelDeclarationStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelDeclarationStatementImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelDeclarationStatementImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelDeclarationStatementImpl#getImodel <em>Imodel</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ModelDeclarationStatementImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelDeclarationStatementImpl extends StatementImpl implements ModelDeclarationStatement {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclarationExpression name;

	/**
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
	protected NameExpression driver;

	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclarationExpression> alias;

	/**
	 * The cached value of the '{@link #getImodel() <em>Imodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImodel()
	 * @generated
	 * @ordered
	 */
	protected IModel imodel;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValueExpression> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelDeclarationStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.MODEL_DECLARATION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationExpression getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(VariableDeclarationExpression newName, NotificationChain msgs) {
		VariableDeclarationExpression oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_DECLARATION_STATEMENT__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(VariableDeclarationExpression newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_DECLARATION_STATEMENT__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_DECLARATION_STATEMENT__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_DECLARATION_STATEMENT__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getDriver() {
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDriver(NameExpression newDriver, NotificationChain msgs) {
		NameExpression oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER, oldDriver, newDriver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriver(NameExpression newDriver) {
		if (newDriver != driver) {
			NotificationChain msgs = null;
			if (driver != null)
				msgs = ((InternalEObject)driver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER, null, msgs);
			if (newDriver != null)
				msgs = ((InternalEObject)newDriver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER, null, msgs);
			msgs = basicSetDriver(newDriver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER, newDriver, newDriver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclarationExpression> getAlias() {
		if (alias == null) {
			alias = new EObjectContainmentEList<VariableDeclarationExpression>(VariableDeclarationExpression.class, this, EolPackage.MODEL_DECLARATION_STATEMENT__ALIAS);
		}
		return alias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModel getImodel() {
		return imodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImodel(IModel newImodel, NotificationChain msgs) {
		IModel oldImodel = imodel;
		imodel = newImodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL, oldImodel, newImodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImodel(IModel newImodel) {
		if (newImodel != imodel) {
			NotificationChain msgs = null;
			if (imodel != null)
				msgs = ((InternalEObject)imodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL, null, msgs);
			if (newImodel != null)
				msgs = ((InternalEObject)newImodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL, null, msgs);
			msgs = basicSetImodel(newImodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL, newImodel, newImodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValueExpression> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<KeyValueExpression>(KeyValueExpression.class, this, EolPackage.MODEL_DECLARATION_STATEMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.MODEL_DECLARATION_STATEMENT__NAME:
				return basicSetName(null, msgs);
			case EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER:
				return basicSetDriver(null, msgs);
			case EolPackage.MODEL_DECLARATION_STATEMENT__ALIAS:
				return ((InternalEList<?>)getAlias()).basicRemove(otherEnd, msgs);
			case EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL:
				return basicSetImodel(null, msgs);
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
			case EolPackage.MODEL_DECLARATION_STATEMENT__NAME:
				return getName();
			case EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER:
				return getDriver();
			case EolPackage.MODEL_DECLARATION_STATEMENT__ALIAS:
				return getAlias();
			case EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL:
				return getImodel();
			case EolPackage.MODEL_DECLARATION_STATEMENT__PARAMETERS:
				return getParameters();
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
			case EolPackage.MODEL_DECLARATION_STATEMENT__NAME:
				setName((VariableDeclarationExpression)newValue);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER:
				setDriver((NameExpression)newValue);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__ALIAS:
				getAlias().clear();
				getAlias().addAll((Collection<? extends VariableDeclarationExpression>)newValue);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL:
				setImodel((IModel)newValue);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends KeyValueExpression>)newValue);
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
			case EolPackage.MODEL_DECLARATION_STATEMENT__NAME:
				setName((VariableDeclarationExpression)null);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER:
				setDriver((NameExpression)null);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__ALIAS:
				getAlias().clear();
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL:
				setImodel((IModel)null);
				return;
			case EolPackage.MODEL_DECLARATION_STATEMENT__PARAMETERS:
				getParameters().clear();
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
			case EolPackage.MODEL_DECLARATION_STATEMENT__NAME:
				return name != null;
			case EolPackage.MODEL_DECLARATION_STATEMENT__DRIVER:
				return driver != null;
			case EolPackage.MODEL_DECLARATION_STATEMENT__ALIAS:
				return alias != null && !alias.isEmpty();
			case EolPackage.MODEL_DECLARATION_STATEMENT__IMODEL:
				return imodel != null;
			case EolPackage.MODEL_DECLARATION_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelDeclarationStatementImpl
