/**
 */
package org.eclipse.epsilon.eol.dom;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.AnnotationBlock#getSimpleAnnotations <em>Simple Annotations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.AnnotationBlock#getExecutableAnnotations <em>Executable Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getAnnotationBlock()
 * @model
 * @generated
 */
public interface AnnotationBlock extends DomElement {
	/**
	 * Returns the value of the '<em><b>Simple Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.dom.SimpleAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Annotations</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getAnnotationBlock_SimpleAnnotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleAnnotation> getSimpleAnnotations();

	/**
	 * Returns the value of the '<em><b>Executable Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.dom.ExecutableAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executable Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable Annotations</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getAnnotationBlock_ExecutableAnnotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutableAnnotation> getExecutableAnnotations();

} // AnnotationBlock
