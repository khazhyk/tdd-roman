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
    public void input_15_() throws ValueOutOfBoundsException, MalformedNumberException {
        assertEquals(15, new RomanArabicConverter("15").toArabic());
        assertEquals("XV", new RomanArabicConverter("15").toRoman());
    }
	
	@Test
	public void input_37_() throws ValueOutOfBoundsException, MalformedNumberException {
	    RomanArabicConverter rac = new RomanArabicConverter("37");
	    assertEquals(37, rac.toArabic());
	    assertEquals("XXXVII", rac.toRoman());
	}
	
	@Test
    public void input_49_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("49");
        assertEquals(49, rac.toArabic());
        assertEquals("XLIX", rac.toRoman());
    }
	
	@Test
    public void input_99_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("99");
        assertEquals(99, rac.toArabic());
        assertEquals("XCIX", rac.toRoman());
    }
	
	@Test
    public void input_100_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("100");
        assertEquals(100, rac.toArabic());
        assertEquals("C", rac.toRoman());
    }
	
	@Test
    public void input_454_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("454");
        assertEquals(454, rac.toArabic());
        assertEquals("CDLIV", rac.toRoman());
    }
	
	@Test
    public void input_506_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("506");
        assertEquals(506, rac.toArabic());
        assertEquals("DVI", rac.toRoman());
    }
	
	@Test
    public void input_785_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("785");
        assertEquals(785, rac.toArabic());
        assertEquals("DCCLXXXV", rac.toRoman());
    }
	
	@Test
    public void input_999_() throws ValueOutOfBoundsException, MalformedNumberException {
        RomanArabicConverter rac = new RomanArabicConverter("999");
        assertEquals(999, rac.toArabic());
        assertEquals("CMXCIX", rac.toRoman());
    }
	
	@Test
	public void input_II_() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals(2, new RomanArabicConverter("II").toArabic());
	    assertEquals("II", new RomanArabicConverter("II").toRoman());
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
