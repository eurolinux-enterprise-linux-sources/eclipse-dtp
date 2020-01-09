/**
 *************************************************************************
 * Copyright (c) 2009 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation - initial API and implementation
 *  
 *************************************************************************
 *
 * $Id: AndExpressionImpl.java,v 1.2 2010/03/17 00:34:13 lchan Exp $
 */
package org.eclipse.datatools.connectivity.oda.design.impl;

import org.eclipse.datatools.connectivity.oda.design.AndExpression;
import org.eclipse.datatools.connectivity.oda.design.DesignPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 * @since 3.3 (DTP 1.8)
 */
public class AndExpressionImpl extends CompositeFilterExpressionImpl implements
        AndExpression
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2009 Actuate Corporation"; //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AndExpressionImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DesignPackage.Literals.AND_EXPRESSION;
    }

    /* (non-Javadoc)
     * @see org.eclipse.datatools.connectivity.oda.design.impl.FilterExpressionImpl#isNegatable()
     * @generated NOT
     */
    @Override
    public boolean isNegatable()
    {
        return true;
    }

} //AndExpressionImpl
