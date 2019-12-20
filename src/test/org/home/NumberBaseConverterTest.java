package org.home;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberBaseConverterTest {

    @Test
    public void getHexRepresentationOne() {
        int number = 11;
        int base = 3;
        String expected = "102";
        NumberBaseConverter converter = new NumberBaseConverter();
        String actual = converter.getHexRepresentation(number,base);
        assertEquals(expected,actual);
    }

    @Test
    public void getHexRepresentationTwo() {
        int number = 4;
        int base = 2;
        String expected = "100";
        NumberBaseConverter converter = new NumberBaseConverter();
        String actual = converter.getHexRepresentation(number,base);
        assertEquals(expected,actual);
    }

    @Test
    public void getHexRepresentationThree() {
        int number = 11;
        int base = 10;
        String expected = "11";
        NumberBaseConverter converter = new NumberBaseConverter();
        String actual = converter.getHexRepresentation(number,base);
        assertEquals(expected,actual);
    }


    @Test
    public void getHexRepresentationFour() {
        int number = 55;
        int base = 16;
        String expected = "37";
        NumberBaseConverter converter = new NumberBaseConverter();
        String actual = converter.getHexRepresentation(number,base);
        assertEquals(expected,actual);
    }
}