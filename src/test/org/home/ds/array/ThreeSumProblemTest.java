package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumProblemTest {

    @Test
    public void testFindThreeSumOne() {
        ThreeSumProblem problemSolver = new ThreeSumProblem();
        int[] input = {-1, 0, 1, 2, -1, -4};
        problemSolver.findThreeSum(input);

    }
}