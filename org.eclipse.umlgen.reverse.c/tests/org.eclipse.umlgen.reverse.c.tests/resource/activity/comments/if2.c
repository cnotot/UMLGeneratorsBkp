/*******************************************************************************
 * Copyright (c) 2010, 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Comment before the tested function
 */
void f() {
	printf("A");

	// Before 1
	int i = 10;
	// Before 2
	if (/*inline 1*/ i < 5) { // Same line 1
		// Inside then clause
		printf("C");
		// Last line of then clause
	} else {
		// Inside else clause
		printf("D");
		// Last line of else clause
	}

	printf("B");
}// Comment out of function body

/**
 * Comment after the tested function
 */
void g() {
	printf("B\n");
}
