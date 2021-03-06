/*******************************************************************************
 * Copyright (c) 2010, 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Stephane Thibaudeau (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.umlgen.reverse.c.activity.test;

import org.eclipse.umlgen.reverse.c.activity.test.utils.AbstractTest;
import org.junit.Test;

public class TestBreakInLoop extends AbstractTest {

    @Test
    public void breakInNestedFor() {
        testCFile("breakInLoop/breakInNestedFor.c", false);
    }

    @Test
    public void breakInNestedForAndIf() {
        testCFile("breakInLoop/breakInNestedForAndIf.c", false);
    }

    @Test
    public void breakInNestedForAndIf2() {
        testCFile("breakInLoop/breakInNestedForAndIf2.c", false);
    }
}
