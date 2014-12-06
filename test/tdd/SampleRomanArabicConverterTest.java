/*******************************************************************************
 * Copyright (c) 2012 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    gpollice
 *    rpdabrowski
 *******************************************************************************/

package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Sample test cases for the RomanArabicConverter class.
 *
 * @author rpdabrowski
 * @version Nov 30, 2014
 */
public class SampleRomanArabicConverterTest {

	@Test
	public void input_1_() throws ValueOutOfBoundsException, MalformedNumberException
	{
		assertEquals(1,   new RomanArabicConverter(" 1 ").toArabic());
		assertEquals("I", new RomanArabicConverter(" 1 ").toRoman());
	}
	
	@Test
	public void input_2_() throws ValueOutOfBoundsException, MalformedNumberException
	{
	    assertEquals(2, new RomanArabicConverter("                    2                   ").toArabic());
	    assertEquals("II", new RomanArabicConverter("                    2                   ").toRoman());
	}
	
	@Test (expected=MalformedNumberException.class)
	public void inputEmptyString() throws MalformedNumberException
	{
		new RomanArabicConverter("");
	}
	
	@Test (expected=MalformedNumberException.class)
	public void inputIIII() throws MalformedNumberException
	{
		new RomanArabicConverter("IIII");
	}
}
