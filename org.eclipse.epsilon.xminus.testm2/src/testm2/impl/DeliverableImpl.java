/**
 */
package testm2.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import testm2.Deliverable;
import testm2.Partner;
import testm2.Testm2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deliverable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link testm2.impl.DeliverableImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link testm2.impl.DeliverableImpl#getDue <em>Due</em>}</li>
 *   <li>{@link testm2.impl.DeliverableImpl#getNature <em>Nature</em>}</li>
 *   <li>{@link testm2.impl.DeliverableImpl#getDissemination <em>Dissemination</em>}</li>
 *   <li>{@link testm2.impl.DeliverableImpl#getPartner <em>Partner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeliverableImpl extends EObjectImpl implements Deliverable {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDue() <em>Due</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDue()
	 * @generated
	 * @ordered
	 */
	protected static final int DUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDue() <em>Due</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDue()
	 * @generated
	 * @ordered
	 */
	protected int due = DUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected static final String NATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected String nature = NATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDissemination() <em>Dissemination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDissemination()
	 * @generated
	 * @ordered
	 */
	protected static final String DISSEMINATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDissemination() <em>Dissemination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDissemination()
	 * @generated
	 * @ordered
	 */
	protected String dissemination = DISSEMINATION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeliverableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Testm2Package.Literals.DELIVERABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.DELIVERABLE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDue() {
		return due;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDue(int newDue) {
		int oldDue = due;
		due = newDue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.DELIVERABLE__DUE, oldDue, due));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNature(String newNature) {
		String oldNature = nature;
		nature = newNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.DELIVERABLE__NATURE, oldNature, nature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDissemination() {
		return dissemination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDissemination(String newDissemination) {
		String oldDissemination = dissemination;
		dissemination = newDissemination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.DELIVERABLE__DISSEMINATION, oldDissemination, dissemination));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Testm2Package.DELIVERABLE__PARTNER, oldPartner, partner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.DELIVERABLE__PARTNER, oldPartner, partner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Testm2Package.DELIVERABLE__TITLE:
				return getTitle();
			case Testm2Package.DELIVERABLE__DUE:
				return getDue();
			case Testm2Package.DELIVERABLE__NATURE:
				return getNature();
			case Testm2Package.DELIVERABLE__DISSEMINATION:
				return getDissemination();
			case Testm2Package.DELIVERABLE__PARTNER:
				if (resolve) return getPartner();
				return basicGetPartner();
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
			case Testm2Package.DELIVERABLE__TITLE:
				setTitle((String)newValue);
				return;
			case Testm2Package.DELIVERABLE__DUE:
				setDue((Integer)newValue);
				return;
			case Testm2Package.DELIVERABLE__NATURE:
				setNature((String)newValue);
				return;
			case Testm2Package.DELIVERABLE__DISSEMINATION:
				setDissemination((String)newValue);
				return;
			case Testm2Package.DELIVERABLE__PARTNER:
				setPartner((Partner)newValue);
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
			case Testm2Package.DELIVERABLE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case Testm2Package.DELIVERABLE__DUE:
				setDue(DUE_EDEFAULT);
				return;
			case Testm2Package.DELIVERABLE__NATURE:
				setNature(NATURE_EDEFAULT);
				return;
			case Testm2Package.DELIVERABLE__DISSEMINATION:
				setDissemination(DISSEMINATION_EDEFAULT);
				return;
			case Testm2Package.DELIVERABLE__PARTNER:
				setPartner((Partner)null);
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
			case Testm2Package.DELIVERABLE__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case Testm2Package.DELIVERABLE__DUE:
				return due != DUE_EDEFAULT;
			case Testm2Package.DELIVERABLE__NATURE:
				return NATURE_EDEFAULT == null ? nature != null : !NATURE_EDEFAULT.equals(nature);
			case Testm2Package.DELIVERABLE__DISSEMINATION:
				return DISSEMINATION_EDEFAULT == null ? dissemination != null : !DISSEMINATION_EDEFAULT.equals(dissemination);
			case Testm2Package.DELIVERABLE__PARTNER:
				return partner != null;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", due: ");
		result.append(due);
		result.append(", nature: ");
		result.append(nature);
		result.append(", dissemination: ");
		result.append(dissemination);
		result.append(')');
		return result.toString();
	}

} //DeliverableImpl
