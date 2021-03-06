/*******************************************************************************
 * Copyright (c) 2008, 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.umlgen.gen.java.tests.classes.properties;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of CardinalityPropertiesClass.
 * 
 * @author Obeo
 */
public class CardinalityPropertiesClass {
	/**
	 * Description of the property orderedUniqueProperty.
	 */
	public LinkedHashSet<Boolean> orderedUniqueProperty = new LinkedHashSet<Boolean>();

	/**
	 * Description of the property notOrderedUniqueProperty.
	 */
	public HashSet<Date> notOrderedUniqueProperty = new HashSet<Date>();

	/**
	 * Description of the property notOrderedNotUniqueProperty.
	 */
	public ArrayList<Integer> notOrderedNotUniqueProperty = new ArrayList<Integer>();

	/**
	 * Description of the property orderedNotUniqueProperty.
	 */
	public ArrayList<String> orderedNotUniqueProperty = new ArrayList<String>();

	// Start of user code (user defined attributes for CardinalityPropertiesClass)

	// End of user code

	/**
	 * The constructor.
	 */
	public CardinalityPropertiesClass() {
		// Start of user code constructor for CardinalityPropertiesClass)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for CardinalityPropertiesClass)

	// End of user code
	/**
	 * Returns orderedUniqueProperty.
	 * @return orderedUniqueProperty 
	 */
	public LinkedHashSet<Boolean> getOrderedUniqueProperty() {
		return this.orderedUniqueProperty;
	}

	/**
	 * Returns notOrderedUniqueProperty.
	 * @return notOrderedUniqueProperty 
	 */
	public HashSet<Date> getNotOrderedUniqueProperty() {
		return this.notOrderedUniqueProperty;
	}

	/**
	 * Returns notOrderedNotUniqueProperty.
	 * @return notOrderedNotUniqueProperty 
	 */
	public ArrayList<Integer> getNotOrderedNotUniqueProperty() {
		return this.notOrderedNotUniqueProperty;
	}

	/**
	 * Returns orderedNotUniqueProperty.
	 * @return orderedNotUniqueProperty 
	 */
	public ArrayList<String> getOrderedNotUniqueProperty() {
		return this.orderedNotUniqueProperty;
	}

}
