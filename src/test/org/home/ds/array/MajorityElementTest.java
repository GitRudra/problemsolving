package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

    @Test
    public void majorityElementOne() {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int expected = 4;
        int actual = MajorityElement.majorityElement(arr);
        assertEquals(expected,actual);
    }

    @Test
    public void majorityElementTwo() {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4};
        int expected = -1;
        int actual = MajorityElement.majorityElement(arr);
        assertEquals(expected,actual);
    }
}