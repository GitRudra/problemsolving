package org.home.ds.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumInRotatedSortedArrayTest {

    @Test
    public void findMinOne() {
        int[] input = {4,5,6,7,0,1,2};
        int expected = 0;
        int actual = MinimumInRotatedSortedArray.findMin(input);
        assertEquals(expected,actual);
    }

    @Test
    public void findMinTwo() {
        int[] input = {2,4,5,6,7,0,1};
        int expected = 0;
        int actual = MinimumInRotatedSortedArray.findMin(input);
        assertEquals(expected,actual);
    }

    @Test
    public void findMinThree() {
        int[] input = {0,1,2,4,5,6,7};
        int expected = 0;
        int actual = MinimumInRotatedSortedArray.findMin(input);
        assertEquals(expected,actual);
    }

    @Test
    public void findMinFour() {
        int[] input = {7,0,1,2,4,5,6};
        int expected = 0;
        int actual = MinimumInRotatedSortedArray.findMin(input);
        assertEquals(expected,actual);
    }

    @Test
    public void findMinFive() {
        int[] input = {7,1,2,4,5,6};
        int expected = 1;
        int actual = MinimumInRotatedSortedArray.findMin(input);
        assertEquals(expected,actual);
    }
}