package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArrayTest {

    @Test
    public void calculateMedianOfSortedArrayOne() {
        int[] a = {1,3};
        int[] b ={2};
        double expected = 2;
        double actual  = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a,b);

        assertEquals(expected,actual,.0001);
    }

    @Test
    public void calculateMedianOfSortedArrayTwo() {
        int[] a = {1,2};
        int[] b = {3,4};
        double expected = 2.5;
        double actual  = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a,b);

        assertEquals(expected,actual,.0001);
    }

    @Test
    public void calculateMedianOfSortedArrayThree() throws Exception {
        int[] a1 = {1, 12, 15, 26, 38};
        int[] a2 = {2, 13, 17, 30, 45};
        double expected = 16;
        double actual = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void calculateMedianOfSortedArrayFour() throws Exception {
        int[] a1 = {1,3,5,7,9,11,13,15};
        int[] a2 = {2,4,6,8,10,12,14,16};
        double expected = 8.5;
        double actual = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a2,a1);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void medianOfSortedArrayOfDifferentSizeOne() throws Exception {
        int[] a1 = {};
        int[] a2 = {2, 4};
        double expected = 3;
        double actual = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
    @Test
    public void medianOfSortedArrayOfDifferentSizeTwo() throws Exception {
        int[] a1 = {3,4};
        int[] a2 = {};
        double expected = 3.5;
        double actual = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
    @Test
    public void medianOfSortedArrayOfDifferentSizeThree() throws Exception {
        int[] a1 = {4};
        int[] a2 = {2};
        double expected = 3;
        double actual = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
        //MedianGenerator.calculateMedianOfSortedArray(a1,a2);
    }

    @Test
    public void calculateMedianOfSortedArrayEight() throws Exception {
        int[] a1 = {1,3,5,7,9,11,13,15};
        int[] a2 = {};
        double expected = 8.0;
        double actual = MedianOfTwoSortedArray.calculateMedianOfSortedArray(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
}