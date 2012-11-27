/**
 */
package rss;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rss</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rss.Rss#getChannels <em>Channels</em>}</li>
 * </ul>
 * </p>
 *
 * @see rss.RssPackage#getRss()
 * @model
 * @generated
 */
public interface Rss extends EObject {
	/**
	 * Returns the value of the '<em><b>Channels</b></em>' containment reference list.
	 * The list contents are of type {@link rss.Channel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' containment reference list.
	 * @see rss.RssPackage#getRss_Channels()
	 * @model containment="true"
	 * @generated
	 */
	EList<Channel> getChannels();

} // Rss
