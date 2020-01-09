/*
 *************************************************************************
 * Copyright (c) 2008 Actuate Corporation.
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

package org.eclipse.datatools.connectivity.oda.design.internal.ui.profile.filter;

import org.eclipse.datatools.connectivity.ui.actions.AddProfileViewAction;
import org.eclipse.datatools.connectivity.ui.navigator.actions.ProfileActionsActionProvider;

/**
 * Extends the DTP Data Source Explorer's default Profile Action Provider
 * to provide own extended action.
 */
public class OdaProfileActionProvider extends
        ProfileActionsActionProvider
{
    
    /*
     * (non-Javadoc)
     * @see org.eclipse.datatools.connectivity.ui.navigator.actions.ProfileActionsActionProvider#createAddProfileViewAction()
     */
    protected AddProfileViewAction createAddProfileViewAction()
    {
        return new NewProfileAction();
    }

}
