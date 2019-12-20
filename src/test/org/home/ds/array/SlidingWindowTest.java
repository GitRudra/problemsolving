package org.home.ds.array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SlidingWindowTest {

    @Test
    public void testFindNegativeIntegersInSubArrayOfSizeKOne() throws Exception {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 2;
        List<Integer> actualList = SlidingWindow.findNegativeIntegersInSubArrayOfSizeK(arr,k);
        Integer[] expected = {-1, -1, -7, -15, -15, 0,0};
        Integer[]T = new Integer[actualList.size()];
        assertArrayEquals(expected,actualList.toArray(T));
    }

    @Test
    public void testFindNegativeIntegersInSubArrayOfSizeKTwo()throws Exception {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> actualList = SlidingWindow.findNegativeIntegersInSubArrayOfSizeK(arr,k);
        Integer[] expected = {-1, -1, -7, -15, -15, 0};
        Integer[]T = new Integer[actualList.size()];
        assertArrayEquals(expected,actualList.toArray(T));
    }
    @Test(expected = Exception.class)
    public void testFindNegativeIntegersInSubArrayOfSizeKThree()throws Exception {
        int arr[] = null;
        int k = 3;
        List<Integer> actualList = SlidingWindow.findNegativeIntegersInSubArrayOfSizeK(arr,k);
        //Integer[] expected = {-1, -1, -7, -15, -15, 0,0};
        //Integer[]T = new Integer[actualList.size()];
        //assertArrayEquals(expected,actualList.toArray(T));
    }

    @Test(expected = Exception.class)
    public void testFindNegativeIntegersInSubArrayOfSizeKFour()throws Exception {
        int arr[] = {};
        int k = 3;
        List<Integer> actualList = SlidingWindow.findNegativeIntegersInSubArrayOfSizeK(arr,k);
    }

    @Test(expected = Exception.class)
    public void testFindNegativeIntegersInSubArrayOfSizeKFive()throws Exception {
        int arr[] = {1,2};
        int k = 3;
        List<Integer> actualList = SlidingWindow.findNegativeIntegersInSubArrayOfSizeK(arr,k);
    }

    @Test
    public void testFindMaximumInEachSubArrayOfSizeKOne() throws Exception {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        List<Integer> actualList = SlidingWindow.findMaximumInEachSubArrayOfSizeK(arr,k);
        Integer[] expected = { 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[]T = new Integer[actualList.size()];
        assertArrayEquals(expected,actualList.toArray(T));
    }

    @Test
    public void testFindMaximumInEachSubArrayOfSizeKTwo() throws Exception {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        List<Integer> actualList = SlidingWindow.findMaximumInEachSubArrayOfSizeK(arr,k);
        Integer[] expected = { 78,90,90,90,89};
        Integer[]T = new Integer[actualList.size()];
        assertArrayEquals(expected,actualList.toArray(T));
    }

    @Test
    public void testFindFirstNegativeIntegerOne() {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        int expected[] = {-1, -1, -7, -15, -15, 0};
        int actual[] = SlidingWindow.findFirstNegativeInteger(arr, k);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindFirstNegativeIntegerTwo() {
        int arr[] = {-8, 2, 3, -6, 10};
        int k = 2;
        int expected[] = {-8, 0, -6, -6};
        int actual[] = SlidingWindow.findFirstNegativeInteger(arr, k);
        assertArrayEquals(expected, actual);

    }
}