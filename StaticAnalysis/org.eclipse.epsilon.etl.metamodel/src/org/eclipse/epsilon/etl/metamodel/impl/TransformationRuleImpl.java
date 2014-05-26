/**
 */
package org.eclipse.epsilon.etl.metamodel.impl;

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

import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;

import org.eclipse.epsilon.etl.metamodel.EtlPackage;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getAnnotationBlock <em>Annotation Block</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getResolvedParentRules <em>Resolved Parent Rules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl#getGuard <em>Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationRuleImpl extends EtlElementImpl implements TransformationRule {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected NameExpression name;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected FormalParameterExpression source;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<FormalParameterExpression> targets;

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
	 * The cached value of the '{@link #getAnnotationBlock() <em>Annotation Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationBlock()
	 * @generated
	 * @ordered
	 */
	protected AnnotationBlock annotationBlock;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<NameExpression> extends_;

	/**
	 * The cached value of the '{@link #getResolvedParentRules() <em>Resolved Parent Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedParentRules()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationRule> resolvedParentRules;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Guard guard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtlPackage.Literals.TRANSFORMATION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(NameExpression newName, NotificationChain msgs) {
		NameExpression oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(NameExpression newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameterExpression getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(FormalParameterExpression newSource, NotificationChain msgs) {
		FormalParameterExpression oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(FormalParameterExpression newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FormalParameterExpression> getTargets() {
		if (targets == null) {
			targets = new EObjectContainmentEList<FormalParameterExpression>(FormalParameterExpression.class, this, EtlPackage.TRANSFORMATION_RULE__TARGETS);
		}
		return targets;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__BODY, oldBody, newBody);
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
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationBlock getAnnotationBlock() {
		return annotationBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotationBlock(AnnotationBlock newAnnotationBlock, NotificationChain msgs) {
		AnnotationBlock oldAnnotationBlock = annotationBlock;
		annotationBlock = newAnnotationBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK, oldAnnotationBlock, newAnnotationBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotationBlock(AnnotationBlock newAnnotationBlock) {
		if (newAnnotationBlock != annotationBlock) {
			NotificationChain msgs = null;
			if (annotationBlock != null)
				msgs = ((InternalEObject)annotationBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK, null, msgs);
			if (newAnnotationBlock != null)
				msgs = ((InternalEObject)newAnnotationBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK, null, msgs);
			msgs = basicSetAnnotationBlock(newAnnotationBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK, newAnnotationBlock, newAnnotationBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NameExpression> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectContainmentEList<NameExpression>(NameExpression.class, this, EtlPackage.TRANSFORMATION_RULE__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransformationRule> getResolvedParentRules() {
		if (resolvedParentRules == null) {
			resolvedParentRules = new EObjectResolvingEList<TransformationRule>(TransformationRule.class, this, EtlPackage.TRANSFORMATION_RULE__RESOLVED_PARENT_RULES);
		}
		return resolvedParentRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(Guard newGuard, NotificationChain msgs) {
		Guard oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(Guard newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtlPackage.TRANSFORMATION_RULE__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtlPackage.TRANSFORMATION_RULE__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtlPackage.TRANSFORMATION_RULE__NAME:
				return basicSetName(null, msgs);
			case EtlPackage.TRANSFORMATION_RULE__SOURCE:
				return basicSetSource(null, msgs);
			case EtlPackage.TRANSFORMATION_RULE__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
			case EtlPackage.TRANSFORMATION_RULE__BODY:
				return basicSetBody(null, msgs);
			case EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK:
				return basicSetAnnotationBlock(null, msgs);
			case EtlPackage.TRANSFORMATION_RULE__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case EtlPackage.TRANSFORMATION_RULE__GUARD:
				return basicSetGuard(null, msgs);
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
			case EtlPackage.TRANSFORMATION_RULE__NAME:
				return getName();
			case EtlPackage.TRANSFORMATION_RULE__SOURCE:
				return getSource();
			case EtlPackage.TRANSFORMATION_RULE__TARGETS:
				return getTargets();
			case EtlPackage.TRANSFORMATION_RULE__BODY:
				return getBody();
			case EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK:
				return getAnnotationBlock();
			case EtlPackage.TRANSFORMATION_RULE__EXTENDS:
				return getExtends();
			case EtlPackage.TRANSFORMATION_RULE__RESOLVED_PARENT_RULES:
				return getResolvedParentRules();
			case EtlPackage.TRANSFORMATION_RULE__GUARD:
				return getGuard();
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
			case EtlPackage.TRANSFORMATION_RULE__NAME:
				setName((NameExpression)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__SOURCE:
				setSource((FormalParameterExpression)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends FormalParameterExpression>)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__BODY:
				setBody((Block)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK:
				setAnnotationBlock((AnnotationBlock)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends NameExpression>)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__RESOLVED_PARENT_RULES:
				getResolvedParentRules().clear();
				getResolvedParentRules().addAll((Collection<? extends TransformationRule>)newValue);
				return;
			case EtlPackage.TRANSFORMATION_RULE__GUARD:
				setGuard((Guard)newValue);
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
			case EtlPackage.TRANSFORMATION_RULE__NAME:
				setName((NameExpression)null);
				return;
			case EtlPackage.TRANSFORMATION_RULE__SOURCE:
				setSource((FormalParameterExpression)null);
				return;
			case EtlPackage.TRANSFORMATION_RULE__TARGETS:
				getTargets().clear();
				return;
			case EtlPackage.TRANSFORMATION_RULE__BODY:
				setBody((Block)null);
				return;
			case EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK:
				setAnnotationBlock((AnnotationBlock)null);
				return;
			case EtlPackage.TRANSFORMATION_RULE__EXTENDS:
				getExtends().clear();
				return;
			case EtlPackage.TRANSFORMATION_RULE__RESOLVED_PARENT_RULES:
				getResolvedParentRules().clear();
				return;
			case EtlPackage.TRANSFORMATION_RULE__GUARD:
				setGuard((Guard)null);
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
			case EtlPackage.TRANSFORMATION_RULE__NAME:
				return name != null;
			case EtlPackage.TRANSFORMATION_RULE__SOURCE:
				return source != null;
			case EtlPackage.TRANSFORMATION_RULE__TARGETS:
				return targets != null && !targets.isEmpty();
			case EtlPackage.TRANSFORMATION_RULE__BODY:
				return body != null;
			case EtlPackage.TRANSFORMATION_RULE__ANNOTATION_BLOCK:
				return annotationBlock != null;
			case EtlPackage.TRANSFORMATION_RULE__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case EtlPackage.TRANSFORMATION_RULE__RESOLVED_PARENT_RULES:
				return resolvedParentRules != null && !resolvedParentRules.isEmpty();
			case EtlPackage.TRANSFORMATION_RULE__GUARD:
				return guard != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformationRuleImpl
