package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixSumArrayTest {

    @Test
    public void testLongestBalancedPrefixOne() {
        String input = "((((()";
        System.out.println(PrefixSumArray.longestBalancedPrefix(input));
    }

    @Test
    public void testLongestBalancedPrefixTwo() {
        String input = "()))))))";
        int expected = 2;
        int actual = PrefixSumArray.longestBalancedPrefix(input);
        assertEquals(expected,actual);
       // System.out.println(PrefixSumArray.longestBalancedPrefix(input));
    }

    @Test
    public void testFindSubArrayWithSumZero() throws Exception {
        int[] input = {4, 2, -3, 1, 6};
        assertTrue(PrefixSumArray.findSubArrayWithSumZero(input));
    }
    @Test
    public void testFindSubArrayWithSumZeroTwo() throws Exception {
        int[] input = {1, 4, -2, -2, 5, -4, 3};
        assertTrue(PrefixSumArray.findSubArrayWithSumZero(input));
    }


}