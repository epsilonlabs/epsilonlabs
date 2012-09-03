/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.dom.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.epsilon.eol.dom.DomPackage;
import org.eclipse.epsilon.eol.dom.PrimitiveExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PrimitiveExpressionImpl extends LiteralExpressionImpl implements PrimitiveExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomPackage.Literals.PRIMITIVE_EXPRESSION;
	}

} //PrimitiveExpressionImpl
