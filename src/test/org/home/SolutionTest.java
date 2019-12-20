package org.home;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getSeatPositionOne() throws Exception {
        Solution sol = new Solution();
        int seatno = 68;
        String compType = "Tier3";
        String expected = "LB";
        String actual = sol.getSeatPosition(compType,seatno);
    }

    @Test
    public void getSeatPositionTwo() throws Exception {
        Solution sol = new Solution();
        int seatno = 24;
        String compType = "Tier2";
        String expected = "SU";
        String actual = sol.getSeatPosition(compType,seatno);
    }
}