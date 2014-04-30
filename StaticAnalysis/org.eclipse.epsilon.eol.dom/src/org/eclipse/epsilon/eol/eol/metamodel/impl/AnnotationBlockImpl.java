/**
 */
package org.eclipse.epsilon.eol.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.eol.metamodel.ExecutableAnnotation;
import org.eclipse.epsilon.eol.eol.metamodel.SimpleAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.AnnotationBlockImpl#getSimpleAnnotations <em>Simple Annotations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.AnnotationBlockImpl#getExecutableAnnotations <em>Executable Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationBlockImpl extends EolElementImpl implements AnnotationBlock {
	/**
	 * The cached value of the '{@link #getSimpleAnnotations() <em>Simple Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleAnnotation> simpleAnnotations;

	/**
	 * The cached value of the '{@link #getExecutableAnnotations() <em>Executable Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutableAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutableAnnotation> executableAnnotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.ANNOTATION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleAnnotation> getSimpleAnnotations() {
		if (simpleAnnotations == null) {
			simpleAnnotations = new EObjectContainmentEList<SimpleAnnotation>(SimpleAnnotation.class, this, EolPackage.ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS);
		}
		return simpleAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutableAnnotation> getExecutableAnnotations() {
		if (executableAnnotations == null) {
			executableAnnotations = new EObjectContainmentEList<ExecutableAnnotation>(ExecutableAnnotation.class, this, EolPackage.ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS);
		}
		return executableAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS:
				return ((InternalEList<?>)getSimpleAnnotations()).basicRemove(otherEnd, msgs);
			case EolPackage.ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS:
				return ((InternalEList<?>)getExecutableAnnotations()).basicRemove(otherEnd, msgs);
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
			case EolPackage.ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS:
				return getSimpleAnnotations();
			case EolPackage.ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS:
				return getExecutableAnnotations();
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
			case EolPackage.ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS:
				getSimpleAnnotations().clear();
				getSimpleAnnotations().addAll((Collection<? extends SimpleAnnotation>)newValue);
				return;
			case EolPackage.ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS:
				getExecutableAnnotations().clear();
				getExecutableAnnotations().addAll((Collection<? extends ExecutableAnnotation>)newValue);
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
			case EolPackage.ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS:
				getSimpleAnnotations().clear();
				return;
			case EolPackage.ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS:
				getExecutableAnnotations().clear();
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
			case EolPackage.ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS:
				return simpleAnnotations != null && !simpleAnnotations.isEmpty();
			case EolPackage.ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS:
				return executableAnnotations != null && !executableAnnotations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationBlockImpl
