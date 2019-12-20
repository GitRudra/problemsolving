package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobbingProblemTest {

    @Test
    public void getMaximumRobbedValue() {
        int[] hval = {6, 7, 1, 3, 8, 2, 4};
        Integer expected = 19;
        HouseRobbingProblem soln = new HouseRobbingProblem();
        Integer actual = soln.getMaximumRobbedValue(hval);
        assertEquals(expected,actual);
    }

    @Test
    public void getMaximumRobbedValueTwo() {
        int[] hval = {5, 3, 4, 11, 2};
        Integer expected = 16;
        HouseRobbingProblem soln = new HouseRobbingProblem();
        Integer actual = soln.getMaximumRobbedValue(hval);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetMaximumRobbedValueCircularArrangementOfHouseOne(){
        int[] hval = {2,3,2};
        Integer expected = 3;
        HouseRobbingProblem soln = new HouseRobbingProblem();
        Integer actual = soln.getMaximumRobbedValueCircularArrangementOfHouse(hval);
        assertEquals(expected,actual);
    }
}