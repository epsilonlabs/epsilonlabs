/**
 */
package org.eclipse.epsilon.eol.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.eol.metamodel.Block;
import org.eclipse.epsilon.eol.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.eol.metamodel.FormalParameterExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ForStatementImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ForStatementImpl#getIterated <em>Iterated</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ForStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected FormalParameterExpression iterator;

	/**
	 * The cached value of the '{@link #getIterated() <em>Iterated</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterated()
	 * @generated
	 * @ordered
	 */
	protected Expression iterated;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Block body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameterExpression getIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterator(FormalParameterExpression newIterator, NotificationChain msgs) {
		FormalParameterExpression oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.FOR_STATEMENT__ITERATOR, oldIterator, newIterator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(FormalParameterExpression newIterator) {
		if (newIterator != iterator) {
			NotificationChain msgs = null;
			if (iterator != null)
				msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.FOR_STATEMENT__ITERATOR, null, msgs);
			if (newIterator != null)
				msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.FOR_STATEMENT__ITERATOR, null, msgs);
			msgs = basicSetIterator(newIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.FOR_STATEMENT__ITERATOR, newIterator, newIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIterated() {
		return iterated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterated(Expression newIterated, NotificationChain msgs) {
		Expression oldIterated = iterated;
		iterated = newIterated;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.FOR_STATEMENT__ITERATED, oldIterated, newIterated);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterated(Expression newIterated) {
		if (newIterated != iterated) {
			NotificationChain msgs = null;
			if (iterated != null)
				msgs = ((InternalEObject)iterated).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.FOR_STATEMENT__ITERATED, null, msgs);
			if (newIterated != null)
				msgs = ((InternalEObject)newIterated).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.FOR_STATEMENT__ITERATED, null, msgs);
			msgs = basicSetIterated(newIterated, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.FOR_STATEMENT__ITERATED, newIterated, newIterated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Block newBody, NotificationChain msgs) {
		Block oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.FOR_STATEMENT__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Block newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.FOR_STATEMENT__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.FOR_STATEMENT__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.FOR_STATEMENT__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.FOR_STATEMENT__ITERATOR:
				return basicSetIterator(null, msgs);
			case EolPackage.FOR_STATEMENT__ITERATED:
				return basicSetIterated(null, msgs);
			case EolPackage.FOR_STATEMENT__BODY:
				return basicSetBody(null, msgs);
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
			case EolPackage.FOR_STATEMENT__ITERATOR:
				return getIterator();
			case EolPackage.FOR_STATEMENT__ITERATED:
				return getIterated();
			case EolPackage.FOR_STATEMENT__BODY:
				return getBody();
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
			case EolPackage.FOR_STATEMENT__ITERATOR:
				setIterator((FormalParameterExpression)newValue);
				return;
			case EolPackage.FOR_STATEMENT__ITERATED:
				setIterated((Expression)newValue);
				return;
			case EolPackage.FOR_STATEMENT__BODY:
				setBody((Block)newValue);
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
			case EolPackage.FOR_STATEMENT__ITERATOR:
				setIterator((FormalParameterExpression)null);
				return;
			case EolPackage.FOR_STATEMENT__ITERATED:
				setIterated((Expression)null);
				return;
			case EolPackage.FOR_STATEMENT__BODY:
				setBody((Block)null);
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
			case EolPackage.FOR_STATEMENT__ITERATOR:
				return iterator != null;
			case EolPackage.FOR_STATEMENT__ITERATED:
				return iterated != null;
			case EolPackage.FOR_STATEMENT__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
