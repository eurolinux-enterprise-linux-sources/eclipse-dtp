/*******************************************************************************
 * Copyright � 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqlbuilder.views.source;

public class SQLWhitespaceDetector implements org.eclipse.jface.text.rules.IWhitespaceDetector {

    /**
     * Constructor.
     */
    public SQLWhitespaceDetector() {
        super();
    }

    /**
     * Returns whether the specified character is whitespace.
     */
    public boolean isWhitespace(char c) {
        return Character.isWhitespace(c);
    }
}