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
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.Task#getName <em>Name</em>}</li>
 *   <li>{@link ewe.Task#getFollows <em>Follows</em>}</li>
 *   <li>{@link ewe.Task#getFollower <em>Follower</em>}</li>
 *   <li>{@link ewe.Task#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link ewe.Task#getTaskelements <em>Taskelements</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getTask()
 * @model annotation="gmf.node label='name' border.width='2' border.color='0,0,0' color='249,249,213'"
 * @generated
 */
public interface Task extends EObject
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
   * @see ewe.EwePackage#getTask_Name()
   * @model extendedMetaData="namespace=''"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ewe.Task#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Follows</b></em>' reference.
   * It is bidirectional and its opposite is '{@link ewe.Task#getFollower <em>Follower</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Follows</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Follows</em>' reference.
   * @see #setFollows(Task)
   * @see ewe.EwePackage#getTask_Follows()
   * @see ewe.Task#getFollower
   * @model opposite="follower"
   *        annotation="gmf.link label='follows' target.decoration='arrow' style='dash' width='2' tool.small.bundle='Epsilon_Workflow_Editor.edit' tool.small.path='icons/full/obj16/Follows.gif'"
   * @generated
   */
  Task getFollows();

  /**
   * Sets the value of the '{@link ewe.Task#getFollows <em>Follows</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Follows</em>' reference.
   * @see #getFollows()
   * @generated
   */
  void setFollows(Task value);

  /**
   * Returns the value of the '<em><b>Follower</b></em>' reference.
   * It is bidirectional and its opposite is '{@link ewe.Task#getFollows <em>Follows</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Follower</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Follower</em>' reference.
   * @see #setFollower(Task)
   * @see ewe.EwePackage#getTask_Follower()
   * @see ewe.Task#getFollows
   * @model opposite="follows"
   * @generated
   */
  Task getFollower();

  /**
   * Sets the value of the '{@link ewe.Task#getFollower <em>Follower</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Follower</em>' reference.
   * @see #getFollower()
   * @generated
   */
  void setFollower(Task value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link ewe.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see ewe.EwePackage#getTask_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Taskelements</b></em>' containment reference list.
   * The list contents are of type {@link ewe.NestedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Taskelements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Taskelements</em>' containment reference list.
   * @see ewe.EwePackage#getTask_Taskelements()
   * @model containment="true"
   * @generated
   */
  EList<NestedElement> getTaskelements();

} // Task
