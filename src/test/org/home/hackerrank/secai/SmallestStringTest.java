package org.home.hackerrank.secai;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestStringTest {

    @Test
    public void smallestString() {
        int weight = 20;
        String expected = "AABBC";
        String actual = SmallestString.smallestString(weight);
        assertEquals(expected,actual);
    }
}