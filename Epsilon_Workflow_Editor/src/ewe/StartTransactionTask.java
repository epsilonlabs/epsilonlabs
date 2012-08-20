/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Transaction Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.StartTransactionTask#getModels <em>Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getStartTransactionTask()
 * @model annotation="gmf.node tool.name='Start Transaction Task'"
 * @generated
 */
public interface StartTransactionTask extends EpsilonTask
{
  /**
   * Returns the value of the '<em><b>Models</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' attribute list.
   * @see ewe.EwePackage#getStartTransactionTask_Models()
   * @model
   * @generated
   */
  EList<String> getModels();

} // StartTransactionTask
