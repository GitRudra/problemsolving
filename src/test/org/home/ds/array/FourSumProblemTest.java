package org.home.ds.array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FourSumProblemTest {

    @Test
    public void fourSum() {
        int[] input = {1,0,-1,0,-2,2};
        int target = 0;
        FourSumProblem solver = new FourSumProblem();
        List<List<Integer>> result = solver.fourSum(input,target);
        System.out.println(result);
    }
}