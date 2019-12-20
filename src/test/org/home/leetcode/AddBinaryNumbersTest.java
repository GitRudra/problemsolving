package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddBinaryNumbersTest {

    @Test
    public void addBinaryOne() {
        String a = "01";
        String b = "10";
        String expected = "11";
        String actual  = AddBinaryNumbers.addBinary(a,b);
        assertEquals(expected,actual);
    }

    @Test
    public void addBinaryTwo() {
        String a = "11";
        String b = "10";
        String expected = "101";
        String actual  = AddBinaryNumbers.addBinary(a,b);
        assertEquals(expected,actual);
    }
}