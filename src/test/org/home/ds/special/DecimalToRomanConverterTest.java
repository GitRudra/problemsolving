package org.home.ds.special;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalToRomanConverterTest {

    @Test
    public void romanToDecimalConverterOne() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        String romanLiteral = "VI";
        Integer value = converter.romanToDecimalConverter(romanLiteral);
        assertEquals(6,value.intValue());
    }

    @Test
    public void romanToDecimalConverterTwo() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        int expected = 4;
        String romanLiteral = "IV";
        Integer value = converter.romanToDecimalConverter(romanLiteral);
        assertEquals(expected,value.intValue());
    }

    @Test
    public void romanToDecimalConverterThree() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        int expected = 1;
        String romanLiteral = "I";
        Integer value = converter.romanToDecimalConverter(romanLiteral);
        assertEquals(expected,value.intValue());
    }

    @Test
    public void romanToDecimalConverterFour() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        int expected = 39;
        String romanLiteral = "XXXIX";
        Integer value = converter.romanToDecimalConverter(romanLiteral);
        assertEquals(expected,value.intValue());
    }

    @Test
    public void romanToDecimalConverterFive() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        int expected = 207;
        String romanLiteral = "CCVII";
        Integer value = converter.romanToDecimalConverter(romanLiteral);
        assertEquals(expected,value.intValue());
    }

    @Test
    public void romanToDecimalConverterSix() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();
        int expected = 246;
        String romanLiteral = "CCXLVI";
        Integer value = converter.romanToDecimalConverter(romanLiteral);
        assertEquals(expected,value.intValue());
    }
}