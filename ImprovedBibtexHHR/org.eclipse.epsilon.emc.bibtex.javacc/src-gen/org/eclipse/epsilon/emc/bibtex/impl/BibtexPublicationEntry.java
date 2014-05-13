/**
 */
package org.eclipse.epsilon.emc.bibtex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.emc.bibtex.BibtexPackage;
import org.eclipse.epsilon.emc.bibtex.PublicationEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Publication Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexPublicationEntry#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexPublicationEntry#getCitationKey <em>Citation Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BibtexPublicationEntry extends BibtexEntry implements PublicationEntry {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCitationKey() <em>Citation Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCitationKey()
	 * @generated
	 * @ordered
	 */
	protected static final String CITATION_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCitationKey() <em>Citation Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCitationKey()
	 * @generated
	 * @ordered
	 */
	protected String citationKey = CITATION_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexPublicationEntry() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.PUBLICATION_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.PUBLICATION_ENTRY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCitationKey() {
		return citationKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCitationKey(String newCitationKey) {
		String oldCitationKey = citationKey;
		citationKey = newCitationKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.PUBLICATION_ENTRY__CITATION_KEY, oldCitationKey, citationKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.PUBLICATION_ENTRY__TYPE:
				return getType();
			case BibtexPackage.PUBLICATION_ENTRY__CITATION_KEY:
				return getCitationKey();
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
			case BibtexPackage.PUBLICATION_ENTRY__TYPE:
				setType((String)newValue);
				return;
			case BibtexPackage.PUBLICATION_ENTRY__CITATION_KEY:
				setCitationKey((String)newValue);
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
			case BibtexPackage.PUBLICATION_ENTRY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case BibtexPackage.PUBLICATION_ENTRY__CITATION_KEY:
				setCitationKey(CITATION_KEY_EDEFAULT);
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
			case BibtexPackage.PUBLICATION_ENTRY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case BibtexPackage.PUBLICATION_ENTRY__CITATION_KEY:
				return CITATION_KEY_EDEFAULT == null ? citationKey != null : !CITATION_KEY_EDEFAULT.equals(citationKey);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", citationKey: ");
		result.append(citationKey);
		result.append(')');
		return result.toString();
	}

} //BibtexPublicationEntry
