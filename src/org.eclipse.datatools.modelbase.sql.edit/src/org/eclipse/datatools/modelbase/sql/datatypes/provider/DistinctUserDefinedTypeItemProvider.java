/**
 * <copyright>
 * </copyright>
 *
 * $Id: DistinctUserDefinedTypeItemProvider.java,v 1.3 2007/05/31 00:29:17 dpchou Exp $
 */
package org.eclipse.datatools.modelbase.sql.datatypes.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.datatools.modelbase.sql.datatypes.DistinctUserDefinedType;
import org.eclipse.datatools.modelbase.sql.datatypes.SQLDataTypesFactory;
import org.eclipse.datatools.modelbase.sql.datatypes.SQLDataTypesPackage;
import org.eclipse.datatools.modelbase.sql.schema.provider.SqlmodelEditPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;


/**
 * This is the item provider adapter for a {@link org.eclipse.datatools.modelbase.sql.datatypes.DistinctUserDefinedType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DistinctUserDefinedTypeItemProvider
	extends UserDefinedTypeItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctUserDefinedTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION);
		}
		return childrenFeatures;
	}

	/**
	 * This returns DistinctUserDefinedType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DistinctUserDefinedType")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((DistinctUserDefinedType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DistinctUserDefinedType_type") : //$NON-NLS-1$
			getString("_UI_DistinctUserDefinedType_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DistinctUserDefinedType.class)) {
			case SQLDataTypesPackage.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createCharacterStringDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createBooleanDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createIntervalDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createBinaryStringDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createTimeDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createFixedPrecisionDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createDataLinkDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createDateDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createApproximateNumericDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createIntegerDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SQLDataTypesPackage.Literals.DISTINCT_USER_DEFINED_TYPE__PREDEFINED_REPRESENTATION,
				 SQLDataTypesFactory.eINSTANCE.createXMLDataType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return SqlmodelEditPlugin.INSTANCE;
	}

}
