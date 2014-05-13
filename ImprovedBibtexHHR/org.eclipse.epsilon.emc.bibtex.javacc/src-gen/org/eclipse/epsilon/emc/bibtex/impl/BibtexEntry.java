/**
 */
package org.eclipse.epsilon.emc.bibtex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.emc.bibtex.Bibliography;
import org.eclipse.epsilon.emc.bibtex.BibtexPackage;
import org.eclipse.epsilon.emc.bibtex.Entry;
import org.eclipse.epsilon.emc.bibtex.Tag;

import org.eclipse.epsilon.emc.bibtex.parser.javacc.BibtexNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexEntry#getBibliography <em>Bibliography</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexEntry#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BibtexEntry extends BibtexNode implements Entry {
	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexEntry() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bibliography getBibliography() {
		if (eContainerFeatureID() != BibtexPackage.ENTRY__BIBLIOGRAPHY) return null;
		return (Bibliography)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBibliography(Bibliography newBibliography, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBibliography, BibtexPackage.ENTRY__BIBLIOGRAPHY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBibliography(Bibliography newBibliography) {
		if (newBibliography != eInternalContainer() || (eContainerFeatureID() != BibtexPackage.ENTRY__BIBLIOGRAPHY && newBibliography != null)) {
			if (EcoreUtil.isAncestor(this, newBibliography))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBibliography != null)
				msgs = ((InternalEObject)newBibliography).eInverseAdd(this, BibtexPackage.BIBLIOGRAPHY__ENTRIES, Bibliography.class, msgs);
			msgs = basicSetBibliography(newBibliography, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ENTRY__BIBLIOGRAPHY, newBibliography, newBibliography));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentWithInverseEList<Tag>(Tag.class, this, BibtexPackage.ENTRY__TAGS, BibtexPackage.TAG__OWNER);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBibliography((Bibliography)otherEnd, msgs);
			case BibtexPackage.ENTRY__TAGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTags()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				return basicSetBibliography(null, msgs);
			case BibtexPackage.ENTRY__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				return eInternalContainer().eInverseRemove(this, BibtexPackage.BIBLIOGRAPHY__ENTRIES, Bibliography.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				return getBibliography();
			case BibtexPackage.ENTRY__TAGS:
				return getTags();
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
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				setBibliography((Bibliography)newValue);
				return;
			case BibtexPackage.ENTRY__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends Tag>)newValue);
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
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				setBibliography((Bibliography)null);
				return;
			case BibtexPackage.ENTRY__TAGS:
				getTags().clear();
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
			case BibtexPackage.ENTRY__BIBLIOGRAPHY:
				return getBibliography() != null;
			case BibtexPackage.ENTRY__TAGS:
				return tags != null && !tags.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BibtexEntry
