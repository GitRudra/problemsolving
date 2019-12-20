package org.home.ds.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInsertPositionTest {

    @Test
    public void searchInsertOne() {
        int[] nums = {1,3,5,6,7,9,11,13};
        int target = 4;
        int expected = 2;
        int actual = SearchInsertPosition.searchInsert(nums,target);
        assertEquals(expected,actual);
    }
    @Test
    public void searchInsertTwo() {
        int[] nums = {1,3,4,5,6,7,9,11,13};
        int target = 4;
        int expected = 2;
        int actual = SearchInsertPosition.searchInsert(nums,target);
        assertEquals(expected,actual);
    }

    @Test
    public void searchInsertThree() {
        int[] nums = {1,3,4,5,6,7,9,11,13};
        int target = 14;
        int expected = 9;
        int actual = SearchInsertPosition.searchInsert(nums,target);
        assertEquals(expected,actual);
    }
}