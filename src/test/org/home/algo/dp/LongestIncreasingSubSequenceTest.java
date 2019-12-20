package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubSequenceTest {

    @Test(expected = Exception.class)
    public void calculateLisCornerCaseNullInput() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = null;
        lis.calculateLis(input);
    }

    @Test(expected = Exception.class)
    public void calculateLisCornerCaseEmptyArray() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = new int[0];
        lis.calculateLis(input);
    }

    @Test
    public void calculateLisCornerCaseArrayLengthOne() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {11};
        int expected = 1;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }

    @Test
    public void calculateLisCornerCaseArrayOne() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {14,21,7,10,5,8,9,20};
        int expected = 4;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }

    @Test
    public void calculateLisCornerCaseArrayTwo() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {5,8,9,20,14,2,7,19};
        int expected = 5;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }

    @Test
    public void calculateLisCornerCaseArrayThree() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {5,8,9,20,0,2,7,19};
        int expected = 4;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }

    @Test
    public void calculateLisCornerCaseArrayFour() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {14,2,7,9,15,8,17,20};
        int expected = 6;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }

    @Test
    public void calculateLisCornerCaseArrayFive() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {10,9,8,7,6,5,4,3,2,1};
        int expected = 1;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }

    @Test
    public void calculateLisCornerCaseArraySix() throws Exception {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] input = {10,11,9,8,7,6,5,4,3,2,1};
        int expected = 2;
        LongestIncreasingSubSequence.Result res = lis.calculateLis(input);
        assertEquals(expected,res.getLength());
    }


}