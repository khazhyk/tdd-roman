// $codepro.audit.disable methodJavadoc, missingAssertInTestMethod
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

    /*
     * First tests, going 1 to 10
     */
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
	
	/*
	 * Implementing the tens place
	 */
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
	    final RomanArabicConverter rac = new RomanArabicConverter("37");
	    assertEquals(37, rac.toArabic());
	    assertEquals("XXXVII", rac.toRoman());
	}
	
	@Test
    public void input_49_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("49");
        assertEquals(49, rac.toArabic());
        assertEquals("XLIX", rac.toRoman());
    }
	
	@Test
    public void input_99_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("99");
        assertEquals(99, rac.toArabic());
        assertEquals("XCIX", rac.toRoman());
    }
	
	/*
	 * Hundreds place is easy now that we factored this into per-place
	 */
	@Test
    public void input_100_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("100");
        assertEquals(100, rac.toArabic());
        assertEquals("C", rac.toRoman());
    }
	
	@Test
    public void input_454_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("454");
        assertEquals(454, rac.toArabic());
        assertEquals("CDLIV", rac.toRoman());
    }
	
	@Test
    public void input_506_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("506");
        assertEquals(506, rac.toArabic());
        assertEquals("DVI", rac.toRoman());
    }
	
	@Test
    public void input_785_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("785");
        assertEquals(785, rac.toArabic());
        assertEquals("DCCLXXXV", rac.toRoman());
    }
	
	@Test
    public void input_999_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("999");
        assertEquals(999, rac.toArabic());
        assertEquals("CMXCIX", rac.toRoman());
    }
	
	/*
	 * Thousands place now
	 */
	
	@Test
    public void input_1000_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("1000");
        assertEquals(1000, rac.toArabic());
        assertEquals("M", rac.toRoman());
    }
	
	@Test
    public void input_3427_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("3427");
        assertEquals(3427, rac.toArabic());
        assertEquals("MMMCDXXVII", rac.toRoman());
    }
	
	/*
	 * Testing going the other way
	 */
	
	/*
	 * Testing ones place
	 */
	@Test
	public void input_II_() throws ValueOutOfBoundsException, MalformedNumberException {
	    assertEquals(2, new RomanArabicConverter("II").toArabic());
	    assertEquals("II", new RomanArabicConverter("II").toRoman());
	}
	
	@Test
    public void input_IV_() throws ValueOutOfBoundsException, MalformedNumberException {
        assertEquals(4, new RomanArabicConverter("IV").toArabic());
        assertEquals("IV", new RomanArabicConverter("IV").toRoman());
    }
	
	@Test
    public void input_V_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("V");
        assertEquals(5, rac.toArabic());
        assertEquals("V", rac.toRoman());
    }
	
	@Test
    public void input_VII_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("VII");
        assertEquals(7, rac.toArabic());
        assertEquals("VII", rac.toRoman());
    }
	
	@Test
    public void input_IX_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("IX");
        assertEquals(9, rac.toArabic());
        assertEquals("IX", rac.toRoman());
    }
	
	/*
	 * Testing tens place
	 */
   @Test
    public void input_XX_() throws ValueOutOfBoundsException, MalformedNumberException {
       final RomanArabicConverter rac = new RomanArabicConverter("XX");
       assertEquals(20, rac.toArabic());
       assertEquals("XX", rac.toRoman());
    }
    
    @Test
    public void input_XL_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("XL");
        assertEquals(40, rac.toArabic());
        assertEquals("XL", rac.toRoman());
    }
    
    @Test
    public void input_L_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("L");
        assertEquals(50, rac.toArabic());
        assertEquals("L", rac.toRoman());
    }
    
    @Test
    public void input_LXX_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("LXX");
        assertEquals(70, rac.toArabic());
        assertEquals("LXX", rac.toRoman());
    }
    
    @Test
    public void input_XC_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("XC");
        assertEquals(90, rac.toArabic());
        assertEquals("XC", rac.toRoman());
    }
    
    @Test
    public void input_XCIX_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("XCIX");
        assertEquals(99, rac.toArabic());
        assertEquals("XCIX", rac.toRoman());
    }
    
    /*
     * Testing hundreds place
     */
    
    @Test
    public void input_C_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("C");
        assertEquals(100, rac.toArabic());
        assertEquals("C", rac.toRoman());
    }
    
    @Test
    public void input_CCIX_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("CCIX");
        assertEquals(209, rac.toArabic());
        assertEquals("CCIX", rac.toRoman());
    }
    
    @Test
    public void input_CCXLIX_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("CCXLIX");
        assertEquals(249, rac.toArabic());
        assertEquals("CCXLIX", rac.toRoman());
    }
    
    @Test
    public void input_CDLXII_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("CDLXII");
        assertEquals(462, rac.toArabic());
        assertEquals("CDLXII", rac.toRoman());
    }
    
	/*
	 * Testing thousands place
	 */
    
    @Test
    public void input_M_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("M");
        assertEquals(1000, rac.toArabic());
        assertEquals("M", rac.toRoman());
    }
    
    @Test
    public void input_MMM_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("MMM");
        assertEquals(3000, rac.toArabic());
        assertEquals("MMM", rac.toRoman());
    }
    
    @Test
    public void input_MMMCMXCIX_() throws ValueOutOfBoundsException, MalformedNumberException {
        final RomanArabicConverter rac = new RomanArabicConverter("MMMCMXCIX");
        assertEquals(3999, rac.toArabic());
        assertEquals("MMMCMXCIX", rac.toRoman());
    }
    
	/*
	 * Testing invalid input
	 */
	
	@Test(expected=ValueOutOfBoundsException.class) 
	public void tooHigh() throws ValueOutOfBoundsException, MalformedNumberException {
	    new RomanArabicConverter("4000").toRoman();
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
    public void inputEmptyString2() throws MalformedNumberException
    {
        new RomanArabicConverter("                      \n\n");
    }
	
	/*
	 * Testing ones place
	 */
	
	@Test (expected=MalformedNumberException.class)
	public void inputIIII() throws MalformedNumberException
	{
		new RomanArabicConverter("IIII");
	}
	
	@Test (expected=MalformedNumberException.class)
    public void inputIIV() throws MalformedNumberException
    {
        new RomanArabicConverter("IIV");
    }
	
	@Test (expected=MalformedNumberException.class)
    public void inputIIX() throws MalformedNumberException
    {
        new RomanArabicConverter("IIX");
    }

    @Test (expected=MalformedNumberException.class)
    public void inputVX() throws MalformedNumberException
    {
        new RomanArabicConverter("VX");
    }
    
    @Test (expected=MalformedNumberException.class)
    public void inputVV() throws MalformedNumberException
    {
        new RomanArabicConverter("VV");
    }
    
    @Test (expected=MalformedNumberException.class)
    public void inputIIIII() throws MalformedNumberException
    {
        new RomanArabicConverter("IIIII");
    }
    
    @Test (expected=MalformedNumberException.class)
    public void inputIIIXXX() throws MalformedNumberException
    {
        new RomanArabicConverter("IIIXXX");
    }
    
    /*
     * I tried to break the tens place somehow by mixing ones and tens, below are my tries that didn't work.
     */
    
    @Test (expected=MalformedNumberException.class)
    public void inputVLX() throws MalformedNumberException
    {
        new RomanArabicConverter("VLX");
    }
    
    @Test (expected=MalformedNumberException.class)
    public void inputIVLX() throws MalformedNumberException
    {
        new RomanArabicConverter("IVLX");
    }
    
    /*
     * THIS ONE WORKED YAY
     */
    @Test (expected=MalformedNumberException.class)
    public void inputDLIXLD() throws MalformedNumberException
    {
        new RomanArabicConverter("DLIXLD"); 
    }
    
    /*
     * Thousands
     */
    @Test (expected=MalformedNumberException.class)
    public void inputTasty() throws MalformedNumberException
    {
        new RomanArabicConverter("MMMM"); 
    }
    
    /*
     * Double check we can toArabic() negatives and out-of-bounds, even though we can't toRoman
     */
    @Test
    public void arabicOutOfBounds() throws MalformedNumberException {
        final RomanArabicConverter rac_low = new RomanArabicConverter("-1");
        final RomanArabicConverter rac_high = new RomanArabicConverter("124121");
        
        assertEquals(-1, rac_low.toArabic());
        assertEquals(124121, rac_high.toArabic());
    }
    
    /*
     * Okay at this point it's all implemented, lets try breaking it in weird ways.
     */
    
    @Test(expected=MalformedNumberException.class)
    public void spacesInWeirdPlaces() throws MalformedNumberException {
        new RomanArabicConverter("1 4");
    }
    
    @Test(expected=MalformedNumberException.class)
    public void absoluteGarbageInput() throws MalformedNumberException {
        new RomanArabicConverter("garbage");
    }
    
    @Test(expected=MalformedNumberException.class)
    public void absoluteGarbageInput4() throws MalformedNumberException {
        new RomanArabicConverter("IVgarbageIV");
    }
    
    @Test(expected=MalformedNumberException.class)
    public void lowerCase() throws MalformedNumberException {
        new RomanArabicConverter("iv"); // The Wikipedia article makes it seem like lowercase isn't allowed, so it isn't allowed :)
    }
    
    @Test(expected=MalformedNumberException.class)
    public void mixedInput() throws MalformedNumberException {
        new RomanArabicConverter("15IX");
    }
    
    @Test(expected=MalformedNumberException.class)
    public void mixedInput2() throws MalformedNumberException {
        new RomanArabicConverter("IX15");
    }
}
