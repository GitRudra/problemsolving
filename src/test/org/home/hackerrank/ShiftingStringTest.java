package org.home.hackerrank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShiftingStringTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getShiftedStringOne() {
        String input = "abcd";
        int leftShift = 1;
        int rightShift = 2;
        String expected = "dabc";
        String actual = ShiftingString.getShiftedString(input,leftShift,rightShift);
        assertEquals(expected,actual);
    }
}