/*
 *************************************************************************
 * Copyright (c) 2005, 2008 Actuate Corporation.
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

package org.eclipse.datatools.connectivity.oda.flatfile.ui.wizards;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.SortedMap;

import org.eclipse.datatools.connectivity.oda.design.ui.nls.TextProcessorWrapper;
import org.eclipse.datatools.connectivity.oda.flatfile.CommonConstants;
import org.eclipse.datatools.connectivity.oda.flatfile.ui.i18n.Messages;
import org.eclipse.datatools.connectivity.oda.flatfile.ui.util.IHelpConstants;
import org.eclipse.datatools.connectivity.oda.flatfile.ui.util.Utility;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class FolderSelectionPageHelper
{

	private WizardPage wizardPage;
	private PreferencePage propertyPage;

	private transient Text folderLocation = null;
	private transient Button typeLineCheckBox = null;
	private transient Button browseFolderButton = null;
	private transient Combo charSetSelectionCombo = null;
	private transient Button columnNameLineCheckBox = null;
	private transient Combo flatFileStyleCombo = null;

	private static final String[] flatFileStyles= new String[]{
		Messages.getString( "label.flatfileComma" ), //$NON-NLS-1$
		Messages.getString( "label.flatfileSemicolon" ),//$NON-NLS-1$
		Messages.getString( "label.flatfilePipe" ),//$NON-NLS-1$
		Messages.getString( "label.flatfileTab" ),//$NON-NLS-1$
	};

	private SortedMap charSetMap;

	static final String DEFAULT_MESSAGE = Messages.getString( "wizard.defaultMessage.selectFolder" ); //$NON-NLS-1$

	private static final int CORRECT_FOLDER = 0;
	private static final int ERROR_FOLDER = 1;
	private static final int ERROR_EMPTY_PATH = 2;
	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	FolderSelectionPageHelper( WizardPage page )
	{
		wizardPage = page;
	}

	FolderSelectionPageHelper( PreferencePage page )
	{
		propertyPage = page;
	}

	/**
	 * 
	 * @param parent
	 */
	void createCustomControl( Composite parent )
	{
		Composite content = new Composite( parent, SWT.NULL );
		GridLayout layout = new GridLayout( 3, false );
		content.setLayout( layout );

		// GridData data;
		setupFolderLocation( content );

		setupCharset( content );

		setupFlatfileStyleList( content );

		setupColumnNameLineCheckBox( content );

		setupTypeLineCheckBox( content );
		
		Utility.setSystemHelp( getControl(),
				IHelpConstants.CONEXT_ID_DATASOURCE_FLATFILE );
	}

	/**
	 * 
	 * @return
	 */
	String getFolderLocation( )
	{
		if ( folderLocation == null )
			return EMPTY_STRING;
		return getFolderLocationString( );
	}

	/**
	 * 
	 * @return
	 */
	String getWhetherUseFirstLineAsColumnNameLine( )
	{
		if ( columnNameLineCheckBox == null
				|| !columnNameLineCheckBox.getEnabled( ) )
			return EMPTY_STRING;
		return columnNameLineCheckBox.getSelection( )
				? CommonConstants.INC_COLUMN_NAME_YES
				: CommonConstants.INC_COLUMN_NAME_NO;
	}

	/**
	 * 
	 * @return
	 */
	String getWhetherUseSecondLineAsTypeLine( )
	{
		if ( typeLineCheckBox == null )
			return EMPTY_STRING;
		return typeLineCheckBox.getSelection( )
				? CommonConstants.INC_TYPE_LINE_YES
				: CommonConstants.INC_TYPE_LINE_NO;
	}

	/**
	 * 
	 * @return
	 */
	String getCharSet( )
	{
		if ( charSetSelectionCombo == null )
			return EMPTY_STRING;
		return charSetSelectionCombo.getItem( charSetSelectionCombo.getSelectionIndex( ) );
	}

	/**
	 * 
	 * @param props
	 * @return
	 */
	Properties collectCustomProperties( Properties props )
	{
		if ( props == null )
			props = new Properties( );

		// set custom driver specific properties
		props.setProperty( CommonConstants.CONN_HOME_DIR_PROP,
				getFolderLocation( ).trim( ) );
		props.setProperty( CommonConstants.CONN_DELIMITER_TYPE,
				getFlatfileStyle( ) );
		props.setProperty( CommonConstants.CONN_INCLCOLUMNNAME_PROP,
				getWhetherUseFirstLineAsColumnNameLine( ) );
		props.setProperty( CommonConstants.CONN_INCLTYPELINE_PROP,
				getWhetherUseSecondLineAsTypeLine( ) );
		props.setProperty( CommonConstants.CONN_CHARSET_PROP, getCharSet( ) );
		return props;
	}

	/**
	 * 
	 * @param profileProps
	 */
	void initCustomControl( Properties profileProps )
	{
		if ( profileProps == null
				|| profileProps.isEmpty( ) || folderLocation == null )
			return; // nothing to initialize

		String folderPath = profileProps.getProperty( CommonConstants.CONN_HOME_DIR_PROP );
		if ( folderPath == null )
			folderPath = EMPTY_STRING;
		setFolderLocationString( folderPath );

		String delimiterType = profileProps.getProperty( CommonConstants.CONN_DELIMITER_TYPE );
		initFlatfileSytleSelection( delimiterType );

		String hasColumnNameLine = profileProps.getProperty( CommonConstants.CONN_INCLCOLUMNNAME_PROP );
		if ( hasColumnNameLine == null )
			hasColumnNameLine = CommonConstants.INC_COLUMN_NAME_YES;
		if ( hasColumnNameLine.equalsIgnoreCase( CommonConstants.INC_COLUMN_NAME_YES ) )
		{
			columnNameLineCheckBox.setSelection( true );

			String useSecondLine = profileProps.getProperty( CommonConstants.CONN_INCLTYPELINE_PROP );
			if ( useSecondLine == null )
				useSecondLine = EMPTY_STRING;
			typeLineCheckBox.setEnabled( true );
			typeLineCheckBox.setSelection( useSecondLine.equalsIgnoreCase( CommonConstants.INC_TYPE_LINE_YES ) );
		}
		else
		{
			columnNameLineCheckBox.setSelection( false );
			typeLineCheckBox.setSelection( false );
			typeLineCheckBox.setEnabled( false );
		}

		String charSet = profileProps.getProperty( CommonConstants.CONN_CHARSET_PROP );
		if ( charSet == null || charSet.trim( ).length( ) == 0 )
			charSetSelectionCombo.select( 0 );
		else
			charSetSelectionCombo.select( charSetSelectionCombo.indexOf( charSet ) );

		verifyFileLocation( );
	}

	/**
	 * 
	 * @return the selected flatfile style
	 */
	private String getFlatfileStyle( )
	{
		String value = flatFileStyleCombo.getText( );
		//return value;
		if( value.equals( flatFileStyles[0] ) )
		{
			return CommonConstants.DELIMITER_COMMA;
		}
		else if( value.equals( flatFileStyles[1] ) )
		{
			return CommonConstants.DELIMITER_SEMICOLON;
		}
		else if( value.equals( flatFileStyles[2] ) )
		{
			return CommonConstants.DELIMITER_PIPE;
		}
		else if( value.equals( flatFileStyles[3] ) )
		{
			return CommonConstants.DELIMITER_TAB;
		}
		return CommonConstants.DELIMITER_COMMA;
	}

	/**
	 * 
	 * @param folderPath
	 */
	private void setFolderLocationString( String folderPath )
	{
		folderLocation.setText( TextProcessorWrapper.process( folderPath ) );
	}
	
	/**
	 * 
	 * @return
	 */
	private String getFolderLocationString( )
	{
		return TextProcessorWrapper.deprocess( folderLocation.getText( ) );
	}

	/**
	 * 
	 * @param delimiterType
	 */
	private void initFlatfileSytleSelection( String delimiterType )
	{
		if ( CommonConstants.DELIMITER_COMMA.equals( delimiterType ) )
		{
			flatFileStyleCombo.select( 0 );
		}
		else if ( CommonConstants.DELIMITER_SEMICOLON.equals( delimiterType ) )
		{
			flatFileStyleCombo.select( 1 );
		}
		else if ( CommonConstants.DELIMITER_PIPE.equals( delimiterType ) )
		{
			flatFileStyleCombo.select( 2 );
		}
		else if ( CommonConstants.DELIMITER_TAB.equals( delimiterType ) )
		{
			flatFileStyleCombo.select( 3 );
		}
	}
	
	/**
	 * 
	 * @param composite
	 */
	private void setupFolderLocation( Composite composite )
	{
		Label label = new Label( composite, SWT.NONE );
		label.setText( Messages.getString( "label.selectFolder" ) ); //$NON-NLS-1$

		GridData data = new GridData( GridData.FILL_HORIZONTAL );

		folderLocation = new Text( composite, SWT.BORDER );
		folderLocation.setLayoutData( data );
		setPageComplete( false );
		folderLocation.addModifyListener( new ModifyListener( ) {

			public void modifyText( ModifyEvent e )
			{
				verifyFileLocation( );
			}

		} );

		browseFolderButton = new Button( composite, SWT.NONE );
		browseFolderButton.setText( Messages.getString( "button.selectFolder.browse" ) ); //$NON-NLS-1$
		browseFolderButton.addSelectionListener( new SelectionAdapter( ) {

			/*
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected( SelectionEvent e )
			{
				DirectoryDialog dialog = new DirectoryDialog( folderLocation.getShell( ) );
				String folderLocationValue = getFolderLocationString( );
				if ( folderLocationValue != null
						&& folderLocationValue.trim( ).length( ) > 0 )
				{
					dialog.setFilterPath( folderLocationValue );
				}

				dialog.setMessage( DEFAULT_MESSAGE );
				String selectedLocation = dialog.open( );
				if ( selectedLocation != null )
				{
					setFolderLocationString( selectedLocation );
				}
			}
		} );
	}

	/**
	 * 
	 * @return
	 */
	private int verifyFileLocation( )
	{
		int result = CORRECT_FOLDER;
		String folderLocationValue = getFolderLocationString( );
		if ( folderLocationValue.trim( ).length( ) > 0 )
		{
			File f = new File( folderLocationValue.trim( ) );
			if ( f.exists( ) )
			{
				setMessage( DEFAULT_MESSAGE, IMessageProvider.NONE );
				setPageComplete( true );
			}
			else
			{
				setMessage( Messages.getString( "error.selectFolder" ), IMessageProvider.ERROR ); //$NON-NLS-1$
				setPageComplete( false );
				result = ERROR_FOLDER;
			}
		}
		else
		{
			setMessage( Messages.getString( "error.emptyPath" ), IMessageProvider.ERROR ); //$NON-NLS-1$
			setPageComplete( false );
			result = ERROR_EMPTY_PATH;
		}
		if( result == CORRECT_FOLDER )
			return result;
		
		if( wizardPage == null )
		{
			setPageComplete( true );
			setMessage( Messages.getString( "error.invalidFlatFilePath" ), IMessageProvider.ERROR ); //$NON-NLS-1$
		}
		return result;
	}

	/**
	 * @param composite
	 */
	private void setupCharset( Composite composite )
	{
		Label labelCharSet = new Label( composite, SWT.NONE );
		labelCharSet.setText( Messages.getString( "label.selectCharset" ) ); //$NON-NLS-1$

		charSetSelectionCombo = new Combo( composite, SWT.READ_ONLY );

		GridData data = new GridData( GridData.HORIZONTAL_ALIGN_FILL );
		data.horizontalSpan = 2;
		charSetSelectionCombo.setLayoutData( data );

		charSetMap = Charset.availableCharsets( );
		Object[] charSetsArray = charSetMap.keySet( ).toArray( );
		for ( int i = 0; i < charSetsArray.length; i++ )
		{
			String charSetName = ( (Charset) charSetMap.get( charSetsArray[i] ) ).name( );
			charSetSelectionCombo.add( charSetName );
			if ( CommonConstants.CONN_DEFAULT_CHARSET.equalsIgnoreCase( charSetName ) )
				charSetSelectionCombo.select( i );
		}
	}

	/**
	 * To set up the flatfile styles' list
	 * 
	 * @param composite
	 */
	private void setupFlatfileStyleList( Composite composite )
	{
		Label labelCSVType = new Label( composite, SWT.NONE );
		labelCSVType.setText( Messages.getString( "label.selectFlatfileStyle" ) ); //$NON-NLS-1$

		flatFileStyleCombo = new Combo( composite, SWT.READ_ONLY );
		GridData data = new GridData(  GridData.HORIZONTAL_ALIGN_FILL );
		data.horizontalSpan = 2;
		flatFileStyleCombo.setLayoutData( data );

		for ( int i = 0; i < flatFileStyles.length; i++ )
		{
			flatFileStyleCombo.add( flatFileStyles[i] );
		}
		flatFileStyleCombo.select( 0 );
	}
	
	/**
	 * 
	 * @param composite
	 */
	private void setupColumnNameLineCheckBox( Composite composite )
	{
		Label labelFill = new Label( composite, SWT.NONE );
		labelFill.setText( "" ); //$NON-NLS-1$

		columnNameLineCheckBox = new Button( composite, SWT.CHECK );
		columnNameLineCheckBox.setToolTipText( Messages.getString( "tooltip.columnnameline" ) ); //$NON-NLS-1$
		GridData gd = new GridData( );
		gd.horizontalSpan = 3;
		columnNameLineCheckBox.setLayoutData( gd );
		columnNameLineCheckBox.setText( Messages.getString( "label.includeColumnNameLine" ) ); //$NON-NLS-1$
		columnNameLineCheckBox.setSelection( true );
		columnNameLineCheckBox.addSelectionListener( new SelectionAdapter( ) {

			public void widgetSelected( SelectionEvent e )
			{
				if ( columnNameLineCheckBox.getSelection( ) )
					typeLineCheckBox.setEnabled( true );
				else
				{
					typeLineCheckBox.setSelection( false );
					typeLineCheckBox.setEnabled( false );
				}
			}
		} );

	}

	/**
	 * @param composite
	 */
	private void setupTypeLineCheckBox( Composite composite )
	{
		typeLineCheckBox = new Button( composite, SWT.CHECK );
		typeLineCheckBox.setToolTipText( Messages.getString( "tooltip.typeline" ) ); //$NON-NLS-1$
		GridData data = new GridData( );
		data.horizontalSpan = 3;
		typeLineCheckBox.setLayoutData( data );
		typeLineCheckBox.setText( Messages.getString( "label.includeTypeLine" ) ); //$NON-NLS-1$
		if ( columnNameLineCheckBox.getSelection( ) )
			typeLineCheckBox.setEnabled( true );
		else
		{
			typeLineCheckBox.setSelection( false );
			typeLineCheckBox.setEnabled( false );
		}
	}

	/**
	 * 
	 * @param complete
	 */
	private void setPageComplete( boolean complete )
	{
		if ( wizardPage != null )
			wizardPage.setPageComplete( complete );
		else if ( propertyPage != null )
			propertyPage.setValid( complete );
	}

	/**
	 * 
	 * @param newMessage
	 * @param newType
	 */
	private void setMessage( String newMessage, int newType )
	{
		if ( wizardPage != null )
			wizardPage.setMessage( newMessage, newType );
		else if ( propertyPage != null )
			propertyPage.setMessage( newMessage, newType );
	}
	
    private Control getControl()
    {
        if ( wizardPage != null )
            return wizardPage.getControl();
        if ( propertyPage != null )
            return propertyPage.getControl();
        
       return null;
    }

}


