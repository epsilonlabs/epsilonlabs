/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage.impl;

import EpsilonCoverage.CoveragePoint;
import EpsilonCoverage.EpsilonCoveragePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coverage Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EpsilonCoverage.impl.CoveragePointImpl#getLine <em>Line</em>}</li>
 *   <li>{@link EpsilonCoverage.impl.CoveragePointImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link EpsilonCoverage.impl.CoveragePointImpl#getAstType <em>Ast Type</em>}</li>
 *   <li>{@link EpsilonCoverage.impl.CoveragePointImpl#getTimesExecuted <em>Times Executed</em>}</li>
 *   <li>{@link EpsilonCoverage.impl.CoveragePointImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoveragePointImpl extends EObjectImpl implements CoveragePoint {
	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected int line = LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected int column = COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAstType() <em>Ast Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAstType()
	 * @generated
	 * @ordered
	 */
	protected static final int AST_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAstType() <em>Ast Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAstType()
	 * @generated
	 * @ordered
	 */
	protected int astType = AST_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimesExecuted() <em>Times Executed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimesExecuted()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMES_EXECUTED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimesExecuted() <em>Times Executed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimesExecuted()
	 * @generated
	 * @ordered
	 */
	protected int timesExecuted = TIMES_EXECUTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoveragePointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EpsilonCoveragePackage.Literals.COVERAGE_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(int newLine) {
		int oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.COVERAGE_POINT__LINE, oldLine, line));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(int newColumn) {
		int oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.COVERAGE_POINT__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAstType() {
		return astType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAstType(int newAstType) {
		int oldAstType = astType;
		astType = newAstType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.COVERAGE_POINT__AST_TYPE, oldAstType, astType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimesExecuted() {
		return timesExecuted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimesExecuted(int newTimesExecuted) {
		int oldTimesExecuted = timesExecuted;
		timesExecuted = newTimesExecuted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.COVERAGE_POINT__TIMES_EXECUTED, oldTimesExecuted, timesExecuted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.COVERAGE_POINT__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EpsilonCoveragePackage.COVERAGE_POINT__LINE:
				return getLine();
			case EpsilonCoveragePackage.COVERAGE_POINT__COLUMN:
				return getColumn();
			case EpsilonCoveragePackage.COVERAGE_POINT__AST_TYPE:
				return getAstType();
			case EpsilonCoveragePackage.COVERAGE_POINT__TIMES_EXECUTED:
				return getTimesExecuted();
			case EpsilonCoveragePackage.COVERAGE_POINT__URI:
				return getUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EpsilonCoveragePackage.COVERAGE_POINT__LINE:
				setLine((Integer)newValue);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__COLUMN:
				setColumn((Integer)newValue);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__AST_TYPE:
				setAstType((Integer)newValue);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__TIMES_EXECUTED:
				setTimesExecuted((Integer)newValue);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__URI:
				setUri((String)newValue);
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
			case EpsilonCoveragePackage.COVERAGE_POINT__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__AST_TYPE:
				setAstType(AST_TYPE_EDEFAULT);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__TIMES_EXECUTED:
				setTimesExecuted(TIMES_EXECUTED_EDEFAULT);
				return;
			case EpsilonCoveragePackage.COVERAGE_POINT__URI:
				setUri(URI_EDEFAULT);
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
			case EpsilonCoveragePackage.COVERAGE_POINT__LINE:
				return line != LINE_EDEFAULT;
			case EpsilonCoveragePackage.COVERAGE_POINT__COLUMN:
				return column != COLUMN_EDEFAULT;
			case EpsilonCoveragePackage.COVERAGE_POINT__AST_TYPE:
				return astType != AST_TYPE_EDEFAULT;
			case EpsilonCoveragePackage.COVERAGE_POINT__TIMES_EXECUTED:
				return timesExecuted != TIMES_EXECUTED_EDEFAULT;
			case EpsilonCoveragePackage.COVERAGE_POINT__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (line: ");
		result.append(line);
		result.append(", column: ");
		result.append(column);
		result.append(", astType: ");
		result.append(astType);
		result.append(", timesExecuted: ");
		result.append(timesExecuted);
		result.append(", uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //CoveragePointImpl
