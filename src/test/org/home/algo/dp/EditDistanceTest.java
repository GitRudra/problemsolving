package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    @Test
    public void testEditDistanceRecursiveOne() {
        String str1 = "sunday";
        String str2 = "saturday";
        int expected = 3;
        int actual = EditDistance.editDistanceRecursive(str1, str2);
        assertEquals(expected,actual);
    }
    @Test
    public void testEditDistanceRecursiveTwo() {
        String str1 = "sunday";
        String str2 = "saturday";
        int expected = 3;
        int actual = EditDistance.editDistanceIterative(str1, str2);
        assertEquals(expected,actual);
    }

    @Test
    public void testEditDistanceRecursiveThree() {
        String str2 = "abppplee";
        String str1 = "apple";
        int expected = 3;
        int actual = EditDistance.editDistanceIterative(str1, str2);
        assertEquals(expected,actual);
    }
}