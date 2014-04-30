/**
 */
package org.eclipse.epsilon.eol.eol;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.ExprList#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getExprList()
 * @model
 * @generated
 */
public interface ExprList extends CollectionInitValue {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.eol.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getExprList_Expressions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // ExprList
