/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 */
package org.eclipse.datatools.modelbase.sql.xml.query.util;

import org.eclipse.datatools.modelbase.sql.query.util.SQLQueryModelPlugin;

/**
 * This is the main plugin class for the SQL/XML Query Model. 
 * 
 * @author bpayton
 */
public class SQLXMLQueryModelPlugin extends SQLQueryModelPlugin {

    /**
     * Constructs an instance of this class.  This is the default constructor.
     * The super constructor is invoked to perform plugin start-up registrations.
     * (These are needed for the SQL Source Writer to work properly.)
     */
    public SQLXMLQueryModelPlugin() {
        super();
    }

}
