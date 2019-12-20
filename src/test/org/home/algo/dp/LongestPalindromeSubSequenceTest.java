package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeSubSequenceTest {

    @Test
    public void testFindLongestCommonSubSequenceOne() {
        String input = "geeksforgeeks";
        int expected = 5;
        int actual = LongestPalindromeSubSequence
                .findLongestPalindromeSubSequence(input);
        assertEquals(expected,actual);
    }
    @Test
    public void testFindLongestCommonSubSequenceTwo() {
        String input = "g";
        int expected = 1;
        int actual = LongestPalindromeSubSequence
                .findLongestPalindromeSubSequence(input);
        assertEquals(expected,actual);
    }
    @Test
    public void testFindLongestCommonSubSequenceThree() {
        String input = "";
        int expected = 0;
        int actual = LongestPalindromeSubSequence
                .findLongestPalindromeSubSequence(input);
        assertEquals(expected,actual);
    }
    @Test
    public void testFindLongestCommonSubSequenceFour() {
        String input = "abdba";
        int expected = 5;
        int actual = LongestPalindromeSubSequence
                .findLongestPalindromeSubSequence(input);
        assertEquals(expected,actual);
    }
    @Test
    public void testFindLongestCommonSubSequenceFive() {
        String input = "abcdefgh";
        int expected = 1;
        int actual = LongestPalindromeSubSequence
                .findLongestPalindromeSubSequence(input);
        assertEquals(expected,actual);
    }
}