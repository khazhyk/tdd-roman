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
	
	@Test
	public void input_4_() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals(4, new RomanArabicConverter("4").toArabic());
	    assertEquals("IV", new RomanArabicConverter("4").toRoman());
	}
	
	@Test
	public void input_5_() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals(5, new RomanArabicConverter("5").toArabic());
	    assertEquals("V", new RomanArabicConverter("5").toRoman());
	}
	
	@Test
    public void input_6_() throws ValueOutOfBoundsException, MalformedNumberException {
        assertEquals(6, new RomanArabicConverter("6").toArabic());
        assertEquals("VI", new RomanArabicConverter("6").toRoman());
    }
	
	@Test
	public void input_9_() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals(9, new RomanArabicConverter("9").toArabic());
	    assertEquals("IX", new RomanArabicConverter("9").toRoman());
	}
	
	@Test
	public void input_10_() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals(10, new RomanArabicConverter("10").toArabic());
        assertEquals("X", new RomanArabicConverter("10").toRoman());
	}
	
	@Test
	public void whole_numbers() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals("I", new RomanArabicConverter("1").toRoman());
	    assertEquals("V", new RomanArabicConverter("5").toRoman());
	    assertEquals("X", new RomanArabicConverter("10").toRoman());
	    assertEquals("L", new RomanArabicConverter("50").toRoman());
	    assertEquals("C", new RomanArabicConverter("100").toRoman());
	    assertEquals("D", new RomanArabicConverter("500").toRoman());
	    assertEquals("M", new RomanArabicConverter("1000").toRoman());
	}
	
	@Test(expected=ValueOutOfBoundsException.class) 
	public void tooHigh() throws ValueOutOfBoundsException, MalformedNumberException {
	    new RomanArabicConverter("5000").toRoman();
	}
	
	@Test(expected=ValueOutOfBoundsException.class)
	public void tooLow() throws ValueOutOfBoundsException, MalformedNumberException {
	    new RomanArabicConverter("0").toRoman();
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
