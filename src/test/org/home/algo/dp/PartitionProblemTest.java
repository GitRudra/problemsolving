package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionProblemTest {

    @Test
    public void testPartitionWithEqualSumRecursive() {
        int arr[] = {3, 1, 5, 9, 12};
        assertTrue(PartitionProblem.partitionWithEqualSumRecursive(arr));

    }

    @Test
    public void partitionWithEqualSumIterative() {
        int arr[] = {3, 1, 5, 9, 12};
        assertTrue(PartitionProblem.partitionWithEqualSumIterative(arr));

    }

    @Test
    public void partitionWithMinAbsDifferenceOne() {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int expected = 1;
        int actual = PartitionProblem.partitionWithMinAbsDifference(arr);
        assertEquals(expected,actual);

    }
}