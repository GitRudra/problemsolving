package org.home.ds.array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void cellCompete() {
        int[] input = {1,1,1,0,1,1,1,1};
        int count = 2;
        int[] expected = {0,0,0,0,0,1,1,0};
        List<Integer> actual = Solution.cellCompete(input,count);
        System.out.println(actual);
    }
}