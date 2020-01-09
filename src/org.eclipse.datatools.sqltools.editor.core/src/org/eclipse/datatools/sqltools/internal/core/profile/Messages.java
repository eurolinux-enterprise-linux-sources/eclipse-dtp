/*******************************************************************************
 * Copyright (c) 2004, 2005 Sybase, Inc. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.internal.core.profile;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {

	private static final String BUNDLE_NAME = Messages.class.getPackage().getName() + ".messages";//$NON-NLS-1$

	private Messages() {
		// Do not instantiate
	}

	public static String NoSuchProfileException_cant_find_profile;
	public static String ProfileUtil_unkown_connection_type;
	public static String ProfileUtil_error_create_connection;
	public static String ProfileUtil_error_getReusableConnection;
	public static String ProfileUtil_error_getdriver;
	public static String ProfileUtil_error_not_connected;
	public static String ProfileUtil_error_wrong_database_name;
	public static String ProfileUtil_error_no_managed_connection;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}