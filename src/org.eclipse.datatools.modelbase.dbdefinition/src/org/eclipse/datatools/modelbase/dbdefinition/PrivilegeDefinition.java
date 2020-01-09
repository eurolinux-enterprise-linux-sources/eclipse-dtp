/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrivilegeDefinition.java,v 1.1 2007/05/31 00:29:10 dpchou Exp $
 */
package org.eclipse.datatools.modelbase.dbdefinition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Privilege Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.datatools.modelbase.dbdefinition.PrivilegeDefinition#getActionElementDefinitions <em>Action Element Definitions</em>}</li>
 *   <li>{@link org.eclipse.datatools.modelbase.dbdefinition.PrivilegeDefinition#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.datatools.modelbase.dbdefinition.DatabaseDefinitionPackage#getPrivilegeDefinition()
 * @model
 * @generated
 */
public interface PrivilegeDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Action Element Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.datatools.modelbase.dbdefinition.PrivilegedElementDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Element Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Element Definitions</em>' reference list.
	 * @see org.eclipse.datatools.modelbase.dbdefinition.DatabaseDefinitionPackage#getPrivilegeDefinition_ActionElementDefinitions()
	 * @model type="org.eclipse.datatools.modelbase.dbdefinition.PrivilegedElementDefinition"
	 * @generated
	 */
	EList getActionElementDefinitions();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.datatools.modelbase.dbdefinition.DatabaseDefinitionPackage#getPrivilegeDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.datatools.modelbase.dbdefinition.PrivilegeDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // PrivilegeDefinition
