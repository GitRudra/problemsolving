package org.home.algo.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPossibleChunkedPalindromeFinderTest {

    @Test
    public void testFindPalindromeChunkOne() {
        String input = "geeksforgeeks";
        LongestPossibleChunkedPalindromeFinder.findPalindromeChunk(input);

    }

    @Test
    public void testFindPalindromeChunkTwo() {
        String input = "antaprezatepzapreanta";
        LongestPossibleChunkedPalindromeFinder.findPalindromeChunk(input);

    }

    @Test
    public void testFindPalindromeChunkThree() {
        String input = "antaprezatepzapreanta";
        int expected = 11;
        int actual = LongestPossibleChunkedPalindromeFinder.findLPC(input);
        assertEquals(expected, actual);

    }
}