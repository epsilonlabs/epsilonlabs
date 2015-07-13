/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.TextRegion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EOL Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EOLElementImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EOLElementImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EOLElementImpl#getTextRegion <em>Text Region</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EOLElementImpl#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EOLElementImpl extends EObjectImpl implements EOLElement {
	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected EOLElement container;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTextRegion() <em>Text Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextRegion()
	 * @generated
	 * @ordered
	 */
	protected TextRegion textRegion;

	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected TextRegion region;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EOLElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.EOL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOLElement getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (EOLElement)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.EOL_ELEMENT__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOLElement basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(EOLElement newContainer) {
		EOLElement oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_ELEMENT__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_ELEMENT__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextRegion getTextRegion() {
		if (textRegion != null && textRegion.eIsProxy()) {
			InternalEObject oldTextRegion = (InternalEObject)textRegion;
			textRegion = (TextRegion)eResolveProxy(oldTextRegion);
			if (textRegion != oldTextRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.EOL_ELEMENT__TEXT_REGION, oldTextRegion, textRegion));
			}
		}
		return textRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextRegion basicGetTextRegion() {
		return textRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextRegion(TextRegion newTextRegion) {
		TextRegion oldTextRegion = textRegion;
		textRegion = newTextRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_ELEMENT__TEXT_REGION, oldTextRegion, textRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextRegion getRegion() {
		if (region != null && region.eIsProxy()) {
			InternalEObject oldRegion = (InternalEObject)region;
			region = (TextRegion)eResolveProxy(oldRegion);
			if (region != oldRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.EOL_ELEMENT__REGION, oldRegion, region));
			}
		}
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextRegion basicGetRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(TextRegion newRegion) {
		TextRegion oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_ELEMENT__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EolPackage.EOL_ELEMENT__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case EolPackage.EOL_ELEMENT__URI:
				return getUri();
			case EolPackage.EOL_ELEMENT__TEXT_REGION:
				if (resolve) return getTextRegion();
				return basicGetTextRegion();
			case EolPackage.EOL_ELEMENT__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
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
			case EolPackage.EOL_ELEMENT__CONTAINER:
				setContainer((EOLElement)newValue);
				return;
			case EolPackage.EOL_ELEMENT__URI:
				setUri((String)newValue);
				return;
			case EolPackage.EOL_ELEMENT__TEXT_REGION:
				setTextRegion((TextRegion)newValue);
				return;
			case EolPackage.EOL_ELEMENT__REGION:
				setRegion((TextRegion)newValue);
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
			case EolPackage.EOL_ELEMENT__CONTAINER:
				setContainer((EOLElement)null);
				return;
			case EolPackage.EOL_ELEMENT__URI:
				setUri(URI_EDEFAULT);
				return;
			case EolPackage.EOL_ELEMENT__TEXT_REGION:
				setTextRegion((TextRegion)null);
				return;
			case EolPackage.EOL_ELEMENT__REGION:
				setRegion((TextRegion)null);
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
			case EolPackage.EOL_ELEMENT__CONTAINER:
				return container != null;
			case EolPackage.EOL_ELEMENT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case EolPackage.EOL_ELEMENT__TEXT_REGION:
				return textRegion != null;
			case EolPackage.EOL_ELEMENT__REGION:
				return region != null;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //EOLElementImpl
