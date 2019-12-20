package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubSetSumProblemTest {

    @Test
    public void findSubSet() {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        SubSetSumProblem.findSubSet(set,sum);
    }
}