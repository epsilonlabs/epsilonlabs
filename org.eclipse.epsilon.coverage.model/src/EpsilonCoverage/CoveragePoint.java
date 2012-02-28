/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coverage Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EpsilonCoverage.CoveragePoint#getLine <em>Line</em>}</li>
 *   <li>{@link EpsilonCoverage.CoveragePoint#getColumn <em>Column</em>}</li>
 *   <li>{@link EpsilonCoverage.CoveragePoint#getAstType <em>Ast Type</em>}</li>
 *   <li>{@link EpsilonCoverage.CoveragePoint#getTimesExecuted <em>Times Executed</em>}</li>
 *   <li>{@link EpsilonCoverage.CoveragePoint#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoveragePoint()
 * @model
 * @generated
 */
public interface CoveragePoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoveragePoint_Line()
	 * @model
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.CoveragePoint#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(int)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoveragePoint_Column()
	 * @model
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.CoveragePoint#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

	/**
	 * Returns the value of the '<em><b>Ast Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast Type</em>' attribute.
	 * @see #setAstType(int)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoveragePoint_AstType()
	 * @model
	 * @generated
	 */
	int getAstType();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.CoveragePoint#getAstType <em>Ast Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast Type</em>' attribute.
	 * @see #getAstType()
	 * @generated
	 */
	void setAstType(int value);

	/**
	 * Returns the value of the '<em><b>Times Executed</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Times Executed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Times Executed</em>' attribute.
	 * @see #setTimesExecuted(int)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoveragePoint_TimesExecuted()
	 * @model default="0"
	 * @generated
	 */
	int getTimesExecuted();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.CoveragePoint#getTimesExecuted <em>Times Executed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Times Executed</em>' attribute.
	 * @see #getTimesExecuted()
	 * @generated
	 */
	void setTimesExecuted(int value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoveragePoint_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.CoveragePoint#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // CoveragePoint
