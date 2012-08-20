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
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.Target#getTargetTasks <em>Target Tasks</em>}</li>
 *   <li>{@link ewe.Target#getName <em>Name</em>}</li>
 *   <li>{@link ewe.Target#getContainingProject <em>Containing Project</em>}</li>
 *   <li>{@link ewe.Target#getDepends <em>Depends</em>}</li>
 *   <li>{@link ewe.Target#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getTarget()
 * @model annotation="gmf.node label='name' border.width='2' border.color='0,0,0'"
 * @generated
 */
public interface Target extends EObject
{
  /**
   * Returns the value of the '<em><b>Target Tasks</b></em>' containment reference list.
   * The list contents are of type {@link ewe.Task}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Tasks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Tasks</em>' containment reference list.
   * @see ewe.EwePackage#getTarget_TargetTasks()
   * @model containment="true" required="true"
   *        annotation="gmf.compartment note='targetTasks'"
   * @generated
   */
  EList<Task> getTargetTasks();

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
   * @see ewe.EwePackage#getTarget_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ewe.Target#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Containing Project</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link ewe.Project#getTargets <em>Targets</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Containing Project</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Containing Project</em>' container reference.
   * @see #setContainingProject(Project)
   * @see ewe.EwePackage#getTarget_ContainingProject()
   * @see ewe.Project#getTargets
   * @model opposite="targets" required="true" transient="false"
   *        annotation="gmf.compartment note='targets'"
   * @generated
   */
  Project getContainingProject();

  /**
   * Sets the value of the '{@link ewe.Target#getContainingProject <em>Containing Project</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Containing Project</em>' container reference.
   * @see #getContainingProject()
   * @generated
   */
  void setContainingProject(Project value);

  /**
   * Returns the value of the '<em><b>Depends</b></em>' reference list.
   * The list contents are of type {@link ewe.Target}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Depends</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Depends</em>' reference list.
   * @see ewe.EwePackage#getTarget_Depends()
   * @model annotation="gmf.link label='depends' target.decoration='filledclosedarrow' style='dash' color='0,0,0' width='3' tool.small.bundle='Epsilon_Workflow_Editor.edit' tool.small.path='icons/full/obj16/Depends.gif'"
   * @generated
   */
  EList<Target> getDepends();

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see ewe.EwePackage#getTarget_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link ewe.Target#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // Target
