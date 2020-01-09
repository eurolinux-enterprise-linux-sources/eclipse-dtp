/**
 * <copyright>
 * </copyright>
 *
 * $Id: SybaseASEPrivilegeImpl.java,v 1.1 2008/03/27 07:41:13 lsong Exp $
 */
package org.eclipse.datatools.enablement.sybase.ase.models.sybaseasesqlmodel.impl;

import org.eclipse.datatools.enablement.sybase.ase.models.sybaseasesqlmodel.SybaseASEPrivilege;
import org.eclipse.datatools.enablement.sybase.ase.models.sybaseasesqlmodel.SybaseasesqlmodelPackage;

import org.eclipse.datatools.enablement.sybase.models.sybasesqlmodel.impl.SybasePrivilegeImpl;

import org.eclipse.datatools.modelbase.sql.accesscontrol.impl.PrivilegeImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sybase ASE Privilege</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SybaseASEPrivilegeImpl extends SybasePrivilegeImpl implements SybaseASEPrivilege
{
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SybaseASEPrivilegeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SybaseasesqlmodelPackage.Literals.SYBASE_ASE_PRIVILEGE;
    }

} //SybaseASEPrivilegeImpl