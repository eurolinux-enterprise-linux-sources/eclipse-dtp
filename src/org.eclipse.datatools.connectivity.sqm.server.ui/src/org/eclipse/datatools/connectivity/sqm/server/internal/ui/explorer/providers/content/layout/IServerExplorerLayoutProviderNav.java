/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers.content.layout;


/**
 * @author ljulien
 */
public interface IServerExplorerLayoutProviderNav
{
	public Object[] getChildren(Object parentElement);
	public Object organizeChildren (Object parent);
	public Object [] displayServerChildren (Object server);
}
