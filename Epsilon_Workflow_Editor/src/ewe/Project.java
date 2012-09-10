/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.Project#getName <em>Name</em>}</li>
 *   <li>{@link ewe.Project#getTargets <em>Targets</em>}</li>
 *   <li>{@link ewe.Project#getDefaultTarget <em>Default Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getProject()
 * @model annotation="gmf.diagram note='Root class'"
 * @generated
 */
public interface Project extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ewe.EwePackage#getProject_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ewe.Project#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Targets</b></em>' containment reference list.
   * The list contents are of type {@link ewe.Target}.
   * It is bidirectional and its opposite is '{@link ewe.Target#getContainingProject <em>Containing Project</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targets</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targets</em>' containment reference list.
   * @see ewe.EwePackage#getProject_Targets()
   * @see ewe.Target#getContainingProject
   * @model opposite="containingProject" containment="true" required="true"
   * @generated
   */
  EList<Target> getTargets();

  /**
   * Returns the value of the '<em><b>Default Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Target</em>' reference.
   * @see #setDefaultTarget(Target)
   * @see ewe.EwePackage#getProject_DefaultTarget()
   * @model required="true"
   * @generated
   */
  Target getDefaultTarget();

  /**
   * Sets the value of the '{@link ewe.Project#getDefaultTarget <em>Default Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Target</em>' reference.
   * @see #getDefaultTarget()
   * @generated
   */
  void setDefaultTarget(Target value);

} // Project
