package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class RodCuttingProblemTest {

    @Test
    public void getRodCuttingMaxValue() {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int expected = 22;
        RodCuttingProblem solver = new RodCuttingProblem();
        int actual = solver.getRodCuttingMaxValue(arr);
    }
}