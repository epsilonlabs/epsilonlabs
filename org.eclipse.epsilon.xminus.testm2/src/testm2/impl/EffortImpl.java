/**
 */
package testm2.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import testm2.Effort;
import testm2.Partner;
import testm2.Testm2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link testm2.impl.EffortImpl#getPartner <em>Partner</em>}</li>
 *   <li>{@link testm2.impl.EffortImpl#getMonths <em>Months</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EffortImpl extends EObjectImpl implements Effort {
	/**
	 * The cached value of the '{@link #getPartner() <em>Partner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartner()
	 * @generated
	 * @ordered
	 */
	protected Partner partner;

	/**
	 * The default value of the '{@link #getMonths() <em>Months</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonths()
	 * @generated
	 * @ordered
	 */
	protected static final float MONTHS_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMonths() <em>Months</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonths()
	 * @generated
	 * @ordered
	 */
	protected float months = MONTHS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EffortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Testm2Package.Literals.EFFORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partner getPartner() {
		if (partner != null && partner.eIsProxy()) {
			InternalEObject oldPartner = (InternalEObject)partner;
			partner = (Partner)eResolveProxy(oldPartner);
			if (partner != oldPartner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Testm2Package.EFFORT__PARTNER, oldPartner, partner));
			}
		}
		return partner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partner basicGetPartner() {
		return partner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartner(Partner newPartner) {
		Partner oldPartner = partner;
		partner = newPartner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.EFFORT__PARTNER, oldPartner, partner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMonths() {
		return months;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonths(float newMonths) {
		float oldMonths = months;
		months = newMonths;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.EFFORT__MONTHS, oldMonths, months));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Testm2Package.EFFORT__PARTNER:
				if (resolve) return getPartner();
				return basicGetPartner();
			case Testm2Package.EFFORT__MONTHS:
				return getMonths();
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
			case Testm2Package.EFFORT__PARTNER:
				setPartner((Partner)newValue);
				return;
			case Testm2Package.EFFORT__MONTHS:
				setMonths((Float)newValue);
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
			case Testm2Package.EFFORT__PARTNER:
				setPartner((Partner)null);
				return;
			case Testm2Package.EFFORT__MONTHS:
				setMonths(MONTHS_EDEFAULT);
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
			case Testm2Package.EFFORT__PARTNER:
				return partner != null;
			case Testm2Package.EFFORT__MONTHS:
				return months != MONTHS_EDEFAULT;
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
		result.append(" (months: ");
		result.append(months);
		result.append(')');
		return result.toString();
	}

} //EffortImpl
