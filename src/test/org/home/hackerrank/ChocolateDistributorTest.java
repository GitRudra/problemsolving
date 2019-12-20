package org.home.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ChocolateDistributorTest {

    @Test
    public void testBirthdayOne() {
        Integer[] sArray = {1, 2, 1, 3, 1};
        int d = 3;
        int m = 2;
        int expected = 2;
        int actual = ChocolateDistributor.birthday(Arrays.asList(sArray), d, m);
        assertEquals(expected, actual);
    }

    @Test
    public void testBirthdayTwo() {
        Integer[] sArray = {4};
        int d = 4;
        int m = 1;
        int expected = 1;
        int actual = ChocolateDistributor.birthday(Arrays.asList(sArray), d, m);
        assertEquals(expected, actual);
    }

    @Test
    public void testBirthdayThree() {
        Integer[] sArray = {1, 1, 1, 1, 1, 1};
        int d = 3;
        int m = 2;
        int expected = 0;
        int actual = ChocolateDistributor.birthday(Arrays.asList(sArray), d, m);
        assertEquals(expected, actual);
    }
}