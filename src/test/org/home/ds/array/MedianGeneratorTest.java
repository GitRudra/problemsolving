package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianGeneratorTest {

    @Test
    public void calculateMedianOfTwoSortedArrayWithSameSizeOne() throws Exception {
        int[] a1 = {1,3,5,7,9,11,13,15};
        int[] a2 = {2,4,6,8,10,12,14,16};
        double expected = 8.5;
        double actual = MedianGenerator.calculateMedianOfTwoSortedArrayWithSameSize(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void calculateMedianOfTwoSortedArrayWithSameSizeThree() throws Exception {
        int[] a1 = {1, 12, 15, 26, 38};
        int[] a2 = {2, 13, 17, 30, 45};
        double expected = 16;
        double actual = MedianGenerator.calculateMedianOfTwoSortedArrayWithSameSize(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void calculateMedianOfTwoSortedArrayWithSameSizeFour() throws Exception {
        int[] a1 = {1,3,5,7,9,11,13,15};
        int[] a2 = {2,4,6,8,10,12,14,16};
        double expected = 8.5;
        double actual = MedianGenerator.calculateMedianOfTwoSortedArrayWithSameSize(a2,a1);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void medianOfSortedArrayOfDifferentSizeOne() throws Exception {
        int[] a1 = {};
        int[] a2 = {2, 4};
        double expected = 3;
        double actual = MedianGenerator.medianOfSortedArrayOfDifferentSize(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
    @Test
    public void medianOfSortedArrayOfDifferentSizeTwo() throws Exception {
        int[] a1 = {3,4};
        int[] a2 = {};
        double expected = 3.5;
        double actual = MedianGenerator.medianOfSortedArrayOfDifferentSize(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
    @Test
    public void medianOfSortedArrayOfDifferentSizeThree() throws Exception {
        int[] a1 = {4};
        int[] a2 = {2};
        double expected = 3;
        double actual = MedianGenerator.medianOfSortedArrayOfDifferentSize(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
        //MedianGenerator.calculateMedianOfTwoSortedArrayWithSameSize(a1,a2);
    }



    @Test
    public void testGetMedianOne(){
        int[] a1 = {1,2,3};
        double expected = 2;
        double actual = MedianGenerator.getMedian(a1,0, a1.length-1);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
    @Test
    public void testGetMedianTwo(){
        int[] a1 = {1,2,3,4};
        double expected = 2.5;
        double actual = MedianGenerator.getMedian(a1,0, a1.length-1);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
    @Test
    public void testGetMedianThree(){
        int[] a1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        double expected = 8.5;
        double actual = MedianGenerator.getMedian(a1,0, a1.length-1);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }

    @Test
    public void calculateMedianOfTwoSortedArrayWithSameSizeTwo() throws Exception {
        int[] a1 = {1,3,5,7,9,11,13,15};
        int[] a2 = {};
        double expected = 8.0;
        double actual = MedianGenerator.calculateMedianOfTwoSortedArrayWithSameSize(a1,a2);
        double delta = 0;
        assertEquals(expected,actual,delta);
    }
}