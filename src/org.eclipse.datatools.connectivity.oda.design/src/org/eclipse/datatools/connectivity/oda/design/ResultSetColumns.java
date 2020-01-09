/**
 *************************************************************************
 * Copyright (c) 2005, 2009 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *  
 *************************************************************************
 *
 * $Id: ResultSetColumns.java,v 1.3 2009/04/24 03:20:26 lchan Exp $
 */
package org.eclipse.datatools.connectivity.oda.design;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A collection of result set columns' definitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.datatools.connectivity.oda.design.ResultSetColumns#getResultColumnDefinitions <em>Result Column Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.datatools.connectivity.oda.design.DesignPackage#getResultSetColumns()
 * @model extendedMetaData="name='ResultSetColumns' kind='elementOnly'"
 * @generated
 */
public interface ResultSetColumns extends EObject
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2005, 2009 Actuate Corporation"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Result Column Definitions</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.datatools.connectivity.oda.design.ColumnDefinition}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Result Column Definitions</em>' containment reference list.
     * @see org.eclipse.datatools.connectivity.oda.design.DesignPackage#getResultSetColumns_ResultColumnDefinitions()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='resultColumnDefinitions' namespace='##targetNamespace'"
     * @generated
     */
    EList<ColumnDefinition> getResultColumnDefinitions();

} // ResultSetColumns
