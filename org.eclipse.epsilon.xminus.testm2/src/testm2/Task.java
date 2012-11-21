/**
 */
package testm2;

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
 *   <li>{@link testm2.Task#getPartners <em>Partners</em>}</li>
 * </ul>
 * </p>
 *
 * @see testm2.Testm2Package#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject {

	/**
	 * Returns the value of the '<em><b>Partners</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partners</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partners</em>' attribute list.
	 * @see testm2.Testm2Package#getTask_Partners()
	 * @model
	 * @generated
	 */
	EList<String> getPartners();
} // Task
