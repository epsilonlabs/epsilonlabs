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
import org.eclipse.epsilon.eol.metamodel.IPackage;
import org.eclipse.epsilon.eol.metamodel.NameExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.IModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.IModelImpl#getAliases <em>Aliases</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.IModelImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.IModelImpl#getIMetamodelDriver <em>IMetamodel Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.IModelImpl#getIPackages <em>IPackages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IModelImpl extends EOLElementImpl implements IModel {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected NameExpression name;

	/**
	 * The cached value of the '{@link #getAliases() <em>Aliases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliases()
	 * @generated
	 * @ordered
	 */
	protected EList<NameExpression> aliases;

	/**
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
	protected NameExpression driver;

	/**
	 * The default value of the '{@link #getIMetamodelDriver() <em>IMetamodel Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIMetamodelDriver()
	 * @generated
	 * @ordered
	 */
	protected static final Object IMETAMODEL_DRIVER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIMetamodelDriver() <em>IMetamodel Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIMetamodelDriver()
	 * @generated
	 * @ordered
	 */
	protected Object iMetamodelDriver = IMETAMODEL_DRIVER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIPackages() <em>IPackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<IPackage> iPackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.IMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getName() {
		if (name != null && name.eIsProxy()) {
			InternalEObject oldName = (InternalEObject)name;
			name = (NameExpression)eResolveProxy(oldName);
			if (name != oldName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.IMODEL__NAME, oldName, name));
			}
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression basicGetName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(NameExpression newName) {
		NameExpression oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.IMODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NameExpression> getAliases() {
		if (aliases == null) {
			aliases = new EObjectResolvingEList<NameExpression>(NameExpression.class, this, EolPackage.IMODEL__ALIASES);
		}
		return aliases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getDriver() {
		if (driver != null && driver.eIsProxy()) {
			InternalEObject oldDriver = (InternalEObject)driver;
			driver = (NameExpression)eResolveProxy(oldDriver);
			if (driver != oldDriver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.IMODEL__DRIVER, oldDriver, driver));
			}
		}
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression basicGetDriver() {
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriver(NameExpression newDriver) {
		NameExpression oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.IMODEL__DRIVER, oldDriver, driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIMetamodelDriver() {
		return iMetamodelDriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIMetamodelDriver(Object newIMetamodelDriver) {
		Object oldIMetamodelDriver = iMetamodelDriver;
		iMetamodelDriver = newIMetamodelDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.IMODEL__IMETAMODEL_DRIVER, oldIMetamodelDriver, iMetamodelDriver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IPackage> getIPackages() {
		if (iPackages == null) {
			iPackages = new EObjectContainmentEList<IPackage>(IPackage.class, this, EolPackage.IMODEL__IPACKAGES);
		}
		return iPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.IMODEL__IPACKAGES:
				return ((InternalEList<?>)getIPackages()).basicRemove(otherEnd, msgs);
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
			case EolPackage.IMODEL__NAME:
				if (resolve) return getName();
				return basicGetName();
			case EolPackage.IMODEL__ALIASES:
				return getAliases();
			case EolPackage.IMODEL__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case EolPackage.IMODEL__IMETAMODEL_DRIVER:
				return getIMetamodelDriver();
			case EolPackage.IMODEL__IPACKAGES:
				return getIPackages();
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
			case EolPackage.IMODEL__NAME:
				setName((NameExpression)newValue);
				return;
			case EolPackage.IMODEL__ALIASES:
				getAliases().clear();
				getAliases().addAll((Collection<? extends NameExpression>)newValue);
				return;
			case EolPackage.IMODEL__DRIVER:
				setDriver((NameExpression)newValue);
				return;
			case EolPackage.IMODEL__IMETAMODEL_DRIVER:
				setIMetamodelDriver(newValue);
				return;
			case EolPackage.IMODEL__IPACKAGES:
				getIPackages().clear();
				getIPackages().addAll((Collection<? extends IPackage>)newValue);
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
			case EolPackage.IMODEL__NAME:
				setName((NameExpression)null);
				return;
			case EolPackage.IMODEL__ALIASES:
				getAliases().clear();
				return;
			case EolPackage.IMODEL__DRIVER:
				setDriver((NameExpression)null);
				return;
			case EolPackage.IMODEL__IMETAMODEL_DRIVER:
				setIMetamodelDriver(IMETAMODEL_DRIVER_EDEFAULT);
				return;
			case EolPackage.IMODEL__IPACKAGES:
				getIPackages().clear();
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
			case EolPackage.IMODEL__NAME:
				return name != null;
			case EolPackage.IMODEL__ALIASES:
				return aliases != null && !aliases.isEmpty();
			case EolPackage.IMODEL__DRIVER:
				return driver != null;
			case EolPackage.IMODEL__IMETAMODEL_DRIVER:
				return IMETAMODEL_DRIVER_EDEFAULT == null ? iMetamodelDriver != null : !IMETAMODEL_DRIVER_EDEFAULT.equals(iMetamodelDriver);
			case EolPackage.IMODEL__IPACKAGES:
				return iPackages != null && !iPackages.isEmpty();
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
		result.append(" (iMetamodelDriver: ");
		result.append(iMetamodelDriver);
		result.append(')');
		return result.toString();
	}

} //IModelImpl
