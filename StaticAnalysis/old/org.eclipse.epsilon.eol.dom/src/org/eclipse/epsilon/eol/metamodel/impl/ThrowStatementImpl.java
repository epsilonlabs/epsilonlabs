/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ThrowStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throw Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ThrowStatementImpl#getThrown <em>Thrown</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThrowStatementImpl extends StatementImpl implements ThrowStatement {
	/**
	 * The cached value of the '{@link #getThrown() <em>Thrown</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrown()
	 * @generated
	 * @ordered
	 */
	protected Expression thrown;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrowStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.THROW_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getThrown() {
		return thrown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThrown(Expression newThrown, NotificationChain msgs) {
		Expression oldThrown = thrown;
		thrown = newThrown;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.THROW_STATEMENT__THROWN, oldThrown, newThrown);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrown(Expression newThrown) {
		if (newThrown != thrown) {
			NotificationChain msgs = null;
			if (thrown != null)
				msgs = ((InternalEObject)thrown).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.THROW_STATEMENT__THROWN, null, msgs);
			if (newThrown != null)
				msgs = ((InternalEObject)newThrown).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.THROW_STATEMENT__THROWN, null, msgs);
			msgs = basicSetThrown(newThrown, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.THROW_STATEMENT__THROWN, newThrown, newThrown));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.THROW_STATEMENT__THROWN:
				return basicSetThrown(null, msgs);
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
			case EolPackage.THROW_STATEMENT__THROWN:
				return getThrown();
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
			case EolPackage.THROW_STATEMENT__THROWN:
				setThrown((Expression)newValue);
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
			case EolPackage.THROW_STATEMENT__THROWN:
				setThrown((Expression)null);
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
			case EolPackage.THROW_STATEMENT__THROWN:
				return thrown != null;
		}
		return super.eIsSet(featureID);
	}

} //ThrowStatementImpl
