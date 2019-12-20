package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareRootTest {

    @Test
    public void sqrtOne() {
        int x = 20;
        long expected = 4;
        long actual = SquareRoot.sqrt(x);
        assertEquals(expected,actual);
    }

    @Test
    public void sqrtTwo() {
        int x = 4;
        long expected = 2;
        long actual = SquareRoot.sqrt(x);
        assertEquals(expected,actual);
    }


    @Test
    public void sqrtThree() {
        int x = 8;
        long expected = 2;
        long actual = SquareRoot.sqrt(x);
        assertEquals(expected,actual);
    }

    @Test
    public void sqrtFour() {
        int x = 2147395599;
        long expected = 46339;
        long actual = SquareRoot.sqrt(x);
        assertEquals(expected,actual);
    }

    @Test
    public void sqrtFive() {
        int x = 1;
        long expected = 1;
        long actual = SquareRoot.sqrt(x);
        assertEquals(expected,actual);
    }


}