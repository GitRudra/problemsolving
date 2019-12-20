package org.home.algo.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeOne() {
        int[] input = {8,4};
        int[] expected = {4,8};
        MergeSort sort = new MergeSort();
        sort.merge(input,0,0,1);
        assertArrayEquals(expected,input);
    }

    @Test
    public void mergeTwo() {
        int[] input = {8,9,5};
        int[] expected = {5,8,9};
        MergeSort sort = new MergeSort();
        sort.merge(input,0,1,2);
        assertArrayEquals(expected,input);
    }

    @Test
    public void sortOne() {
        int[] input = {8,4};
        int[] expected = {4,8};
        MergeSort sort = new MergeSort();
        sort.sort(input,0,input.length-1);
        assertArrayEquals(expected,input);
    }

    @Test
    public void sortTwo() {
        int[] input = {8,4,5};
        int[] expected = {4,5,8};
        MergeSort sort = new MergeSort();
        sort.sort(input,0,input.length-1);
        assertArrayEquals(expected,input);
    }

    @Test
    public void sortThree() {
        int[] input = {8,4,5,1,3,5,8,9,11,21,13,26,22};
        int[] expected = {1,3,4,5,5,8,8,9,11,13,21,22,26};
        MergeSort sort = new MergeSort();
        sort.sort(input,0,input.length-1);
        assertArrayEquals(expected,input);
    }


    @Test
    public void mergeSort() {
    }
}