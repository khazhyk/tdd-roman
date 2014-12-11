/*******************************************************************************
 * Copyright (c) 2012 Gary F. Pollice
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  * Contributors:
 *    gpollice
 *    rpdabrowski
 *******************************************************************************/

package tdd;


/**
 * <p>
 * This class implements a converter that takes a string that represents a number in either Arabic
 * or Roman numeral form and offers methods that will return either the integer value or a string
 * representing the value in Roman numeral form.
 * </p>
 * <p>
 * Roman numerals are specified and presented as strings according to the <a
 * href="http://en.wikipedia.org/wiki/Roman_numerals#Reading_Roman_numerals"> Reading Roman
 * Numerals</a> section of the Wikipedia Roman Numerals Page.
 * </p>
 * <p>
 * <strong>NOTE</strong>:<br/>
 * You will not need to handle alternate forms like "IIII" etc. Also, the acceptable range of values
 * for numbers is 1..3999. 
 * 
 * @author rpdabrowski, gpollice
 * @version 2.0.1
 */
public class RomanArabicConverter
{
    /** The value held by this converter */
    private int value;
    
	/**
	 * Constructor that takes in a string. The string should contain either a valid Roman numeral or
	 * a valid Arabic numeral. The string can have leading and/or trailing spaces. There are no
	 * spaces within the actual number characters. If the string represents an Arabic number, it may
	 * be positive or negative. It will never be larger than a value that can fit into an int.
	 * 
	 * @param value
	 *            the string representing the Roman or Arabic number.
	 * @throws MalformedNumberException
	 *             if the string (less leading and trailing spaces) does not represent a valid Roman
	 *             or Arabic number. <strong>NOTE</strong>: an Arabic number may be out of the acceptable
	 *             range and will still be accepted by this constructor.
	 */
	public RomanArabicConverter(String value) throws MalformedNumberException
	{
		if (value.isEmpty()) throw new MalformedNumberException("Value must not be empty!");
		
		try {
		    this.value = Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {
		    this.value = parseRoman(value.trim());
		}
	}
	
	private int parseRoman(String value) throws MalformedNumberException {
	    int parsedVal = 0;
	    int iCount = 0;
	    for (int i = value.length() - 1; i >= 0; i--) {
	        if (value.charAt(i) == 'I') {
	            iCount += 1;
	            parsedVal += 1;
	            if (iCount > 3) throw new MalformedNumberException("To many 'I's! For example, use IV instead of IIII");
	        }
	    }
        return parsedVal;
	}

	/**
	 * @return the integer value of the number given
	 */
	public int toArabic()
	{
		return value;
	}

	/**
	 * @return the string that represents the value of the number as a Roman numeral.
	 * @throws ValueOutOfBoundsException
	 *             if the number is too small or too large to be represented using Roman numerals as
	 *             specified in <a
	 *             href="http://en.wikipedia.org/wiki/Roman_numerals#Reading_Roman_numerals">
	 *             Reading Roman Numerals</a>
	 *             
	 *             
	 *  Consider it by places - 1s place, 10s place, 100s place, 1000s place
	 *  1s place can accept I,V, up to IX,
	 *  10s is just like 1s, except with X, L, XC
	 *  100s C, D, CM
	 *  1000s is just M, so the max you can get is MMMCMXCIX, or 3999
	 */
	public String toRoman() throws ValueOutOfBoundsException
	{
	    if (value >= 4000 || value <= 0) throw new ValueOutOfBoundsException("Roman numerals must be between 1 and 3999, inclusive");
	    StringBuilder sb = new StringBuilder();
	    
	    int hunds = (value / 100) % 10;
	    sb.append(generatePlace('C','D','M', hunds));
	    int tens = (value / 10) % 10;
	    sb.append(generatePlace('X','L','C', tens));
	    int units = value % 10;
	    sb.append(generatePlace('I','V','X', units));

	    return sb.toString();
	}
	
	private String generatePlace(char placeUnit, char placeHalf, char nextPlace, int placeNum) {
	    StringBuilder sb = new StringBuilder();
	    if (placeNum < 4) {
	        for (int i = 0; i < placeNum; i++) {
	            sb.append(placeUnit);
	        }
	    } else if (placeNum == 4) {
	        sb.append(placeUnit).append(placeHalf);
	    } else if (placeNum > 4 && placeNum < 9) {
	        sb.append(placeHalf);
	        for (int i = 5; i < placeNum; i++) {
	            sb.append(placeUnit);
	        }
	    } else if (placeNum == 9) {
	        sb.append(placeUnit).append(nextPlace);
	    }
	    return sb.toString();
	}
}
