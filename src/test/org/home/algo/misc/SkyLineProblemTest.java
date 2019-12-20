package org.home.algo.misc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SkyLineProblemTest {

    @Test
    public void getSkyline() {
        int[][] buildings  = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        SkyLineProblem skyProb = new SkyLineProblem();
        List<List<Integer>> result = skyProb.getSkyline(buildings);
        System.out.println(result);
    }
}