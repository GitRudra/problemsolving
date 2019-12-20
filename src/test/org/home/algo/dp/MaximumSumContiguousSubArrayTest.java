package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSumContiguousSubArrayTest {

    @Test
    public void getMSCSAOne() {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        int expected = 7;
        int actual = MaximumSumContiguousSubArray.getMSCSA(input);
        assertEquals(expected, actual);
    }

    @Test
    public void getMSCSATwo() {
        int[] input = {-2, -3, -4, -1, -5};
        int expected = -1;
        int actual = MaximumSumContiguousSubArray.getMSCSAKadane(input);
        assertEquals(expected, actual);
    }


    @Test
    public void getMSCSAThree() {
        int[] input = null;
        int expected = 0;
        int actual = MaximumSumContiguousSubArray.getMSCSAKadane(input);
        assertEquals(expected, actual);
    }

    @Test
    public void getMSCSAKadaneOne() {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        int expected = 7;
        int actual = MaximumSumContiguousSubArray.getMSCSAKadane(input);
        assertEquals(expected, actual);
    }

    @Test
    public void getMSCSAKadaneTwo() {
        int[] input = {-2, -3, -4, -1, -5};
        int expected = -1;
        int actual = MaximumSumContiguousSubArray.getMSCSAKadane(input);
        assertEquals(expected, actual);
    }

    @Test
    public void getMSCSAKadaneThree() {
        int[] input = null;
        int expected = 0;
        int actual = MaximumSumContiguousSubArray.getMSCSAKadane(input);
        assertEquals(expected, actual);
    }
}