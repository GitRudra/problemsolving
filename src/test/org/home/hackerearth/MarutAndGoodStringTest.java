package org.home.hackerearth;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarutAndGoodStringTest {

    @Test
    public void marutGoodStringConverterOne() {
        String input = "123A";
        String expected = "0";
        String actual = MarutAndGoodString.marutGoodStringConverter(input);
        assertEquals(expected,actual);
    }

    @Test
    public void marutGoodStringConverterTwo() {
        String input = "123@!89";
        String expected = "Invalid Input";
        String actual = MarutAndGoodString.marutGoodStringConverter(input);
        assertEquals(expected,actual);
    }

    @Test
    public void marutGoodStringConverterThree() {
        String input = "HackerEarth";
        String expected = "2";
        String actual = MarutAndGoodString.marutGoodStringConverter(input);
        assertEquals(expected,actual);
    }
}