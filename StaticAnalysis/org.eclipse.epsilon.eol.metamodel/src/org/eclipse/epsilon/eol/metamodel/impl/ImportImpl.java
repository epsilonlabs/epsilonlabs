/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.StringExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ImportImpl#getImported <em>Imported</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ImportImpl#getImportedProgram <em>Imported Program</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportImpl extends EolElementImpl implements Import {
	/**
	 * The cached value of the '{@link #getImported() <em>Imported</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImported()
	 * @generated
	 * @ordered
	 */
	protected StringExpression imported;

	/**
	 * The cached value of the '{@link #getImportedProgram() <em>Imported Program</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedProgram()
	 * @generated
	 * @ordered
	 */
	protected EolElement importedProgram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringExpression getImported() {
		return imported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImported(StringExpression newImported, NotificationChain msgs) {
		StringExpression oldImported = imported;
		imported = newImported;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.IMPORT__IMPORTED, oldImported, newImported);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImported(StringExpression newImported) {
		if (newImported != imported) {
			NotificationChain msgs = null;
			if (imported != null)
				msgs = ((InternalEObject)imported).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.IMPORT__IMPORTED, null, msgs);
			if (newImported != null)
				msgs = ((InternalEObject)newImported).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.IMPORT__IMPORTED, null, msgs);
			msgs = basicSetImported(newImported, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.IMPORT__IMPORTED, newImported, newImported));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EolElement getImportedProgram() {
		return importedProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImportedProgram(EolElement newImportedProgram, NotificationChain msgs) {
		EolElement oldImportedProgram = importedProgram;
		importedProgram = newImportedProgram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.IMPORT__IMPORTED_PROGRAM, oldImportedProgram, newImportedProgram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportedProgram(EolElement newImportedProgram) {
		if (newImportedProgram != importedProgram) {
			NotificationChain msgs = null;
			if (importedProgram != null)
				msgs = ((InternalEObject)importedProgram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.IMPORT__IMPORTED_PROGRAM, null, msgs);
			if (newImportedProgram != null)
				msgs = ((InternalEObject)newImportedProgram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.IMPORT__IMPORTED_PROGRAM, null, msgs);
			msgs = basicSetImportedProgram(newImportedProgram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.IMPORT__IMPORTED_PROGRAM, newImportedProgram, newImportedProgram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.IMPORT__IMPORTED:
				return basicSetImported(null, msgs);
			case EolPackage.IMPORT__IMPORTED_PROGRAM:
				return basicSetImportedProgram(null, msgs);
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
			case EolPackage.IMPORT__IMPORTED:
				return getImported();
			case EolPackage.IMPORT__IMPORTED_PROGRAM:
				return getImportedProgram();
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
			case EolPackage.IMPORT__IMPORTED:
				setImported((StringExpression)newValue);
				return;
			case EolPackage.IMPORT__IMPORTED_PROGRAM:
				setImportedProgram((EolElement)newValue);
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
			case EolPackage.IMPORT__IMPORTED:
				setImported((StringExpression)null);
				return;
			case EolPackage.IMPORT__IMPORTED_PROGRAM:
				setImportedProgram((EolElement)null);
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
			case EolPackage.IMPORT__IMPORTED:
				return imported != null;
			case EolPackage.IMPORT__IMPORTED_PROGRAM:
				return importedProgram != null;
		}
		return super.eIsSet(featureID);
	}

} //ImportImpl
