package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeSubStringTest {

    @Test
    public void findLongestPalindromeSubStringRec() {
        String input = "forgeeksskeegfor";
        int expected = 10;
        int actual = LongestPalindromeSubString.findLongestPalindromeSubStringRec(input);
        assertEquals(expected,actual);
    }

    @Test
    public void findLongestPalindromeSubStringDP() {
    }
}