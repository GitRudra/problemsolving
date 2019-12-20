package org.home.ds.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void insertionSort01RandomInput() {
        int[] input = {3, 7, 4, 9, 5, 2, 6, 1};
        Sort sort = new Sort();
        sort.insertionSort(input);
        Arrays.stream(input).forEach(x-> System.out.print(x+" "));
    }
    @Test
    public void insertionSort02SortedInput() {
        int[] input = {1,2,3,4,5,6,7,8,9};
        Sort sort = new Sort();
        sort.insertionSort(input);
        Arrays.stream(input).forEach(x-> System.out.print(x+" "));
    }

    @Test
    public void testQuickSortOne(){
        int[] input = {3, 7, 4, 9, 5, 2, 6, 1};
        Sort sort = new Sort();
        sort.quickSort(input);
        Arrays.stream(input).forEach(x-> System.out.print(x+" "));
    }

    @Test
    public void testQuickSortTwo(){
        int[] input = {3,2,5,6,3,1,8,9,4,7,6,11,21,10};
        Sort sort = new Sort();
        sort.quickSort(input);
        Arrays.stream(input).forEach(x-> System.out.print(x+" "));
    }
}