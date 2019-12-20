package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchElementInSortedRotatedArrayTest {

    @Test
    public void searchOne() {
        int[] input = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int key = 6;
        int expected = 2;
        int actual = SearchElementInSortedRotatedArray.search(input,key);
        assertEquals(expected,actual);
    }

    @Test
    public void searchTwo() {
        int[] input = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int key = 16;
        int expected = -1;
        int actual = SearchElementInSortedRotatedArray.search(input,key);
        assertEquals(expected,actual);
    }

    @Test
    public void searchThree() {
        int[] input = {4,5,6,7,0,1,2};
        int key = 0;
        int expected = 4;
        int actual = SearchElementInSortedRotatedArray.search(input,key);
        assertEquals(expected,actual);
    }

    @Test
    public void searchFour() {
        int[] input = {1,3,1,1,1};
        int key = 3;
        int expected = 3;
        int actual = SearchElementInSortedRotatedArray.search(input,key);
        assertEquals(expected,actual);
    }
}