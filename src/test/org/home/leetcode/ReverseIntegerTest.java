package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {

    @Test
    public void reverseOne() {
        int x = 123;
        int expected = 321;
        int actual  = ReverseInteger.reverse(x);
        assertEquals(expected,actual);
    }

    @Test
    public void reverseTwo() {
        int x = -123;
        int expected = -321;
        int actual  = ReverseInteger.reverse(x);
        assertEquals(expected,actual);
    }

    @Test
    public void reverseThree() {
        int x = 0;
        int expected = 0;
        int actual  = ReverseInteger.reverse(x);
        assertEquals(expected,actual);
    }

    @Test
    public void reverseFour() {
        int x = 1534236469;
        int expected = 0;
        int actual  = ReverseInteger.reverse(x);
        assertEquals(expected,actual);
    }


    @Test
    public void reverseFive() {
        int x = 900000;
        int expected = 9;
        int actual  = ReverseInteger.reverse(x);
        assertEquals(expected,actual);
    }
    @Test
    public void reverseSix() {
        int x = 1534236469;
        int expected = 0;
        int actual  = ReverseInteger.reverse(x);
        assertEquals(expected,actual);
    }
}