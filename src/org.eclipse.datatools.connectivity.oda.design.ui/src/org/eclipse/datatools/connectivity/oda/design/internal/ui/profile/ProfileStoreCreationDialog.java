/*
 *************************************************************************
 * Copyright (c) 2007, 2009 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation - initial API and implementation
 *  
 *************************************************************************
 */

package org.eclipse.datatools.connectivity.oda.design.internal.ui.profile;

import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.internal.ui.wizards.ExportProfilesDialog;
import org.eclipse.datatools.connectivity.oda.design.internal.ui.profile.filter.NewProfileAction;
import org.eclipse.datatools.connectivity.oda.design.ui.nls.Messages;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ProfileStoreCreationDialog extends ExportProfilesDialog
{
    private CheckboxTableViewer m_profilesViewer;
    private IConnectionProfile m_preSelectProfile;
    
	public ProfileStoreCreationDialog( Shell parentShell )
	{
		super( parentShell );
        setShellStyle( super.getShellStyle() | SWT.PRIMARY_MODAL );
	}
	
	//@Override base method
	protected void configureShell( Shell newShell ) 
	{
		super.configureShell( newShell );
		newShell.setText( Messages.profileStoreCreationDialog_title ); 
	}
	
	//@Override base method
	protected Control createDialogArea( Composite parent ) 
	{
		Composite container = createParentDialogArea( parent );
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 20;
		gridLayout.numColumns = 3;		
		container.setLayout( gridLayout );
		
		// profiles selection group 
		{	
			final GridLayout groupGridLayout = new GridLayout();
            groupGridLayout.makeColumnsEqualWidth = false;
            groupGridLayout.numColumns = 3;            
            final Group group = createProfileSelectionGroup( container, groupGridLayout );
            
            // override group text
			group.setText( Messages.profileStoreCreationDialog_grouptext ); 

			// profiles selection viewer
			m_profilesViewer = setupCheckboxTableViewer( group );
			setCheckedProfile();  // pre-select profile, if specified
			
            // SelectAll button
			{				
				GridData selectAllButtonData = new GridData();
				selectAllButtonData.horizontalAlignment = SWT.LEFT;
				Button button = createSelectAllButton( group, selectAllButtonData );
		        selectAllButtonData.widthHint = ProfileSelectionPageHelper.computeButtonWidth( button );
			}
			
            // DeselectAll button
			{
				GridData deselectAllButtonData = new GridData();
				deselectAllButtonData.horizontalAlignment = SWT.LEFT;
				Button button = createDeselectAllButton( group, deselectAllButtonData );
				deselectAllButtonData.widthHint = ProfileSelectionPageHelper.computeButtonWidth( button );
			}
			
            // New... button
			{
		        Button newButton = new Button( group, SWT.PUSH );
		        newButton.setText( Messages.profileStoreCreationDialog_button_new );
		        newButton.setToolTipText( Messages.profileStoreCreationDialog_newbutton_tooltiptext );
		        GridData newButtonData = new GridData();
		        newButtonData.horizontalAlignment = SWT.RIGHT;
		        newButtonData.verticalAlignment = SWT.TOP;
		        newButtonData.widthHint = ProfileSelectionPageHelper.computeButtonWidth( newButton );
		        newButton.setLayoutData( newButtonData );

		        newButton.addSelectionListener( new SelectionAdapter() 
		        {
		            public void widgetSelected( SelectionEvent e )
		            {
						handleNewProfile();
					}

					private void handleNewProfile()
					{
						// Create a new connection profile
						NewProfileAction newProfileAction = new NewProfileAction( getShell() );
						newProfileAction.run();
						m_profilesViewer.refresh();						
					}
		        } );      
			}			
		}	
		
		Label spacingLabel = createVerticalSpacingLabel( container );
				
        // composite for the new profile store file controls
		Composite composite = new Composite( container, SWT.NONE );
		{
			GridData gridData = new GridData();
			gridData.horizontalSpan = 3;
			gridData.grabExcessHorizontalSpace = true;
			gridData.minimumWidth = 410;
			composite.setLayoutData( gridData );
		}
		composite.setLayout( new FormLayout() );
        // File path label
		final Label fileNameLabel = createFilePathLabel( composite, null );
        // File path text control
		Text filenameText;
		{
			FormData data = new FormData();
			data.left = new FormAttachment( fileNameLabel, 6 );
			data.width = 290;
			filenameText = setupFilePathText( composite, data ); 
		}
		// Browse... button
		{
			FormData data = new FormData();
			data.left = new FormAttachment( filenameText, 12 );
			data.top = new FormAttachment( spacingLabel, -1 );
			
		    Button browseButton = createFilePathBrowseButton( composite, data );
            data.width = ProfileSelectionPageHelper.computeButtonWidth( browseButton );
		} 
        
        // Encrypt file checkbox
	    setupEncryptContentCheckbox( container );
	    
        setupHelp( getShell() );
		return container;
	}
	
	/**
	 * Specifies the connection profile element to pre-select in the dialog
     * to get included in the new profile store by default.
     * This method can be called before the dialog area is created.
	 * @param profile  the profile element to pre-select in the dialog's profiles viewer; 
	 *                 may be null to unset before the dialog area is created
	 */
	public void setPreSelectedProfile( IConnectionProfile profile )
	{
	    // hold on to profile to pre-select when the dialog area is created
	    m_preSelectProfile = profile;
	}
	
	private void setCheckedProfile()
	{
	    if( m_profilesViewer == null || m_preSelectProfile == null )
	        return;
	    
	    m_profilesViewer.setChecked( m_preSelectProfile, true );
	}
	
}


