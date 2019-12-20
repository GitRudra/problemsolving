package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindPeakElementTest {

    @Test
    public void findPeakElementOne() {
        int[] nums = {1,2,3,1};
        int expected = 2;
        int actual = FindPeakElement.findPeakElement(nums);
        assertEquals(expected,actual);
    }
}